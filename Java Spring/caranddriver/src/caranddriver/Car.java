package caranddriver;

public class Car {

	private Integer gas;
	
	public Car() {
		this.gas = 10;
	};
	
	
	public Integer checkGas() {
		return gas;
	}
	
	
	public void setGas(Integer amount) {
		
		if ((this.gas -= amount) < 0) {
			System.out.println("you are out of gas. GAME OVER");
		}
	}	
}
