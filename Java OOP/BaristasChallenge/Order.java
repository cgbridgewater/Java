import java.util.ArrayList;

public class Order {


    // private double total;
    private String name = "Guest";
    private boolean isReady = false;
    private ArrayList<Item> items = new ArrayList<Item>();


//constructor with name & price as arguments
    public Order(String name,  ArrayList<Item> items){ //, double total, boolean isReady,
        this.name = name;
        this.isReady = false;
        this.items = items;
    }


    public Order(String name){   // Overloaded constructor that takes name and creates an empty array //  This  WORKS
        this.name = name;
    }


    public Order(){}     // empty constructor default Guest name //  This  WORKS
    //     this.name = "Guest";
    //     this.isReady = false;
    // }

    public void setName(String name) {  // name SETTER //  This  WORKS
        this.name = name;
    }


    public String getName() {  // name GETTER //  This  WORKS
        return name;
    }


    public void setItems(Item item) {  // items SETTER //  This  WORKS
        items.add(item);
    }


    public ArrayList<Item> getItems() {  // items GETTER //  This  WORKS
        return items;
    }


    public void getStatusMessage(boolean isReady) {  // status message GETTER //
        String customerName = this.name;
        if (isReady == true){
            System.out.println(customerName + ", Your order is ready for pick-up");     // does this even work???
        }
        else{
            System.out.println(customerName + ", Your order is in que to be made");  // does this even work???
        }
    }


    public void showTotal(){                     // This Works!!
        String customerName = this.name;
        Double totalPrice = 0.00;
            for(Item i : this.items){
                totalPrice += i.getPrice();
            }
        System.out.printf("%s your total will be $%s", customerName, totalPrice);
        System.out.printf("\n");
        }


    public void displayOrder(){                     // This Works!!
        String customerName = this.name;
        String drinks = "";
        Double totalPrice = 0.00;
            for(Item i : this.items){
                totalPrice += i.getPrice();
                drinks += i.getName() + ", ";
            }
        System.out.printf("\n");
        System.out.println("Customer: " + customerName);
        System.out.println("Order: " + drinks);
        System.out.println("Order Total: $" + totalPrice);
        }
    }




