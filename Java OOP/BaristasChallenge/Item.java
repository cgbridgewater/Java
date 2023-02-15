public class Item {


//Item class with name and price, private so they can be controlled by only ME!
    private String name;
    private double price;
    

//constructor with name & price as arguments
    public Item(String name, double price){
        this.name= name;
        this.price=price;
    }

    public String setName() {  // name SETTER //
        return this.name;
    }

    public String getName() {  // name GETTER //
        return name;
    }

    public double setPrice() {  // price SETTER //
        return this.price;
    }

    public double getPrice() {  // price GETTER //
        return price;
    }



} 