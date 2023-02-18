package com.museum.abstractart;

import java.util.ArrayList;

public class Painting extends Art {

	String paintType;
	
	Painting(String paintType){
		this.paintType = paintType;
	}
	
//	@Override
	public void viewArt() {
		System.out.println("New " + this.paintType + " painting added");
//		return museum;
	}

}
