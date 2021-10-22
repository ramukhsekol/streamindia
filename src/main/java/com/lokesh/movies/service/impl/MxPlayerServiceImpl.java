package com.lokesh.movies.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lokesh.movies.service.MxPlayerService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class MxPlayerServiceImpl implements MxPlayerService {

	@Override
	public JSONArray getMoviesByIndexAndType(Integer pageIndex, String type) throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("https://api.mxplayer.in/v1/web/detail/browseItem?&pageSize=50&isCustomized=true&pageNum=" + (pageIndex - 1) + "&browseLangFilterIds="+type+"&type=1").asJson();
		JSONArray jsonArray = jsonResponse.getBody().getObject().getJSONArray("items");
		return jsonArray;
	}

	@Override
	public JSONObject getMoviesById(String movieId) throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("https://api.mxplayer.in/v1/web/detail/video?type=movie&id=" + movieId).asJson();
		JSONObject jsonObject = jsonResponse.getBody().getObject();
		return jsonObject;
	}

}
