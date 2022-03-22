package kr.mjc.jacob.basics.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class URLDownloader {
  private final Site[] SITES = {new Site("Google", "https://www.google.com/"),
      new Site("Youtube", "https://www.youtube.com/"),
      new Site("Facebook", "https://www.facebook.com/"),
      new Site("Twitter", "https://twitter.com/"),
      new Site("Wikipedia", "https://www.wikipedia.org/"),
      new Site("Instagram", "https://www.instagram.com/"),
      new Site("Netflix", "https://www.netflix.com/"),
      new Site("Yahoo", "https://www.yahoo.com/"),
      new Site("Naver", "https://www.naver.com/"),
      new Site("Daum", "https://www.daum.net/"),
      new Site("Baidu", "https://www.baidu.com/"),
      new Site("Whatsapp", "https://www.whatsapp.com/"),
      new Site("Zoom", "https://zoom.us/"),
      new Site("Live", "https://outlook.live.com/"),
      new Site("Reddit", "https://www.reddit.com/"),
      new Site("Office", "https://www.office.com/"),
      new Site("Pinterest", "https://www.pinterest.com/"),
      new Site("Discord", "https://discord.com/"),
      new Site("Linkedin", "https://www.linkedin.com/")};

  public void go() {
    for (Site site : SITES) {
      downloadSite(site);
    }
  }

  public void downloadSite(Site site) {
    final long start = System.currentTimeMillis();
    try {
      FileUtils.copyURLToFile(new URL(site.getUrl()),
          new File("htmls/" + site.getName() + ".html"));
      System.out.format("[%s] %s : %d ms\n", Thread.currentThread().getName(),
          site.getName(), System.currentTimeMillis() - start);
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  public static void main(String[] args) {
    new URLDownloader().go();
  }
}

class Site {
  private final String name;
  private final String url;

  public Site(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }
}
