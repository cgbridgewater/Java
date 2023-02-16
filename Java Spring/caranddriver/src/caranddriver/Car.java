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
		this.gas -= amount;
		if (this.gas <= 0) {
			System.out.println("you are out of gas. Game Over");
		}
	}
	
	
	
	
}
