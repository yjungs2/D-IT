package com.media.vo;

public class Mv {
	private String mvTitle;
	private String mvSinger;
	private int mvTime;
	private int mvLike;
	
	public Mv(String mvTitle, String mvSinger, int mvTime) {
		this.mvTitle = mvTitle;
		this.mvSinger = mvSinger;
		this.mvTime = mvTime;
	}

	public void setMvLike(int mvLike) {
		this.mvLike = mvLike;
	}

	public String getMvTitle() {
		return mvTitle;
	}

	public String getMvSinger() {
		return mvSinger;
	}

	public int getMvTime() {
		return mvTime;
	}

	public int getMvLike() {
		return mvLike;
	}
}
