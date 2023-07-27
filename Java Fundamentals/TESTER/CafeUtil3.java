

public class CafeUtil3 {

    public int getStreakGoal(int numWeeks){    
        int sum = 0;

        for(int i = 0; i<= numWeeks; i++){
            sum += i;
        }
        return sum;
    }
}