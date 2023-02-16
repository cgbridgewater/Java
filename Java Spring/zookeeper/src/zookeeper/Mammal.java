package zookeeper;

public class Mammal {

	private Integer energyLevel = 100;
	
	public Mammal(Integer energyLevel) {
		this.energyLevel = energyLevel;
	};
	
	public String displayEnergy() {
		return "Energy Level: "+ this.energyLevel + "\n";
	}
	
	public void setEnergy(Integer amount) {
		this.energyLevel -= amount;
		System.out.println("Energy Level: " + this.energyLevel);
	}
}