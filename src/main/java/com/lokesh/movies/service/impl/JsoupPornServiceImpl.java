package com.lokesh.movies.service.impl;

import java.io.IOException;
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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.service.JsoupPornService;

@Service
public class JsoupPornServiceImpl implements JsoupPornService {

	@Override
	public List<Movie> getAllTypeJsoupPornMoviesByIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("post-preview");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					if (!StringUtils.hasText(image)) {
						image = movieimage.absUrl("src");
					}
					String timming = element.select("p").text();
					String name = element.getElementsByClass("preview-title").text();
					String[] spiltName = name.split("-");
					if (spiltName.length > 1) {
						name = spiltName[1];
					}
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), finalMovieLink, timming);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Movie getParticularPornMovieDetailsByMovieLink(String movieLink, String type) {
		try {
			Movie movie = new Movie();
			movie.setVote_average(6.7);
			Document document = Jsoup.connect(movieLink).userAgent("Mozilla/5.0").timeout(10000)
					.validateTLSCertificates(false).get();
			Element bodydoc = document.body();
			Element iframeElement = null;
			if (type.equalsIgnoreCase("romance")) {
				iframeElement = bodydoc.getElementById("post").select("iframe").first();
			} else {
				iframeElement = bodydoc.getElementsByClass("video-container").select("iframe").first();
			}

			String moviePlayLink = iframeElement.absUrl("src");
			if (type.equalsIgnoreCase("romance")) {
				movie.setMovieLink(moviePlayLink);
			} else {
				Integer movieLength = moviePlayLink.length();
				String spiltData = moviePlayLink.substring(34, movieLength);
				movie.setMovieLink(spiltData);
			}
			return movie;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public List<Movie> getFamousStars(Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect("https://yespornpleasexxx.com/pornstars/").userAgent("Mozilla/5.0")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("gallery-item");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					if (!StringUtils.hasText(image)) {
						image = movieimage.absUrl("src");
					}
					String name = element.select("a").first().text();
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), finalMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> pornModelsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent(
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementById("list_models_models_list_items").select("a");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					if (!StringUtils.hasText(image)) {
						image = movieimage.absUrl("src");
					}
					String name = elements2.attr("title");
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), finalMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> pornModelMoviesByMovieLink(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent(
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementById("list_videos_common_videos_list_items").select("a");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					if (!StringUtils.hasText(image)) {
						image = movieimage.attr("thumb");
					}
					String name = elements2.getElementsByClass("title").text();
					String finalMovieLink = elements2.attr("href").trim();
					String playMovieLink = "https://www.xozilla.com/embed/" + finalMovieLink.split("/")[4];
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), playMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;

			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> pornStarsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent(
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("pornstars-grid").get(1).getElementsByClass("grid-item");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.absUrl("data-src");
					if (!StringUtils.hasText(image)) {
						image = movieimage.attr("src");
					}
					String name = elements2.attr("title");
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), finalMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> pornStarMoviesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent(
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
					.timeout(10000).validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("grid-item");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.attr("data-original");
					String name = elements2.attr("title");
					String finalMovieLink = elements2.attr("href").trim();
					String[] movieLinkData = finalMovieLink.split("-");
					String playMovieLink = "https://www.uiporn.com/embed/"
							+ movieLinkData[movieLinkData.length - 1].replace("/", "");
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), playMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> trendingStarsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag, String className) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass(className);
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.attr("src");
					String name = movieimage.attr("alt");
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), finalMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Movie> trendingStarMoviesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag) {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			Document doc = Jsoup.connect(movieLink).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36").timeout(10000)
					.validateTLSCertificates(false).get();
			Element body = doc.body();
			Elements elements = body.getElementsByClass("thumb-list__item");
			int i = 1;
			for (Element element : elements) {
				if (i >= startIndex && i <= endIndex) {
					Element elements2 = element.select("a").first();
					Element movieimage = element.select("img").first();
					String image = movieimage.attr("src");
					String name = movieimage.attr("alt");
					String finalMovieLink = elements2.attr("href").trim();
					String encodedString = null;
					if(isFlag) {
						try {
							URLConnection urlConnection = new URL(image).openConnection();
							urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
							urlConnection.setReadTimeout(5000);
							urlConnection.setConnectTimeout(5000);

							byte[] imageBytes = IOUtils.toByteArray(urlConnection);
							encodedString = Base64.getEncoder().encodeToString(imageBytes);
						} catch (Exception e) {
						}
					} else {
						encodedString = image;
					}
					String[] playMovieLinkData = finalMovieLink.split("-");
					String playMovieLink = "https://xhamster15.desi/embed/" + playMovieLinkData[playMovieLinkData.length -1];
					Movie movie = new Movie(encodedString, name, (double) getRandomNumber(6, 9), playMovieLink, null);
					movie.setTotalMoviesPerPageIndex(elements.size());
					movies.add(movie);
				}
				i++;
			}
			return movies;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	

	private int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
