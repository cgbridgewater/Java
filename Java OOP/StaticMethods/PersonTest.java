public class PersonTest {
    public static void main(String[] args) {


        // set people
        Person person1 = new Person("Tom", 33);
        Person person2 = new Person("Jane", 23);
        Person person3 = new Person("Sam", 29);
        

        System.out.printf("User Name: ");
        System.out.printf(person2.getName());
        System.out.printf("\n");


        // print number of people static method
        System.out.printf("Number Of People In System: ");
        System.out.println(Person.peopleCount());
    }
}