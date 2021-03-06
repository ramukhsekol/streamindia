package com.lokesh.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	private Long id;
	private Double popularity;
	private String known_for_department;
	private String profile_path;
	private String name;
	private String birthday;
	private String deathday;
	private String place_of_birth;
	private String homepage;
	private String biography;
	private Integer gender;
	private String personMoviesLink;
	private String videosCount;

	public Person() {
		super();
	}

	public Person(Double popularity, String profile_path, String name, String personMoviesLink) {
		super();
		this.popularity = popularity;
		this.profile_path = profile_path;
		this.name = name;
		this.personMoviesLink = personMoviesLink;
	}

	public Person(Double popularity, String profile_path, String name, String personMoviesLink, String videosCount) {
		super();
		this.popularity = popularity;
		this.profile_path = profile_path;
		this.name = name;
		this.personMoviesLink = personMoviesLink;
		this.videosCount = videosCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public String getKnown_for_department() {
		return known_for_department;
	}

	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeathday() {
		return deathday;
	}

	public void setDeathday(String deathday) {
		this.deathday = deathday;
	}

	public String getPlace_of_birth() {
		return place_of_birth;
	}

	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPersonMoviesLink() {
		return personMoviesLink;
	}

	public void setPersonMoviesLink(String personMoviesLink) {
		this.personMoviesLink = personMoviesLink;
	}

	public String getVideosCount() {
		return videosCount;
	}

	public void setVideosCount(String videosCount) {
		this.videosCount = videosCount;
	}

}
