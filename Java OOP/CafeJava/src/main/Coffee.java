package main;

public class Coffee extends Drink implements Purcahaseable{
	private String roast;
	private Boolean hasCream;
	private Boolean hasSugar;
	
	public Coffee() {}

//	@Override
//	public void purchase() {
//		System.out.println("That will be " + this.getPrice());
//	}
	
	public String getRoast() {
		return roast;
	}

	public void setRoast(String roast) {
		this.roast = roast;
	}

	public Boolean getHasCream() {
		return hasCream;
	}

	public void setHasCream(Boolean hasCream) {
		this.hasCream = hasCream;
	}

	public Boolean getHasSugar() {
		return hasSugar;
	}

	public void setHasSugar(Boolean hasSugar) {
		this.hasSugar = hasSugar;
	};
	

}
