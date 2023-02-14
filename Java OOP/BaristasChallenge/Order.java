import java.util.ArrayList;

class Order {

    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> drinks = new ArrayList<Item>();



//constructor with name & price as arguments
    public Order(String name, boolean ready, ArrayList<Item> drinks){ //, double total
        this.name = name;
        // this.total = total;
        this.ready = ready;
        this.drinks = drinks; 
    }

    public void setName(String name) {  // name SETTER //
        this.name = name;
    }

    public String getName() {  // name GETTER //
        return name;
    }

    // public void setTotal(double total) {  // total SETTER //
    //     this.total = total;
    // }

    // public double setTotal() {  // total GETTER //
    //     return total;
    // }

    public void setReady(boolean ready) {  // ready SETTER //
        this.ready = ready;
    }

    public double getPrice() {  // price GETTER //
        return price;
    }

    public void setDrinks(ArrayList<Item> drinks) {  // drinks SETTER //
        this.drinks = drinks;
    }

    public ArrayList<Item> getDrinks() {  // drinks GETTER //
        return drinks;
    }

}