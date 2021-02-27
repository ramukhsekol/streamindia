package com.lokesh.movies.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.Person;
import com.lokesh.movies.service.JsoupService;

@Service
public class JsoupServiceImpl implements JsoupService {

	@Autowired
	ServletContext context;

	@Override
	public List<Movie> getJsoupMoviesByIndex(String movieType, String pageIndex) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect("https://4movierulz.lu/category/" + movieType + "/page/" + pageIndex + "/")
					.userAgent("Mozilla/5.0").timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("boxed");
			int movieindex = 1;
			for (Element element : elements) {
				if (movieindex > 2) {
					Element link = element.select("a").first();
					String linkHref = link.attr("href");
					String movieLink = linkHref.split("https://4movierulz.lu/")[1].trim();
					String finalMovieLink = movieLink.substring(0, movieLink.length() - 1);
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("src");
					String movieName = element.select("b").first().text();
					if (StringUtils.hasText(movieName)) {
						String name = movieName.split("\\(")[0].trim();
						URLConnection urlConnection = new URL(image).openConnection();
						urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
						urlConnection.setReadTimeout(5000);
						urlConnection.setConnectTimeout(5000);

						byte[] imageBytes = IOUtils.toByteArray(urlConnection);
						String encodedString = Base64.getEncoder().encodeToString(imageBytes);
						movies.add(new Movie(encodedString, name, 6.7, finalMovieLink));
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
	public List<Movie> getAllJsoupMoviesByIndex(String movieType, String pageIndex) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			Document doc = Jsoup.connect("https://cinevez.com/" + movieType + "/page/" + pageIndex + "/")
					.userAgent("Mozilla/5.0").timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("post-item");
			for (Element element : elements) {
				Element link = element.select("a").first();
				String linkHref = link.attr("href");

				String movieLink = linkHref.split("https://cinevez.com/")[1].trim();
				String finalMovieLink = movieLink.substring(0, movieLink.length() - 1);

				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("src");
				String movieName = element.select("h2").first().text();
				if (StringUtils.hasText(movieName)) {
					String name = "";
					if (movieName.contains("(")) {
						name = movieName.split("\\(")[0].trim();
					} else if (movieName.contains("[")) {
						name = movieName.split("\\[")[0].trim();
					} else {
						name = movieName;
					}
					URLConnection urlConnection = new URL(image).openConnection();
					urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
					urlConnection.setReadTimeout(5000);
					urlConnection.setConnectTimeout(5000);

					byte[] imageBytes = IOUtils.toByteArray(urlConnection);
					String encodedString = Base64.getEncoder().encodeToString(imageBytes);
					movies.add(new Movie(encodedString, name, 6.7, finalMovieLink));
				}
			}

			return movies;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Movie getMovieDetailsByMovieId(String movieId) {
		try {
			Movie movie = new Movie();
			movie.setVote_average(6.7);
			Document document = Jsoup.connect("https://4movierulz.lu/" + movieId + "/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element documentbody = document.body();
			Elements elements2 = documentbody.getElementsByClass("entry-content");
			Element movieimage = elements2.select("img").first();
			String image = movieimage.absUrl("src");
			URLConnection urlConnection = new URL(image).openConnection();
			urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
			urlConnection.setReadTimeout(5000);
			urlConnection.setConnectTimeout(5000);

			byte[] imageBytes = IOUtils.toByteArray(urlConnection);
			String encodedString = Base64.getEncoder().encodeToString(imageBytes);
			movie.setPoster_path(encodedString);
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
						Document doc = Jsoup.connect(q).userAgent("Mozilla/5.0").timeout(10000)
								.validateTLSCertificates(false).get();
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

	@Override
	public Movie getParticularMovieDetailsByMovieId(String movieId) {
		try {
			Movie movie = new Movie();
			movie.setVote_average(6.7);
			Document document = Jsoup.connect("https://cinevez.com/" + movieId + "/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element documentbody = document.body();
			Elements elements2 = documentbody.getElementsByClass("page-content");
			Element movieimage = elements2.select("img").first();
			String image = movieimage.absUrl("src");
			URLConnection urlConnection = new URL(image).openConnection();
			urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
			urlConnection.setReadTimeout(5000);
			urlConnection.setConnectTimeout(5000);

			byte[] imageBytes = IOUtils.toByteArray(urlConnection);
			String encodedString = Base64.getEncoder().encodeToString(imageBytes);
			movie.setPoster_path(encodedString);

			Elements movieNameTag = documentbody.getElementsByClass("box-title");
			String movieName = movieNameTag.select("h1").first().text();
			if (StringUtils.hasText(movieName)) {
				String name = "";
				if (movieName.contains("(")) {
					name = movieName.split("\\(")[0].trim();
				} else if (movieName.contains("[")) {
					name = movieName.split("\\[")[0].trim();
				} else {
					name = movieName;
				}
				movie.setTitle(name);
			}

			Elements movieInfoTag = documentbody.getElementsByClass("text-dark");
			for (Element para : movieInfoTag) {
				String data = para.getElementsByClass("text-sm").text();
				if (StringUtils.hasText(data) && data.contains("IMDB Rating:")) {
					String voteAverage = data.split("IMDB Rating:")[1];
					String average = voteAverage.split("/")[0];
					if (StringUtils.hasText(average)) {
						average = average.trim();
						if (average.matches("-?\\d+(\\.\\d+)?")) {
							movie.setVote_average(Double.parseDouble(average));
						}
					}
					movie.setVoteAverage(voteAverage);
				}
				if (StringUtils.hasText(data) && data.contains("Release:")) {
					String release_date = data.split("Release:")[1];
					movie.setRelease_date(release_date);
				}
				if (StringUtils.hasText(data) && data.contains("Genres:")) {
					String genrics = data.split("Genres:")[1];
					movie.setGenrics(genrics);
				}
				if (StringUtils.hasText(data) && data.contains("Directed by:")) {
					String director = data.split("Directed by:")[1];
					movie.setDirector(director);
				}
				if (StringUtils.hasText(data) && data.contains("Starring by:")) {
					String staring = data.split("Starring by:")[1];
					movie.setStaring(staring);
				}
				if (StringUtils.hasText(data) && data.contains("Country:")) {
					String country = data.split("Country:")[1];
					movie.setCountry(country);
				}
				if (StringUtils.hasText(data) && data.contains("Language:")) {
					String language = data.split("Language:")[1];
					movie.setLanguage(language);
				}
				if (StringUtils.hasText(data) && data.contains("Story Plot:")) {
					String overview = data.split("Story Plot:")[1];
					movie.setOverview(overview);
				}

			}
			Elements movieLinkTag = documentbody.getElementsByClass("item-link");
			for (Element link : movieLinkTag) {
				String movieLinkType = link.select("span").first().text();
				if (StringUtils.hasText(movieLinkType) && movieLinkType.equalsIgnoreCase("StreamTape")) {
					Element movieStreaming = link.select("a").first();
					String linkHref = movieStreaming.attr("href");
					linkHref = linkHref.replace("/v/", "/e/");
					movie.setMovieLink(linkHref);
				}
				if (StringUtils.hasText(movieLinkType) && movieLinkType.equalsIgnoreCase("MixDrop")) {
					Element movieStreaming = link.select("a").first();
					String linkHref = movieStreaming.attr("href");
					linkHref = linkHref.replace("/f/", "/e/");
					movie.setMovieLink2(linkHref);
				}
			}
			return movie;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> getAllJsoupPornMoviesByIndex(String movieLink) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("genis");
			for (Element element : elements) {
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("data-src");
				if(!StringUtils.hasText(image)) {
					image = movieimage.absUrl("src");
				}
				URLConnection urlConnection = new URL(image).openConnection();
				urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
				urlConnection.setReadTimeout(5000);
				urlConnection.setConnectTimeout(5000);

				byte[] imageBytes = IOUtils.toByteArray(urlConnection);
				String encodedString = Base64.getEncoder().encodeToString(imageBytes);
				Element elements2 = element.getElementsByClass("title").select("a").first();
				String finalMovieLink = elements2.attr("href").trim();

				movies.add(new Movie(encodedString, "", 6.7, finalMovieLink));
			}
			return movies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Movie getParticularPornMovieDetailsByMovieLink(String movieLink) {
		try {
			Movie movie = new Movie();
			movie.setVote_average(6.7);
			Document document = Jsoup.connect(movieLink).userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element bodydoc = document.body();
			Element iframeElement = bodydoc.getElementsByClass("video-container").select("iframe").first();
			String moviePlayLink = iframeElement.absUrl("src");
			Integer movieLength = moviePlayLink.length();
			String spiltData = moviePlayLink.substring(34, movieLength);
			movie.setMovieLink(spiltData);
			return movie;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> getAllJsoupPornFullMoviesByIndex() {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			for (int i = 4; i <= 4; i++) {
				Document doc = Jsoup.connect("https://vplay.uno/category/adult/page/" + i + "/")
						.userAgent("Mozilla/5.0").timeout(10000).validateTLSCertificates(false).get();
				Element body = doc.body();
				Elements elements = body.getElementsByClass("postsh");
				for (Element element : elements) {
					Element elements2 = element.select("a").first();
					String finalMovieLink = elements2.attr("href");

					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("src");
					URLConnection urlConnection = new URL(image).openConnection();
					urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
					urlConnection.setReadTimeout(5000);
					urlConnection.setConnectTimeout(5000);
					byte[] imageBytes = IOUtils.toByteArray(urlConnection);
					String encodedString = Base64.getEncoder().encodeToString(imageBytes);
					Document document = Jsoup.connect(finalMovieLink).userAgent("Mozilla/5.0").timeout(10000)
							.validateTLSCertificates(false).get();
					Element bodydoc = document.body();
					Element iframeElement = bodydoc.select("iframe").first();
					String moviePlayLink = iframeElement.absUrl("src");
					movies.add(new Movie(encodedString, "", 6.7, moviePlayLink));
					System.out.println(encodedString);
				}
			}

			return movies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean generateJsonFile(List<Movie> movies) {
		File file = getFilePath("porn1.json", "porn");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(file, movies);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	private File getFilePath(String modifiedFileName, String path) {
		boolean exists = new File(context.getRealPath("/" + path + "/")).exists();
		if (!exists) {
			new File(context.getRealPath("/" + path + "/")).mkdir();
		}
		String modifiedFilePath = context.getRealPath("/" + path + "/" + File.separator + modifiedFileName);
		File file = new File(modifiedFilePath);
		return file;
	}

	@Override
	public List<Movie> getAllJsoupPornJsonMoviesByIndex() {
		File file = getFilePath("porn.json", "porn");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Movie> movies = Arrays.asList(objectMapper.readValue(file, Movie[].class));
			return movies;
		} catch (IOException e) {
		}
		return null;
	}

	@Override
	public List<Person> getPornStarsByIndex(String pageIndex) {
		try {
			List<Person> persons = new ArrayList<Person>();
			Document doc = Jsoup.connect("https://pornmate.com/star/page/" + pageIndex + "/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("starCatGeneral_in");
			for (Element element : elements) {
				Element elements2 = element.select("a").first();
				String finalMovieLink = elements2.attr("href");
				Element movieimage = element.select("img").first();
				String image = movieimage.absUrl("data-src");
				if (!StringUtils.hasText(image)) {
					image = movieimage.absUrl("src");
				}
				String name = element.getElementsByClass("title").text();
				URLConnection urlConnection = new URL(image).openConnection();
				urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
				urlConnection.setReadTimeout(5000);
				urlConnection.setConnectTimeout(5000);
				byte[] imageBytes = IOUtils.toByteArray(urlConnection);
				String encodedString = Base64.getEncoder().encodeToString(imageBytes);
				if(StringUtils.hasText(finalMovieLink)) {
					finalMovieLink = finalMovieLink.replace("https://pornmate.com/star/", "");
				}
				persons.add(new Person(6.7, encodedString, name, finalMovieLink));
			}
			return persons;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
