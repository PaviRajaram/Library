package study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
interface LibraryMenuList{
    void displayAccess();
}
class LibraryBook{
    private int id;
    private String name,bookName;
    Long phn;
    ArrayList<String> books = new ArrayList<>(Arrays.asList("Book1","Book2","Book3"));
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPhn() {
        return phn;
    }
    public void setPhn(Long phn) {
        this.phn = phn;
    }
    Scanner sc=new Scanner(System.in);
    void checkIn(){
        System.out.println("Book name");
        bookName=sc.next();
        if (books.contains(bookName)){
            System.out.println("Available");
            books.remove(bookName);
            for (String book:books) {
                System.out.println("Books after check in "+book);
            }
        }else System.out.println("Not Available");
    }
   void checkOut(){
       System.out.println("Book name");
       bookName=sc.next();
       System.out.println("Thank you");
       books.add(bookName);
       for (String book:books) {
           System.out.println("Books after check out"+book);
       }
   }
}
class Member implements LibraryMenuList{
    LibraryBook regObj=new LibraryBook();
    Scanner sc=new Scanner(System.in);
     void registration(){
         System.out.println("Enter name :");
         regObj.setName(sc.next());
         System.out.println("Enter id :");
         regObj.setId(sc.nextInt());
         System.out.print("Enter mobile number");
         regObj.setPhn(sc.nextLong());
     }
     void displayMemberAc(){
        System.out.println("Name: "+regObj.getName()+"\t\t"+"Id: "+regObj.getId()+"\t\t"+"Mobile Number: "+ regObj.getPhn());
    }
    public void displayAccess() {
        System.out.println("0.Exit");
        System.out.println("1.Check in");
        System.out.println("2.Check out");
        System.out.println("3.Registration");
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Member memberObj = new Member();
        LibraryBook bookObj=new LibraryBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Member Registration");
        int choice;
        do {
            System.out.println("---Welcome---");
            LibraryMenuList menuObj=new Member();
            menuObj.displayAccess();
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter your id ");
                    bookObj.setId(sc.nextInt());
                   bookObj.checkIn();
                }break;
                case 2:{
                    System.out.println("Enter your id ");
                    bookObj.setId(sc.nextInt());
                    bookObj.checkOut();
                }break;
                case 3:
                {
                    memberObj.registration();
                    memberObj.displayMemberAc();
                }break;
                default:
                    System.out.println("Press 0 to exit");
            }
        } while (choice != 0);
    }
}