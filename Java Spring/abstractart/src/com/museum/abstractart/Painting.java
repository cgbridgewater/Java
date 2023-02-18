package com.museum.abstractart;

public class Painting extends Art {

	private String paintType;
	
	Painting(){};
	
	Painting(String artPiece,String artist,String description, String paintType){
		super( artPiece, artist, description);
		this.paintType = paintType;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	public void viewArt(){
		String painting = "";
		painting += "Piece of Art: " + getArtPiece() + "\n";
		painting += "Artist: " + getArtist() + "\n";
		painting += "Description: " + getDescription() + "\n";
		painting += "Painting Type: " + getPaintType() + "\n";
		System.out.println(painting);
	}
}
