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
			Document doc = Jsoup.connect("https://vplay.uno/busty-milfs-get-shared-2020-watch-online-free/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Element elementss = body.select("iframe").first();
			String movieLink = elementss.absUrl("src");
			System.out.println(movieLink);
			
			
			
			Elements elements = body.getElementsByClass("item");
			for (Element element : elements) {
				Element elements2 = element.select("a").first();
				String aHref = elements2.attr("href");
				System.out.println(aHref);
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("src");
				URLConnection urlConnection = new URL(image).openConnection();
				urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
				urlConnection.setReadTimeout(5000);
				urlConnection.setConnectTimeout(5000);
				byte[] imageBytes = IOUtils.toByteArray(urlConnection);
				String encodedString = Base64.getEncoder().encodeToString(imageBytes);
				System.out.println(encodedString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
