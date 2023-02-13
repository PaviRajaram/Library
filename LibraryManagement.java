package study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
interface LibraryMenuList{
    void displayAccess();
}
class LibraryBook{
    private int id;
    private String name,checkIn,CheckOut;
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
    public String getCheckIn() {
        return this.checkIn;
    }
    public void setCheckIn(String checkIn) {
        if(books.contains(checkIn)) {
            books.remove(checkIn);
            this.checkIn = checkIn;
        }
        else System.out.println("Not Available");
    }
    public String getCheckOut() {
        return CheckOut;
    }
    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
        books.add(checkOut);
    }
}
class Member implements LibraryMenuList{
    public void displayAccess() {
        System.out.println("0.Exit");
        System.out.println("1.Check in");
        System.out.println("2.Check out");
        System.out.println("3.Registration");
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        List<LibraryBook> list=new ArrayList<>();
        LibraryBook regObj=new LibraryBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("---Welcome---");
        for(int i=0;i<=2;i++) {
            System.out.println("Member Registration");
            System.out.println("Enter name :");
            regObj.setName(sc.next());
            System.out.println("Enter id :");
            regObj.setId(sc.nextInt());
            System.out.print("Enter mobile number");
            regObj.setPhn(sc.nextLong());
            list.add(regObj);
            System.out.println("Your Member registration number: "+i );
        }
        int regNum,choice=1;
        do {
            try{
            System.out.println("Enter your registration number");
            regNum=sc.nextInt();
            LibraryBook bookObj=list.get(regNum);
            LibraryMenuList menuObj=new Member();
            menuObj.displayAccess();
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter book name to check in");
                    bookObj.setCheckIn(sc.next());
                    System.out.println("'"+bookObj.getCheckIn()+"'"+"is check in by member..");
                    System.out.println("Books after check in ");
                    for (String book: bookObj.books) {
                        System.out.println(book);
                    }
                }break;
                case 2:{
                    System.out.println("Enter book name to check out ");
                      bookObj.setCheckOut(sc.next());
                    System.out.println("'"+bookObj.getCheckOut()+"'"+"is check in by member..");
                    System.out.println("Books after check out ");
                    for (String book: bookObj.books) {
                        System.out.println(book);
                    }
                }break;
                case 3:
                {
                    System.out.println("Name: "+regObj.getName()+"\t\t"+"Id: "+regObj.getId()+"\t\t"+"Mobile Number: "+ regObj.getPhn());
                }break;
                default:
                    System.out.println("Press 0 to exit");
                 }
               }
                catch(Exception ex){
                    System.out.println("Number is not registered, try again..");
            }
        } while (choice != 0);
    }
}
