class Casting {
    public static void main(String[] args) {
        double d = 35.25;
        double dd = 35.99;
        
        // casting the double d into a int
        int i = (int) d;
        
        // casting the double dd into a int
        int ii = (int) dd;
        System.out.println(i); // prints 35 (int removed the decimal)
        System.out.println(ii); // prints 35 (int removed the decimal)


        int iii = 35;
        float f = iii;
        System.out.println("The number is: " + f); // prints 35.0 (float adds decimal)

        int iiii = 35;
        double ff = iiii;
        System.out.println("The number is: " + f); // prints 35.0 (double adds decimal)
    }
}

