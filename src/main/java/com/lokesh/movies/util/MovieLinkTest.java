package com.lokesh.movies.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import com.lokesh.movies.domain.Movie;

public class MovieLinkTest {

	public static void main(String[] args) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect("https://yespornpleasexxx.com/pornstars/").userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("gallery-item");
			for (Element element : elements) {
				Element elements2 = element.select("a").first();
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("data-src");
				if (!StringUtils.hasText(image)) {
					image = movieimage.absUrl("src");
				}
				String name = element.select("a").first().text();
				String finalMovieLink = elements2.attr("href").trim();
				System.out.println(name);
				System.out.println(image);
				System.out.println(finalMovieLink);
				System.out.println("--------------------------");
				movies.add(new Movie(image, name, 5.7, finalMovieLink, null));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
