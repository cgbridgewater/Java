package com.museum.abstractart;

public abstract class Art {

	private String artPiece;
	private String artist;
	private String description;
	
	public Art() {};
	
	public Art(	String artPiece,String artist,	String description) {
		this.artPiece=artPiece;
		this.artist=artist;
		this.description=description;
	}

	public void viewArt(){}

	public String getArtPiece() {
		return artPiece;
	}

	public void setArtPiece(String artPiece) {
		this.artPiece = artPiece;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};
}