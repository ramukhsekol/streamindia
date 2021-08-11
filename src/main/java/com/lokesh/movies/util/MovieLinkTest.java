package com.lokesh.movies.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class MovieLinkTest {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://yespornpleasexxx.com/luna-star-and-kissa-sins-butts-in-sync/").userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			// System.out.println(body);
			
			Element iframeElement1 = body.getElementById("post").select("iframe").first();
			String moviePlayLink1 = iframeElement1.absUrl("src");
			System.out.println(moviePlayLink1);
			
			Element iframeElement = body.getElementsByClass("iframe-container").select("iframe").first();
			String moviePlayLink = iframeElement.absUrl("src");
			System.out.println(moviePlayLink);
			Integer movieLength = moviePlayLink.length();
			String spiltData = moviePlayLink.substring(34, movieLength);
			System.out.println(spiltData);
			
			
			

			Elements elements = body.getElementsByClass("iframe-container");
			for (Element element : elements) {
				System.out.println(element);
				Element elements2 = element.select("a").first();
				String aHref = elements2.attr("href");
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("data-src");
				if (!StringUtils.hasText(image)) {
					image = movieimage.absUrl("src");
				}
				String count = element.select("p").text();
				String name = element.getElementsByClass("preview-title").text();

				System.out.println(name + " " + count + " " + image + " " + aHref);

				URLConnection urlConnection = new URL(image).openConnection();
				urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
				urlConnection.setReadTimeout(50000);
				urlConnection.setConnectTimeout(50000);
				byte[] imageBytes = IOUtils.toByteArray(urlConnection);
				String encodedString = Base64.getEncoder().encodeToString(imageBytes);
				 System.out.println(encodedString);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
