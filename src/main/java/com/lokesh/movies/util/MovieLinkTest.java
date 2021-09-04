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
			Document doc = Jsoup.connect("https://gettubetv.com/categories/alternative-erotic/1/").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			// System.out.println(body);
			Elements elements = body.getElementById("list_videos_common_videos_list_items").select("a");
			// System.out.println(elements);
			for (Element element : elements) {
				System.out.println(element);
				Element elements2 = element.select("a").first();
				Element movieimage = element.select("img").first();
				String image = movieimage.attr("data-original");
				String name = movieimage.attr("alt");
				String finalMovieLink = elements2.attr("href").trim();
				String[] playMovieLinkData = image.split("/");
				String playMovieLink = playMovieLinkData[playMovieLinkData.length - 3];
				System.out.println(playMovieLink);
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
