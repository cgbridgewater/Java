import java.util.ArrayList;

class Order {

    // private double total;
    private String name;
    private boolean isReady;
    private ArrayList<Item> items;




//constructor with name & price as arguments
    public Order(String name, ArrayList<Item> items){ //, double total, boolean isReady,
        this.name = name;
        this.items = items; 
        this.items = new ArrayList<Item>();
        // Order.getTotal();
        // this.isReady = isReady;
        // this.total = total;
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }



    public String setName() {  // name SETTER //
        return this.name;
    }

    public String getName() {  // name GETTER //
        return name;
    }

    public boolean setIsReady() {  // isReady SETTER //
        return this.isReady;
    }
    public boolean getIsReady() {  // isReady SETTER //
        return isReady;
    }

    public String getStatusMessage() {  // status message GETTER //
        getIsReady();
        if (isReady == true){
            return "Your order is ready for pick-up";     // does this even work???
        }
        else{
            return "Your order is in que to be made";  // does this even work???
        }
    }

    public ArrayList<Item> setItems() {  // items SETTER //
        return this.items;
    }

    public ArrayList<Item> getItems() {  // items GETTER //
        return items;
    }

    // public void addItem(string name, double price); // does this even work?????
    //     items.add(Item.setName(name), Item.setPrice(price));




    // public double getTotal() {  // GetTotal GETTER //               FIX THIS!!!!
    // getItems();
    // double totalPrice = 0;
    //     for (int i = 0;  i < items.size(); i++) {
    //         totalPrice += items;              //Does this even work???
    //         System.out.println(totalPrice);
    //     }
    //     return totalPrice;
    // }



    public String displayOrder(){                     //Fix this!!!!
        getName();
        getItems();
        return System.out.printf(name + " " + items);
    }


}