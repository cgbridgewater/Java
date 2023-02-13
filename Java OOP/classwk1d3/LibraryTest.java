import java.util.ArrayList;

public class LibraryTest {

    public static void main(String[] args){

        Book theHobbit = new Book ("The Hobbit", "J.R.R Tolkien", "Fantasy",  295);
        Book theLordOfTheRings = new Book ("The Lord of the Rings", "J.R.R Tolkien", "Fantasy",  1200);
        Book theSilmarillion = new Book ("The The Silmarillion", "J.R.R Tolkien", "Fantasy",  700);


    // Member jason = new Member();
    // jason.setFirstName(firstName:"Jason")

    Member chris = new Member("Chris", "Bridgewater", 1);


    chris.checkOutBook(theSilmarillion);
    chris.checkOutBook(theSilmarillion);
    System.out.println(chris.getBooksCheckedOut());
    chris.returnBook(theSilmarillion);
    System.out.println(chris.getBooksCheckedOut());



    }
}