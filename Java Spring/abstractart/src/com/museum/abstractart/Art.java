package com.museum.abstractart;

import java.util.ArrayList;

public abstract class Art {

	String title;
	String author;
	String description;
	static ArrayList<Art> museum = new ArrayList<Art> ();
	
	public Art() {
		// TODO Auto-generated constructor stub
	}

	public void viewArt(){
		System.out.println(museum);
	}
//
//	public ArrayList<Art> getMuseum() {
//		System.out.println(museum);
//
//	}
//
//	public void setMuseum(Art museum) {
////		this.museum = museum;
//		this.museum.add(museum);
//	}
	

	

}
