package com.lokesh.movies.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieLinkTest {

	public static void main(String[] args) {
		try {
		      Document doc = Jsoup.connect("https://pornmate.com/video/page/1")
		    		  .userAgent("Mozilla/5.0")
		    		  .timeout(10000).validateTLSCertificates(false).get();
		      Element body = doc.body();
		      Elements elements = body.getElementsByClass("genis");
				for (Element element : elements) {
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					URLConnection urlConnection = new URL(image).openConnection();
			        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
			        urlConnection.setReadTimeout(5000);
			        urlConnection.setConnectTimeout(5000);
			        
			        byte[] imageBytes = IOUtils.toByteArray(urlConnection);
					String encodedString = Base64.getEncoder().encodeToString(imageBytes);
					
					 Element elements2 = element.getElementsByClass("title").select("a").first();
					 String aHref = elements2.attr("href");
					 
					 Document docs = Jsoup.connect(aHref)
				    		  .userAgent("Mozilla/5.0")
				    		  .timeout(10000).validateTLSCertificates(false).get();
					 
					 Element bodydoc = docs.body();
					 Element iframeElement = bodydoc.getElementsByClass("video-container").select("iframe").first();
					 String movieLink = iframeElement.absUrl("src");
					 Integer movieLength = movieLink.length();
					 String spiltData = movieLink.substring(34, movieLength);
					 System.out.println(aHref);
					
					URLConnection videoUrlConnection = new URL(spiltData).openConnection();
					videoUrlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
					videoUrlConnection.setReadTimeout(5000);
					videoUrlConnection.setConnectTimeout(5000);
			        
			        byte[] videoBytes = IOUtils.toByteArray(videoUrlConnection);
					String videoEncodedString = Base64.getEncoder().encodeToString(videoBytes);
					System.out.println(videoEncodedString);
					
					
					
					// System.out.println(encodedString);	
				}
		    } catch (Exception e) {
		      e.printStackTrace();
		    }

	}

}
