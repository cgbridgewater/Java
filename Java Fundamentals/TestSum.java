class TestSum {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");


        long start2 = System.currentTimeMillis();
        int sum2 = 0;
        for (int ii = 0; ii < Integer.MAX_VALUE; ii++) {
            sum2 += ii;
        }
        System.out.println("Sum2: " + sum2);
        long end2 = System.currentTimeMillis();
        double total2 = (double) (end2 - start2) / 1000;
        System.out.println("Time of execution2: " + total2 + " seconds");


        Integer a = 10;
        int b = 10;
        a = null;
        // b = null; This one wont allow a the code to compile
    }
}