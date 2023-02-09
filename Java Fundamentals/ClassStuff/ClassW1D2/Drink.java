public class Drink {

    private String name;
    private Double price = 2.99;
    private Integer numberOfOunces;

    
    // public void setPrice(Double price){
    //     this.price = price;

    public Drink(String name, Double price, Integer numberOfOunces){
        this.name = name;
        this.price = price;
        this.numberOfOunces = numberOfOunces;
    };

    public Double checkPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }

    public Integer getOunces(){
        return numberOfOunces;
    }
    
    
    
    
    
    }


