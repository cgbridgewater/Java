package com.museum.abstractart;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {

		ArrayList<Art> museum = new ArrayList<Art> ();
		Painting p1 = new Painting("\"Happy Mistakes\"", "Bob Ross", "Painting of the hills and trees as only Bob Ross could do", "Oil");
		Painting p2 = new Painting("\"Crayola\"", "Unknown 2nd Grader", "Art only a mom could be proud of", "Crayon");
		Painting p3 = new Painting("\"Page 3 From Disneys 'Cars'\"","Artist Unknown","Just over half finished, Does anyone ever finish these?","Color By Number");	
		museum.add(new Sculpture("\"Goonies Replica Statue Of David\"","Michelangelo (updated by Chunk)","Movie prop from the iconic movie \"Goonies\"","Marble"));
		museum.add(new Sculpture("\"Origami Bird Statue\"","Present Time","A minimal design with angular shape","Origami Paper"));

		Painting p4 = new Painting(); // test object creation
		
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
//		museum.add(s1);   //compact version above
//		museum.add(s2);   //compact version above
		museum.add(p4);
	
		//	shuffle function	
		Collections.shuffle(museum);
		
		// (array  'i' : array name)
		for(Art object : museum) {
			object.viewArt();
		}
	}
}
