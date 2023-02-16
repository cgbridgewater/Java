package lesson.oop.coffee;

	class CappuccinoMaker extends CoffeeMaker {
		
		public CappuccinoMaker(int maxVolumeOz) {
			super(maxVolumeOz);
			this.milk = "whole";
		}
		
		public void makeCappuccino(String beans) {
			super.brew(beans);
			System.out.println("Smooth.");
		}
		
//		public void brew(=<"operator from-rainbow">="entity class from-rainbow">String beans) {
//			super.brew(beans);
//			System.out.println("Frothy!!!");
//		}
//		
		public void clean() {
			System.out.println("Cleaning the froth!");
		}
		
}
