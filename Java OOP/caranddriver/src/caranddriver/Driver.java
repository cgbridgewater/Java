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
		System.out.println("\nSelected: Drive!");
		
		while (!this.isGameOver()) {
			if ((this.checkGas()-1) == 0) {
				this.setGas(1);
				return "Fuel Level:" + this.checkGas() +"/10. You've run out of fuel! \n****GAME OVER!****";
			}else {
			this.setGas(1);
			return "You've completed another lap! \nGas remaining: " + this.checkGas() +"/10" ;
			}
		}
		return " The game has ended! More credits required!";
	}
//		if (this.isGameOver()) {
//			return " You are out of gas. Game Over!";
//		}		
//		this.setGas(1);
//		return "You drive the car. \nGas remaining: " + this.checkGas() +"/10" ;
//	}
	
	
	
	public String useBoosters() {
		System.out.println("\nSelected: Activate DRS to pass!");
		
		while (!this.isGameOver()) {
			if ((this.checkGas()-3) <= 0) {
				return "WARNING!! You do not have enough fuel!";
			}else {
			this.setGas(3);
			return "You used the boosters to pass another car! \nGas remaining: " + this.checkGas() +"/10" ;
			}
		}
		return " The game has ended! More credits required!";
	}		
//		if (this.isGameOver()) {
//			return " Game Over! More credits required!";
//		}	
//		
//		this.setGas(3);
//		return "You used the boosters! \nGas remaining: " + this.checkGas() +"/10" ;
	 
	
	
	public String refuel() {
		System.out.println("\nSelected: Enter Pit for fuel. Box Box Box!");
		
		while (!this.isGameOver()) {
			if ((this.checkGas()+2) > 10) {
				return "WARNING!! You do not need fuel!";
			}else {
			this.setGas(-2);
			return "You've been fueled \nGas remaining: " + this.checkGas() +"/10" ;
			}
		}
		return " The game has ended! More credits required!";
		
		
	}
		
//		if (this.isGameOver()) {
//			return " Game Over! More credits required!";
//		}		
//		this.setGas(-2);
//		return "You refueled your car! \nGas remaining: " + this.checkGas() +"/10" ;
	
	
	
	
	
}
