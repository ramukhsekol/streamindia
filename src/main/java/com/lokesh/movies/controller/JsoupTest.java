package com.lokesh.movies.controller;

import com.lokesh.movies.domain.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupTest {
    public static void main(String[] args) {
        try {
            List<Movie> movies = new ArrayList<Movie>();
            Document doc = Jsoup.connect("http://iplt20.mylivecricket.live/search/label/Live%20Cricket%20Streaming").userAgent("Mozilla/5.0").timeout(10000)
                    .validateTLSCertificates(false).get();
            Element body = doc.body();
            Elements elements = body.getElementsByClass("event-title");
            for (Element element : elements) {
                Element elements2 = element.select("a").first();
                String finalMovieLink = elements2.attr("href").trim();
                String title = elements2.text();
                String liveMatchUrl = "http://" + (finalMovieLink.contains("football") ? "f" :
                        finalMovieLink.contains("my1.") ? "c1" :
                                finalMovieLink.contains("my2.") ? "c2" :
                                        finalMovieLink.contains("my3.") ? "c3" : "c4") + ".cricbuzz.club/";
                System.out.println(finalMovieLink + " " + title + " " + liveMatchUrl);
            }
        } catch (Exception e) {
        }
    }
}
