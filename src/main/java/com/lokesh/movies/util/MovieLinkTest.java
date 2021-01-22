package com.lokesh.movies.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MovieLinkTest {

	public static void main(String[] args) {
		try {
		      Document doc = Jsoup.connect("https://etcrips.to/?p=27796")
		    		  .userAgent("Mozilla/5.0")
		    		  .timeout(10000).validateTLSCertificates(false).get();
		      Element body = doc.body();
		      Element elements = body.select("iframe").first();
		      String url = elements.absUrl("src");
		      System.out.println(url);
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }

	}

}
