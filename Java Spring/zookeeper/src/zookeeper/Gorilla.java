package zookeeper;

public class Gorilla extends Mammal {

	public Gorilla() {
		System.out.println("Gorilla Added");
		System.out.println(this.displayEnergy());
	};
	
	
	public String throwSomething() {
		System.out.println("Selected: Throw");
		this.setEnergy(5);
		return "*****The Gorilla Flings Poo!\n";	
	};	

	public String climb() {
		System.out.println("Selected: Climb");
		this.setEnergy(10);
		return "****The Gorilla climbs a rock!\n";	
	};	
	
	
	public String eatBananas() {
		System.out.println("Selected: Eat");
		this.setEnergy(-10);
		return "****The Gorilla enjoys a banana\n";
	}
	
	
}
