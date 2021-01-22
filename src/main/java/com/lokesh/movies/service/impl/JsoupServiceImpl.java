package com.lokesh.movies.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.service.JsoupService;

@Service
public class JsoupServiceImpl implements JsoupService {

	@Override
	public List<Movie> getJsoupMoviesByIndex(String movieType, String pageIndex) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup
					.connect("https://4movierulz.sh/category/" + movieType + "/page/" + pageIndex + "/")
					.userAgent("Mozilla/5.0").timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("boxed");
			int movieindex = 1;
			for (Element element : elements) {
				if (movieindex > 2) {
					Element link = element.select("a").first();
					String linkHref = link.attr("href");
					String movieLink = linkHref.split("https://4movierulz.sh/")[1].trim();
					String finalMovieLink = movieLink.substring(0, movieLink.length() - 1);
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("src");
					String movieName = element.select("b").first().text();
					if (StringUtils.hasText(movieName)) {
						String name = movieName.split("\\(")[0].trim();
						movies.add(new Movie(image, name, 6.7, finalMovieLink));
					}
				}
				movieindex++;
			}
			return movies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Movie getMovieDetailsByMovieId(String movieId) {
		try {
			Movie movie = new Movie();
			movie.setVote_average(6.7);
			Document document = Jsoup.connect("https://4movierulz.sh/" + movieId + "/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element documentbody = document.body();
			Elements elements2 = documentbody.getElementsByClass("entry-content");
			Element movieimage = elements2.select("img").first();
			String image = movieimage.absUrl("src");
			movie.setPoster_path(image);
			Elements paragraphs = elements2.select("p");
			int i = 1;
			for (Element para : paragraphs) {
				if (i == 1) {
					String movieName = para.text().split("\\(")[0];
					String title = movieName.replace("Watch ", "").trim();
					movie.setTitle(title);
					String year = para.text().split("\\(")[1];
					String movieYear = year.split("\\)")[0];
					movie.setRelease_date(movieYear);
				} else if (i == 2) {
					String[] params = para.html().split("<br>");
					for (int j = 0; j < params.length; j++) {
						String[] spilt = params[j].split(":");
						if (spilt != null && spilt.length > 1) {
							if (spilt[0].trim().equalsIgnoreCase("Genres")) {
								String genre = spilt[1] != null ? spilt[1].trim() : null;
								movie.setGenrics(genre);
							} else if (spilt[0].trim().equalsIgnoreCase("Starring by")) {
								String staring = spilt[1] != null ? spilt[1].trim() : null;
								movie.setStaring(staring);
							} else if (spilt[0].trim().equalsIgnoreCase("Country")) {
								String country = spilt[1] != null ? spilt[1].trim() : null;
								movie.setCountry(country);
							} else if (spilt[0].trim().equalsIgnoreCase("Language")) {
								String language = spilt[1] != null ? spilt[1].trim() : null;
								movie.setLanguage(language);
							} else if (spilt[0].trim().equalsIgnoreCase("Directed by")) {
								String director = spilt[1] != null ? spilt[1].trim() : null;
								movie.setDirector(director);
							} else if (spilt[0].trim().equalsIgnoreCase("Written by")) {
								String writer = spilt[1] != null ? spilt[1].trim() : null;
								movie.setWriter(writer);
							} else if (spilt[0].trim().equalsIgnoreCase("Directed and written by")) {
								String writerdirector = spilt[1] != null ? spilt[1].trim() : null;
								movie.setDirector(writerdirector);
								movie.setWriter(writerdirector);
							} else if (spilt[0].trim().equalsIgnoreCase("Writer")) {
								String dwriter = spilt[1] != null ? spilt[1].trim() : null;
								movie.setWriter(dwriter);
							} else if (spilt[0].trim().equalsIgnoreCase("Writers")) {
								String ddwriter = spilt[1] != null ? spilt[1].trim() : null;
								movie.setWriter(ddwriter);
							}
						}
					}
				} else if (i == 3) {
					movie.setOverview(para.text());
				}

				Element p = para.select("a").first();
				if (p != null) {
					String q = p.attr("href");
					if (q != null && q.startsWith("http") && q.contains("etcscrs.to")) {
						Document doc = Jsoup.connect(q).userAgent("Mozilla/5.0")
								.timeout(10000).validateTLSCertificates(false).get();
						Element body = doc.body();
						Element elements = body.select("iframe").first();
						String movieLink = elements.absUrl("src");
						movie.setMovieLink(movieLink);
					}
				}
				i++;
			}

			return movie;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
