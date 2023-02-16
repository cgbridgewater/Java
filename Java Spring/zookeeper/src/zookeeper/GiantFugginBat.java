package zookeeper;

public class GiantFugginBat extends Mammal {

	public GiantFugginBat(Integer energyLevel) {
		super(energyLevel);
		System.out.println("Giant Bat Captured");
		System.out.println(this.displayEnergy());
	}
			
	public String attackTown() {
		System.out.println("Selected: Attack");
		this.setEnergy(100);
		return "*****DUCK!!!\n*****The Giant bat is attacking the town!!!\n";	
	};	

	public String fly() {
		System.out.println("Selected: Fly");
		this.setEnergy(50);
		return "*****The giant bat takes flight!\n";	
	};	
	
	public String eatHumans() {
		System.out.println("Selected: Eat");
		this.setEnergy(-25);
		return "*****OH NO, The giant bat just ate one of the Zoo goers!! \n";
	}		
}
