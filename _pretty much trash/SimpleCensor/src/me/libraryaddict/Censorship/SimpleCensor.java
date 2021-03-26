package me.libraryaddict.Censorship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleCensor extends JavaPlugin implements Listener {
  boolean enabled = true;
  @SuppressWarnings({ "unchecked", "rawtypes" })
Map<Integer, Storage> censors = new HashMap();
  @SuppressWarnings({ "unchecked", "rawtypes" })
Map<String, String> censorWords = new HashMap();
  @SuppressWarnings({ "unchecked", "rawtypes" })
Map<String, Commands> commands = new HashMap();
  @SuppressWarnings({ "unchecked", "rawtypes" })
ConcurrentLinkedQueue<String> exceptions = new ConcurrentLinkedQueue();
  boolean showSenderReal = false;
  boolean displayWords = false;
  boolean censorMe = false;
  boolean correctCaps = true;
  boolean capNormNames = false;
  boolean useDisplay = false;
  int repeations = 1000;
  int messageCaps = 0;
  int amountOfCaps = -1;
  int sched = 0;
  Player[] players = new Player[0];
  @SuppressWarnings({ "unchecked", "rawtypes" })
List<String> dontDeCaps = new ArrayList();
  
  class Commands {
    Integer words;
    boolean caps;
  }
  
  class Storage {
    String naughtyWord;
    Pattern pattern;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<String> censors = new ArrayList();
    Storage() {}
  }
  
  public void onEnable()  {
    PluginManager manager = getServer().getPluginManager();
    manager.registerEvents(this, this);
    loadConfig();
    if (getConfig().getInt("Priority") == 0)
      manager.registerEvents(new MonitorListener(this), this);
    else manager.registerEvents(new LowestListener(this), this);
  }

  void loadConfig() {
    saveDefaultConfig();
    reloadConfig();
    this.showSenderReal = getConfig().getBoolean("ShowSenderCensored");
    this.censorMe = getConfig().getBoolean("CensorMe");
    this.correctCaps = getConfig().getBoolean("CorrectCaps");
    this.displayWords = (!getConfig().getBoolean("HideWords"));
    this.amountOfCaps = getConfig().getInt("CapsToStrikeAt");
    this.messageCaps = getConfig().getInt("MsgLengthForCaps");
    this.capNormNames = getConfig().getBoolean("CapitalizePlayerNames");
    this.useDisplay = getConfig().getBoolean("UseDisplayNames");
    this.repeations = getConfig().getInt("Repeations", 1000);
    //this.doSpecial = getConfig().getBoolean("CensorBypasses", false);
    List<String> rules = getConfig().getStringList("censored");
    this.dontDeCaps = getConfig().getStringList("CapsLeaveAlone");
    for (String st : getConfig().getStringList("exceptions")) {
      this.exceptions.add(st.toLowerCase());
    } for (String st : getConfig().getStringList("CensorCommands")) {
      String[] str = st.split(" ");
      Commands c = new Commands();
      c.caps = (!Boolean.parseBoolean(str[2]));
      c.words = Integer.valueOf(Integer.parseInt(str[1]));
      this.commands.put(str[0].toLowerCase(), c);
    }
    this.censors.clear();
    if (rules == null) {
      Bukkit.getLogger().log(Level.SEVERE, "[SimpleCensor] Unable to find the censored word list");
      getServer().getPluginManager().disablePlugin(this);
    } for (String s : rules) {
      String[] censored = s.split(":");
      censored[0] = ChatColor.translateAlternateColorCodes('&', censored[0]).toLowerCase();
      censored[1] = ChatColor.translateAlternateColorCodes('&', censored[1]).toLowerCase();
      if (getStorage(censored[0]) != null)
      {
        Storage censor = getStorage(censored[0]);
        censor.censors.add(censored[1]);
      } else {
        Storage storage = new Storage();
        storage.censors.add(censored[1]);
        storage.naughtyWord = censored[0];
        
        String pattern = "(?i)";
        char[] chars = censored[0].toCharArray();
        for (int pos = 0; pos < chars.length; pos++) {
          pattern = pattern + Pattern.quote(new StringBuilder().append(chars[pos]).toString()) + (pos + 1 == chars.length ? "+" : "+[^A-Za-z]*");
        }
        storage.pattern = Pattern.compile(pattern);
        this.censors.put(Integer.valueOf(this.censors.size()), storage);
      }
    }
    for (String s : getConfig().getStringList("correctwords")) {
      String[] censored = s.split(":");
      censored[0] = ChatColor.translateAlternateColorCodes('&', censored[0]).toLowerCase();
      censored[1] = ChatColor.translateAlternateColorCodes('&', censored[1]);
      this.censorWords.put(censored[0], censored[1]);
    }
  }
  
  Storage getStorage(String censor) {
    for (Storage storages : this.censors.values()) {
      if (storages.naughtyWord.equals(censor))
        return storages;
    }
    return null;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler(priority=EventPriority.MONITOR)
  public void commandPreprocess(PlayerCommandPreprocessEvent event) {
    if ((event.isCancelled()) || (event.getPlayer().hasPermission("censor.bypass.filter"))) return;
    //if ((event.isCancelled()) || (this.perms.contains(event.getPlayer().getName()))) return;
	  //TODO Perms Here
    
    String[] words = event.getMessage().split(" ");
    String commandName = words[0].toLowerCase();
    if (!this.commands.containsKey(commandName)) {
      return;
    }
    String add = "";
    Commands c = (Commands)this.commands.get(commandName);
    int skip = commandName.length() + 1 + c.words.intValue();
    for (int i = 1; i < c.words.intValue() + 1; i++) {
      skip += words[i].length();
      add = add + words[i] + " ";
    }
    if ((event.getMessage().length() > skip) && 
      (this.enabled) && (event.getPlayer().hasPermission("censor.bypass.filter")))  {
  	  //TODO Perms Here
      String[] message = censorMessage(event.getMessage().substring(skip), c.caps);
      if ((!this.showSenderReal) && (this.censorMe) && (commandName.equalsIgnoreCase("/me")) && (!message[1].equals(message[0]))) {
        event.setCancelled(true);
        for (Player p : event.getRecipients()) {
          if (p != event.getPlayer())
            p.sendMessage("* " + event.getPlayer().getName() + " " + message[0]);
        }
        Bukkit.getLogger().info(event.getPlayer().getName() + " issued server command: " + message[0]);
        event.getPlayer().sendMessage("* " + event.getPlayer().getName() + " " + message[1]);
      }
      event.setMessage(commandName + " " + add + message[0]);
    }
  }
  
  String[] censorMessage(String message, boolean capsFirst) {
    String hisMessage = message;
    message = censor(message, this.exceptions.iterator());
    for (String st : this.censorWords.keySet()) {
      message = getWord(message, st, (String)this.censorWords.get(st));
      if (this.displayWords) {
        hisMessage = getWord(hisMessage, st, (String)this.censorWords.get(st));
      }
    }
    if (this.showSenderReal)
      hisMessage = removeRepetitions(hisMessage);
    message = removeRepetitions(message);
    if ((this.correctCaps) && (amountOfCaps(message) / message.length() * 100.0D >= this.amountOfCaps) && (message.length() >= this.messageCaps))
      message = correctCaps(message, capsFirst);
    if (this.showSenderReal) {
      hisMessage = message;
    } else if ((this.correctCaps) && 
      (amountOfCaps(hisMessage) / hisMessage.length() * 100.0D >= this.amountOfCaps) && 
      (hisMessage.length() >= this.messageCaps)) {
      hisMessage = correctCaps(hisMessage, capsFirst);
    }
    for (Player p : this.players) {
      if (p.isOnline()) {
        if (this.capNormNames) {
          hisMessage = hisMessage.replaceAll("(?i)" + p.getName(), p.getName());
          message = message.replaceAll("(?i)" + p.getName(), p.getName());
        }
        if (this.useDisplay) {
          hisMessage = hisMessage.replace(p.getName(), p.getDisplayName());
          message = message.replace(p.getName(), p.getDisplayName());
          hisMessage = hisMessage.replace(p.getDisplayName(), p.getDisplayName());
          message = message.replace(p.getDisplayName(), p.getDisplayName());
        }
      }
    }
    return new String[] {message, hisMessage};
  }
  
  String censor(String toCensor, Iterator<String> itel) {
      int newInt = 0;
    if (itel.hasNext()) {
      String exception = (String)itel.next();
      String[] split = toCensor.split("(?i)" + exception, -1);
      for (int n = 0; n < split.length; n++) {
        split[n] = censor(split[n], itel);
      }
      return StringUtils.join(split, exception);
    }
    for (int i = 0; i < this.censors.size(); i++) {
      Storage storage = (Storage)this.censors.get(Integer.valueOf(i));
        newInt = 0;
        if (storage.censors.size() > 1) {
          newInt = new Random().nextInt(storage.censors.size());
        }
        toCensor = storage.pattern.matcher(toCensor).replaceAll((String)storage.censors.get(newInt));
    }
    return toCensor;
  }
  
public String removeRepetitions(String string) {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<Character> ch = new ArrayList();
    int found = 0;
    char[] chars = string.toCharArray();
    for (int i = 0; i < string.length(); i++) {
      if ((i != 0) && (!Character.isDigit(chars[i])) && (chars[i] == chars[(i - 1)]))
        found++; else found = 0;
      if ((found < this.repeations) || (i == 0) || (chars[i] != chars[(i - 1)]))
        ch.add(Character.valueOf(chars[i]));
    }
    String s = "";
    for (Character c : ch)
      s = s + c;
    return s;
  }
  
  public String correctCaps(String stringToCorrect, boolean capsFirst) {
    char[] chars = stringToCorrect.toCharArray();
    boolean nextLetterIsCaps = false;
    if (chars.length > 0) {
      nextLetterIsCaps = Character.isLetter(chars[0]);
    }
    if (capsFirst)
      nextLetterIsCaps = false;
    int lettersToSkip = 0;
    for (int posInLine = 0; posInLine < chars.length; posInLine++) {
      boolean skipDecaps = false;
      if (lettersToSkip > 0) {
        lettersToSkip--;
        skipDecaps = true;
      }
      for (String ex : this.dontDeCaps) {
        if ((stringToCorrect.length() >= posInLine + ex.length()) && (stringToCorrect.substring(posInLine, posInLine + ex.length()).equalsIgnoreCase(ex))) {
          if (ex.length() > lettersToSkip) {
            lettersToSkip = ex.length();
          }
          skipDecaps = true;
          nextLetterIsCaps = false;
        }
      }
      if (!skipDecaps) {
        if ((nextLetterIsCaps) && (Character.isLetter(chars[posInLine]))) {
          nextLetterIsCaps = false;
          chars[posInLine] = Character.toUpperCase(chars[posInLine]);
        }
        else if (((chars[posInLine] == '.') || (chars[posInLine] == ',') || (chars[posInLine] == '?') || (chars[posInLine] == '!') || (chars[posInLine] == '"')) &&  (posInLine + 1 < chars.length) && (!Character.isLetter(chars[(posInLine + 1)])))
          nextLetterIsCaps = true;
        else if ((Character.isLetter(chars[posInLine])) && (Character.isUpperCase(chars[posInLine])))
          chars[posInLine] = Character.toLowerCase(chars[posInLine]);
      }
    }
    stringToCorrect = new String(chars);
    return stringToCorrect;
  }
  
  public int amountOfCaps(String s) {
    int amount = 0;
    for (char c : s.toCharArray()) {
      if (((!Character.isLetterOrDigit(c)) && (Character.isWhitespace(c))) || (Character.isUpperCase(c)))
        amount++;
    }
    return amount;
  }
  
  @SuppressWarnings("rawtypes")
public String getWord(String sentance, String string, String replace) {
    @SuppressWarnings("unchecked")
	ArrayList<Character> chars = new ArrayList();
    int foundMatches = 0;
    char[] cArray = sentance.toCharArray();
    sentance = "";
    char currentChar;
    for (int p = 0; p < cArray.length; p++) {
      currentChar = cArray[p];
      chars.add(Character.valueOf(currentChar));
      if (((foundMatches != 0) || (isSpecialChar(cArray, p - 1))) && 
        (Character.toLowerCase(string.toCharArray()[foundMatches]) == Character.toLowerCase(currentChar))) {
        foundMatches++;
        if (foundMatches == string.length()) {
          if (!isSpecialChar(cArray, p + 1))
           foundMatches = 0;
          else {
            while (foundMatches > 0) {
              foundMatches--;
              chars.remove(chars.size() - 1);
            }
            for (char c : replace.toCharArray())
             chars.add(Character.valueOf(c));
          }
        }
      }
      else foundMatches = 0;
    }
    for (Character c : chars)
      sentance = sentance + c;
    return sentance;
  }
  
  private boolean isSpecialChar(char[] cArray, int pos) {
    if ((pos < 0) || (pos > cArray.length - 1) || (cArray[pos] == ' ') || (cArray[pos] == '.') || (cArray[pos] == ',') || (cArray[pos] == '!') || (cArray[pos] == '?'))
      return true;
    return false;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (cmd.getName().equalsIgnoreCase("censor")) {
      if ((sender.isOp()) || (sender.hasPermission("SimpleCensor.Enable"))) {
        if (args.length > 0)  {
          if (args[0].equalsIgnoreCase("enable")) {
            this.enabled = true;
            sender.sendMessage(ChatColor.RED + "SimpleCensor is now enabled");
          }
          else if (args[0].equalsIgnoreCase("reload")) {
            loadConfig();
            sender.sendMessage(ChatColor.RED + "Config has been reloaded!");
          } else if (args[0].equalsIgnoreCase("disable")) {
            this.enabled = false;
            sender.sendMessage(ChatColor.RED + "SimpleCensor is now disabled");
          } else sender.sendMessage(ChatColor.RED + "Use " + ChatColor.GREEN + "enable" + ChatColor.RED + " or " + ChatColor.GREEN + "disable" + ChatColor.RED + " or " + ChatColor.GREEN + "reload");
        } else sender.sendMessage(ChatColor.RED + "Use " + ChatColor.GREEN + "enable" + ChatColor.RED + " or " + ChatColor.GREEN + "disable" + ChatColor.RED + " or " + ChatColor.GREEN + "reload");
      }
      else sender.sendMessage(ChatColor.RED + "You do not have permission to use this command");
      return true;
    }
    return true;
  }
}
