public class Person {

    private int age;
    private String name;

    //This is private AND static~!
    private static int numberOfPeople = 0;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfPeople++;
    }


        public String getName() {  // name GETTER //  This  WORKS
            return name;
        }


        public int getAge() {  // name GETTER //  This  WORKS
            return age;
        }


        // This is static and can only be called on by the class name, ie:   Person.peopleCount();
        public static int peopleCount(){
            return numberOfPeople;
        }

}