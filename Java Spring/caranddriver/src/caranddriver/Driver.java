package caranddriver;

public class Driver extends Car {

	public Driver() {};

	public Boolean isGameOver() {
		if (this.checkGas() <= 0) {
			return true;
		}
		return false;
	}
	
	
	public String drive() {
		if (this.isGameOver()) {
			return " You are out of gas. Game Over!";
		}		
		this.setGas(1);
		return "You drive the car. \nGas remaining: " + this.checkGas() +"/10" ;
	}
	
	
	
	public String useBoosters() {
		if (this.isGameOver()) {
			return " You are out of gas. Game Over!";
		}		
		this.setGas(3);
		return "You used the boosters! \nGas remaining: " + this.checkGas() +"/10" ;
	}
	 
	
	
	public String refuel() {
		if (this.isGameOver()) {
			return " You are out of gas. Game Over!";
		}		
		this.setGas(-2);
		return "You refueled your car! \nGas remaining: " + this.checkGas() +"/10" ;
	}
	
	
	
	
	
}
