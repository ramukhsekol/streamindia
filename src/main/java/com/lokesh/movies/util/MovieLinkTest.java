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
			Document doc = Jsoup.connect("https://pornone.com/indian/nuru-massage-episode/277309265/").userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			System.out.println(body);
			

			Elements elements = body.getElementsByClass("video");
			for (Element element : elements) {
				// System.out.println(element);
				Element elements2 = element.select("a").first();
				String aHref = elements2.attr("href");
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("data-src");
				if (!StringUtils.hasText(image)) {
					image = movieimage.absUrl("src");
				}
				String count = element.getElementsByClass("time").text();
				String name = element.getElementsByClass("cwrap").text();

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
