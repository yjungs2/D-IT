package com.media.vo;

public class Music {
	private String musicTitle;
	private String musicSinger;
	private String musicGenre;
	private int musicTime;
	
	private int musicLike;
	
	public Music(String musicTitle, String musicSinger, String musicGenre, int musicTime) {
		this.musicTitle = musicTitle;
		this.musicSinger = musicSinger;
		this.musicGenre = musicGenre;
		this.musicTime = musicTime;
	}
	
	public void setMusicLike(int musicLike) {
		this.musicLike = musicLike;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public String getMusicSinger() {
		return musicSinger;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public int getMusicTime() {
		return musicTime;
	}

	public int getMusicLike() {
		return musicLike;
	}
}
