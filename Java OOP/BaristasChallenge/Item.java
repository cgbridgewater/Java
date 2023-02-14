class Item {


//Item class with name and price, private so they can be controlled by only ME!
    private String name;
    private double price;
    

//constructor with name & price as arguments
    public Item(String name, double price){
        this.name= name;
        this.price=price;
    }

    public void setName(String name) {  // name SETTER //
        this.name = name;
    }

    public String getName() {  // name GETTER //
        return name;
    }

    public void setPrice(double number) {  // price SETTER //
        this.price = price;
    }

    public double getPrice() {  // price GETTER //
        return price;
    }



} 