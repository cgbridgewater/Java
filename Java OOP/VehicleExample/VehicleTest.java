class VehicleTest {
    public static void main(String[] args) {

        Vehicle bike = new Vehicle();  // Declare BIKE
        Vehicle car = new Vehicle();  // Declare CAR
        
        bike.setNumberOfWheels(2);  // SET Number of Wheels
        bike.setColor("red");  // SET Color
        
        int bikeWheels = bike.getNumberOfWheels();  // GET Number of Wheels
        String bikeColor = bike.getColor();  // GET Color
        
        car.setNumberOfWheels(4);  // SET Number of Wheels
        car.setColor("green");  // SET Color
        
        int carWheels = car.getNumberOfWheels(); // GET Number of Wheels
        String carColor = car.getColor();  // GET Color

        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);


        Vehicle whiteTruck = new Vehicle("white");
        String truckColor = whiteTruck.getColor();
        System.out.printf("The truck color is %s", truckColor);

        System.out.printf("\n");

        Vehicle myTank = new Vehicle("camo", 18);
        String tankColor = myTank.getColor();
        int tankWheels = myTank.getNumberOfWheels();
        System.out.printf("The tank is %s and has %s wheels wrapped in tracks", tankColor, tankWheels);

        System.out.printf("\n");

        Vehicle defaultCar = new Vehicle();
        String defaultColor = defaultCar.getColor();
        int defaultWheels = defaultCar.getNumberOfWheels();
        System.out.printf("The default color and wheel setting is: %s and %s wheels ", defaultColor, defaultWheels);

    }
}