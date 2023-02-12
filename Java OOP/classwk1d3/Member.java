import java.util.ArrayList;



public class Member {

    private String firstName;
    private String lastName;
    private Integer memberNumber;
    private ArrayList<Book> booksCheckedOut;


    public Member( String firstName, String lastName, Integer memberNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberNumber = memberNumber;
        // this.booksCheckedOut = new ArrayList<Book>();
    }

    public Member(){
        this.booksCheckedOut = new ArrayList<Book>();
    }; //default constructor

    public void checkOutBook(Book book){
        booksCheckedOut.add(book);
    }

    public void returnBook(Book book){   // should be (int index)
        booksCheckedOut.remove(book);    // remove(index)
    }


    public String getFirstName() {
        return firstName;
    }
    public String setFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String setLastName() {
        return lastName;
    }
    
    public Integer getMemberNumber() {
        return memberNumber;
    }
    public Integer setMemberNumber() {
        return memberNumber;
    }

    public ArrayList<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public ArrayList<Book> setBooksCheckedOut() {
        return booksCheckedOut;
    }






}