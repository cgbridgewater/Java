package com.museum.abstractart;

import java.util.ArrayList;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Art> museum = new ArrayList<Art> ();
		Painting p1 = new Painting("Oil");
		Painting p2 = new Painting("Crayon");
		Painting p3 = new Painting("Color By Number");	
		Sculpture s1 = new Sculpture("Marble");
		Sculpture s2 = new Sculpture("Origami Paper");
		
		
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
		System.out.println(museum);


		p2.viewArt();
		p1.viewArt();
		s1.viewArt();
		p3.viewArt();
		s2.viewArt();
		
	}



}
