class Vehicle {
    private int numberOfWheels;
    private String color;



    public Vehicle(){
        this("black",4); // set a default.  THIS MUST BE FIRST!!!!
    }


    public void brew(="operator from-rainbow">="entity class from-rainbow">String beans) {
	super.brew(beans);
        System.out.println("Frothy!!!");
    }


// OVERLOAD To allow multiple ways to instantiate our objects

    public Vehicle(String color){
        this.color = color;
    }

    public Vehicle(int numberOfWheels){
        this.numberOfWheels = numberOfWheels;
    }

    public Vehicle(String color, int numberOfWheels){
        this.color= color;
        this.numberOfWheels=numberOfWheels;
    }

// end overloading

// getters and setters

    public int getNumberOfWheels() {  // GETTER //
        return numberOfWheels;
    }

    public void setNumberOfWheels(int number) {  // SETTER //
        this.numberOfWheels = number;
    }

    public String getColor() {  // GETTER //
        return color;
    }

    public void setColor(String color) {  // SETTER //
        this.color = color;        // 1
    }

}