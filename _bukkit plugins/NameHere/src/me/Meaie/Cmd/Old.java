
//ConcurrentLinkedQueue<String> perms = new ConcurrentLinkedQueue();
  //boolean doSpecial = true;





/*
On Enable:
    this.sched = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
      @SuppressWarnings("deprecation")
	public void run() {
        SimpleCensor.this.players = Bukkit.getOnlinePlayers();
        for (Player p : SimpleCensor.this.players) {
          if (p.hasPermission("SimpleCensor.Bypass")) {
           if (!SimpleCensor.this.perms.contains(p.getName()))
             SimpleCensor.this.perms.add(p.getName());
          }
          else SimpleCensor.this.perms.remove(p.getName());
        }
      }
    }, 0L, 120L);
    */

  /*
  public void onDisable() {
    Bukkit.getScheduler().cancelTask(this.sched);
  }
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player p = event.getPlayer();
    this.exceptions.add(p.getName().toLowerCase());
    if ((p.hasPermission("SimpleCensor.Bypass")) && (!this.perms.contains(p.getName())))
      this.perms.add(p.getName());
  }
  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    Player p = event.getPlayer();
    this.exceptions.remove(p.getName().toLowerCase());
    this.perms.remove(p.getName());
  }
  */


/*
Censor()
      String naughtyWord = storage.naughtyWord;
      if (this.doSpecial) {

   
      } else {
        while (toCensor.toLowerCase().contains(naughtyWord.toLowerCase())) {
          if (storage.censors.size() > 1) {
            newInt = new Random().nextInt(storage.censors.size());
          }
          char[] replacing = ((String)storage.censors.get(newInt)).toCharArray();
          char[] chars = toCensor.substring(toCensor.toLowerCase().indexOf(naughtyWord), 
            toCensor.toLowerCase().indexOf(naughtyWord) + naughtyWord.length()).toCharArray();
          int caps = 0;
          for (int n = 0; n < replacing.length; n++) {
            if (n < chars.length) {
              if (Character.isUpperCase(chars[n])) {
                replacing[n] = Character.toUpperCase(replacing[n]);
                caps++;
              }
              else replacing[n] = Character.toLowerCase(replacing[n]);
            }
            else if (caps == chars.length)
              replacing[n] = Character.toUpperCase(replacing[n]);
          }
          toCensor = toCensor.replaceFirst("(?i)" + Pattern.quote(naughtyWord), new String(replacing));
        }
      }
    */