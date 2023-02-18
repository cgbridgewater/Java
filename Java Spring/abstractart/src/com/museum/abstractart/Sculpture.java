package com.museum.abstractart;

public class Sculpture extends Art {

	String material;
	
	Sculpture(String artPiece,String artist,String description, String material){
		super( artPiece, artist, description);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void viewArt(){
		String sculpture = "";
		sculpture += "Piece of Art: " + getArtPiece() + "\n";
		sculpture += "Artist: " + getArtist() + "\n";
		sculpture += "Description: " + getDescription() + "\n";
		sculpture += "Sculpture Material: " + getMaterial() + "\n";
		System.out.println(sculpture);
	}
}
