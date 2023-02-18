package com.museum.abstractart;

import java.util.ArrayList;

public class Sculpture extends Art {

	String material;
	
	Sculpture(String material){
		this.material = material;
	}

//	@Override
	public void viewArt() {
		System.out.println("New " + this.material + " sculpture added");
//		return museum;
	}

}
