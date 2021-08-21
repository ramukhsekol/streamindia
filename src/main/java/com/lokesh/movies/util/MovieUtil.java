package com.lokesh.movies.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.MovieImages;
import com.lokesh.movies.domain.Trailer;
import com.lokesh.movies.domain.TvShows;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieUtil {
	public static Map<Long, String> movieGenrics = new LinkedHashMap<>();
	public static Map<Integer, String> movieLanguages = new LinkedHashMap<>();
	public static final String userKey = "5HbImlTRhrrI7aEO";
	public static final String secretKey = "s51qflw236t2ddlcbom9d0hfe800tp";
	public static final String apiKey = "663337055530cc77a3aa1d26fec365d5";

	static {
		movieGenrics.put(28L, "Action");
		movieGenrics.put(12L, "Adventure");
		movieGenrics.put(16L, "Animation");
		movieGenrics.put(35L, "Comedy");
		movieGenrics.put(80L, "Crime");
		movieGenrics.put(99L, "Documentary");
		movieGenrics.put(18L, "Drama");
		movieGenrics.put(10751L, "Family");
		movieGenrics.put(14L, "Fantasy");
		movieGenrics.put(36L, "History");
		movieGenrics.put(27L, "Horror");
		movieGenrics.put(10402L, "Music");
		movieGenrics.put(9648L, "Mystery");
		movieGenrics.put(10749L, "Romance");
		movieGenrics.put(878L, "Science Fiction");
		movieGenrics.put(10770L, "TV Movie");
		movieGenrics.put(53L, "Thriller");
		movieGenrics.put(10752L, "War");
		movieGenrics.put(37L, "Western");
		movieGenrics.put(10759L, "Action & Adventure");
		movieGenrics.put(10762L, "Kids");
		movieGenrics.put(10763L, "News");
		movieGenrics.put(10764L, "Reality");
		movieGenrics.put(10765L, "Sci-Fi & Fantasy");
		movieGenrics.put(10766L, "Soap");
		movieGenrics.put(10767L, "Talk");
		movieGenrics.put(10768L, "War & Politics");
		
		movieLanguages.put(1, "TELUGU");
		movieLanguages.put(2, "HINDI");
		movieLanguages.put(3, "TAMIL");
		movieLanguages.put(4, "KANNADA");
		movieLanguages.put(5, "MALAYALAM");
		/*
		 * movieLanguages.put(6, "BENGALI"); movieLanguages.put(7, "PUNJABI");
		 */
		movieLanguages.put(8, "ADULT");	
		movieLanguages.put(9, "TELUGU");
		movieLanguages.put(10, "TAMIL");
		movieLanguages.put(11, "HINDI");
		movieLanguages.put(12, "ALL");
		
	}

	public static String getMovieGenries(List<Long> genericIds) {
		List<String> genrics = new ArrayList<>();
		for(Long genericId : genericIds) {
			genrics.add(movieGenrics.get(genericId));
		}
		return genrics.stream().map(Object::toString).collect(Collectors.joining(", "));
	}
	
	public static String getMovieLanguage(Integer languageId) {
		return movieLanguages.get(languageId);
	}
	
	public static Map<Integer, String> getmovieLanguages() {
		return movieLanguages;
	}

	public static List<Trailer> getMovieTrailers(List<Trailer> movieTrailers, List<MovieImages> movieImages, Movie movie) {
		if(movieTrailers != null && movieTrailers.size() > 0) {
			for(int i = 0; i<movieTrailers.size() ; i++) {
				if(movieImages.size() >= movieTrailers.size()) {
					movieTrailers.get(i).setImage_path(movieImages.get(i).getFile_path());
				} else {
						if(movieImages.size() >=2) {
							String imagePath = i % 2 == 0 ? movieImages.get(0).getFile_path() : movieImages.get(1).getFile_path();
							movieTrailers.get(i).setImage_path(imagePath);
						} else {
							String imagePath = i % 2 == 0 ? movie.getBackdrop_path() : movie.getPoster_path();
							movieTrailers.get(i).setImage_path(imagePath);
						}
				}
			}
		}
		return movieTrailers;
	}
	
	public static List<Trailer> getTvTrailers(List<Trailer> movieTrailers, TvShows movie) {
		if(movieTrailers != null && movieTrailers.size() > 0) {
			for(int i = 0; i<movieTrailers.size() ; i++) {
				String imagePath = i % 2 == 0 ? movie.getBackdrop_path() : movie.getPoster_path();
				movieTrailers.get(i).setImage_path(imagePath);
			}
		}
		return movieTrailers;
	}
	
	public static String convertMovieTiming(Integer runTime) {
		int hours = runTime / 60; 
		int minutes = runTime % 60;
		return hours+"h : "+minutes+"m";
	}
	
	
	

}
