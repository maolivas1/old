package me.Mark.update;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
 
public class Update {
 
public static void main(String[] args) throws Exception {
 
    // Create and initialize WebClient object
        WebClient webClient = new WebClient(/*BrowserVersion.CHROME_16*/);
        webClient.setThrowExceptionOnScriptError(false);
        webClient.setJavaScriptEnabled(true);
    //  webClient.setCssEnabled(false);       
    //  webClient.getCookieManager().setCookiesEnabled(true);
    //  setCredentials(webClient);
 
     
   // webClient.Headers.Add ("User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
     
    //HtmlPage subj_page = null;
    //visit login page and get it
    String url = "https://carpinteriausd.asp.aeries.net/Student/LoginParent.aspx";
    //webClient.wait(1 * 10);
    HtmlPage page = (HtmlPage) webClient.getPage(url);
     
    String theContent1 = webClient.getPage(url).getWebResponse().getContentAsString();
    System.out.println("page string"+theContent1);
     
    HtmlAnchor anchor = null;
    page = logIn(page);
    
    String src = page.asText();
    System.out.println(src);
 
    // search for content
   // page = (HtmlPage) searchPage(page, " A Jira 5 Cheat Sheet can be");     
 
    // click on the paper link      
    //anchor = (HtmlAnchor) page.getAnchorByHref("https://dvp-connect.abc.com/cvpn/aHR0cHM6Ly9kc3VpYXBwcHJkLndzZ2MuY29tOjQ0Mw/directshipment/login");
    //page = (HtmlPage) anchor.click();
 
    // loop through found articles
    //{{{page   
 
}
 
 
public static HtmlPage logIn(HtmlPage page) {
    HtmlPage nextpage = null;
    final HtmlForm form = page.getFormByName("vpnForm");
    //final HtmlForm form = page.get;
    final HtmlTextInput username =(HtmlTextInput) form.getInputByName("portalAccountUsername");
    final HtmlPasswordInput password = (HtmlPasswordInput)form.getInputByName("portalAccountPassword");
    final HtmlSubmitInput button = (HtmlSubmitInput)form.getInputByValue("LoginButton");
    username.setValueAttribute("email@emai.com");
    password.setValueAttribute("mypassword");
 
    // hit submit button and return the requested page
    try {
        nextpage =(HtmlPage) button.click();
    } catch (IOException e) {
        e.printStackTrace();
    }
        return nextpage;
}
 
}
