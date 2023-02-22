package inheritance.extending;

public class Mammal {
	public int age = 18;
	public String location = "Earth";
	
	private boolean sleeping = false;
	
	public Mammal() {
		System.out.println("*** Superclass constructor ***");
	}
	
	public Mammal(int age) {
		this.age = age;
		System.out.println("*** Superclass constructor ***");
	}
	
	public Mammal(int age, String location) {
		this.age = age;
		this.location = location;
		System.out.println("*** Superclass constructor ***");
	}
	
	
	
	
	public void regulateTemperature() {
		System.out.println("my temperature is just right now");
	}
	public void startSleeping() {
		sleeping = true;
		System.out.println("ZzZz");
	}
	public boolean isSleeping() {
	return sleeping;
	}
	
}
