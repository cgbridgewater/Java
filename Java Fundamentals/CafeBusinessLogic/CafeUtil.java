public class CafeUtil {

    public int getStreakGoal(int numWeeks){
        // int numWeeks = 10;
        int count = 0;
        int sum = 0;
        while(count<=numWeeks) {
            sum += count;
            count++;
            // System.out.println(count);
        }
        return sum;
        // return"spaceholder"
    }


    // public double getOrderTotal(double[]prices)(){
    //     return"spaceholder"
    // }


    // public void displayMenu(ArrayList<String> menuItems){
    //     return"spaceholder"
    // }


    // public void AddCustomer(ArrayList<String>customers)(){
    //     return"spaceholder"
    // }

}

