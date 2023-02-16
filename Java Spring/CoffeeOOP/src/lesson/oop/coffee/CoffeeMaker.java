package lesson.oop.coffee;

public class CoffeeMaker {
	
	 protected int maxVolumeOz;
	    protected String milk;
	    
	    public CoffeeMaker(int maxVolumeOz) {
	        this.maxVolumeOz = maxVolumeOz;
	    }
	                
	    public int getMaxVolumeOz() {
	        return this.maxVolumeOz;
        }
	    
	    public int getMaxServings() {
	        return this.maxVolumeOz / 8;
	    }
	    
	    public void brew(String beans) {
	    	System.out.println("Brewing coffee");
	    }

}
