class CarTest{
    public static void main (String[] args) {

        //Create a Car Class
        Car client1Car = new Car();
        //Add member values
        client1Car.year = 2001;
        client1Car.make = "Honda";
        client1Car.model = "Civic";
        client1Car.color = "white";


        //Create a Car class
        Car client2Car = new Car();
        //Add member values
        client2Car.year = 2018;
        client2Car.make = "Mazda";
        client2Car.model = "CX-3";
        client2Car.color = "blue";


        System.out.printf("\n");
        System.out.printf("Car 1 - Make: %s \nModel: %s", client1Car.make,client1Car.model);
        System.out.printf("\n");
        System.out.printf("\n");
        System.out.printf("Car 2 - Make: %s \nModel: %s", client2Car.make,client2Car.model);

    }
}