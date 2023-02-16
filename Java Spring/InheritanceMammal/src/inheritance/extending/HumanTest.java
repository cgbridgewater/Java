package inheritance.extending;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h = new Human("Steve");
		System.out.println("Hi, my name is " + h.name);
		System.out.println("I am " + h.age +" years old, and I am from " + h.location);
		h.regulateTemperature();
		h.startSleeping();
		h.goToWork();
		boolean sleeping = h.isSleeping();
		
		if(sleeping) {
			System.out.println("The human is sleeping!");
		}		
		
		
		Human h2 = new Human("Jeff");
		System.out.println("Hi, my name is " + h2.name);
		System.out.println("I am " + h2.age +" years old, and I am from " + h2.location);
		h2.regulateTemperature();
		
	
	}
}
