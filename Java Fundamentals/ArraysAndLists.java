import java.util.ArrayList;

class ArraysAndLists {

    public static void main(String[] args) {
        
        //Fixed array
        //No push, no Pop, It is what it is!
        int[] myArray; //declare type
        myArray = new int[5]; // declare fixed size
        //assign values
        myArray[0] =4;
        myArray[1] =8;
        myArray[2] =8;
        myArray[3] =5;
        myArray[4] =9;

        //For Loop to print my fixed array
        for(int i = 0; i< myArray.length; i++) {
        System.out.println(myArray[i]);
        }


        // picking out array points to do math
        int[] numbers = {2, 4, 12, 7, 23, 44, 5, 9, 7, 11, 10, 3};

        // Use the numbers array to print the following sums: 9, 56, 24, 100
        // The first one (9) has been done for you
        //sum 9
        System.out.println("print 9");
        System.out.println(numbers[0] + numbers[3]);
        //sum 56
        System.out.println("print 56");
        System.out.println(numbers[2] + numbers[5]);
        //sum 24
        System.out.println("print 24");
        System.out.println(numbers[0] + numbers[2]+ numbers[10]);
        //sum 100
        System.out.println("print 100");
        System.out.println(numbers[3] + numbers[4]+ numbers[5]+ numbers[0]+ numbers[2]+ numbers[3]+ numbers[6]);



        //Array List
        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList);

        myList.add(10);
        myList.add(11);
        System.out.println(myList);

        //getters and setters
        // getter get(index)
        Integer num = myList.get(0);
        System.out.println(num);

        //setter -->   set(index, value)
        myList.set(0,9);
        System.out.println(myList);

        ArrayList<Object> things= new ArrayList<Object>();
        things.add(10);
        things.add("hello");
        things.add(new ArrayList<Integer>());
        things.add(12.5);
        System.out.println(things);


    }
}