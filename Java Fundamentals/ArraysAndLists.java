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




    }
}