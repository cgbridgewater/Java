package lesson.oop.coffee;

public class Barista {
	
	
	private String name;
	private CoffeeMaker coffeeMaker;
	
	public Barista(String name) {
		this.name = name;
		this.coffeeMaker = new CoffeeMaker(40);
	}
	
	public void makeCoffee(String beans) {
		this.coffeeMaker.brew(beans);
		
	}
	
	

}
