package GUI;

import Book_Member.Member;
import Service.Service;
import Store.Store;


import java.util.List;
import java.util.Scanner;


public class Alternativ_GUI {

    private Member member;
    static Store store;
    static Service service;

    public Alternativ_GUI(Member member) throws Exception {
        this.member = member;
        store = new Store(member);
        service = new Service(store);

    }

    public static void alternative_page() throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run) {

            System.out.println("--------Welcome to the library, chose an option to start--------");
            System.out.println("1:Loan book ");
            System.out.println("2:Return book ");
            System.out.println("3:Search for book ");
            System.out.println("4:View current loans ");
            System.out.println("5:Delete member ");
            System.out.println("6:Suspend member ");
            System.out.println("7:Member Warnings ");
            System.out.println("8:Exit ");
            String opt = scan.nextLine().trim();
            switch (opt) {
                case "1":
                    //Loan book
                    System.out.println();
                    System.out.println("Enter book name to loan: ");
                    String book = scan.nextLine();
                    service.insert_loan(book);
                    System.out.println();
                    break;
                case "2":
                    //Return book
                    System.out.println();
                    System.out.println("These are all your loans: ");
                    // Printa ut alla lån
                    int count = 0;
                    for (String s : service.get_loans()) {
                        System.out.println(++count + ":" + s);
                    }
                    System.out.println("Select what book to return (Book name): ");
                    String returnthisbook = scan.nextLine();
                    service.returnBook(returnthisbook);

                    break;
                case "3":
                    //Search for book
                    System.out.println();
                    System.out.println("Search for book: ");
                    String searchthis = scan.nextLine();
                    System.out.println("Available books: ");
                    List<String> list = service.search_book(searchthis);
                    for(String s: list){
                        System.out.println(s);
                    }
                    System.out.println();
                case "4":
                    //View current loan
                    System.out.println();
                    System.out.println("This user is currently lending following titles: ");
                    int count4 = 0;
                    for (String s : service.get_loans()) {
                        System.out.println(++count4 + ":" + s);
                    }
                    System.out.println();
                    break;
                case "5":
                    // Manage member: Delete
                    System.out.println();
                    System.out.println("Select member ID for deletion! ");
                    int deletethis =Integer.parseInt(scan.nextLine().trim());
                    service.delete_member(deletethis);
                    System.out.println();
                    break;
                case "6":
                    //Suspend active member
                    System.out.println();
                    System.out.println("Select member ID for suspension! ");
                    int memberID =Integer.parseInt(scan.nextLine().trim());
                    service.suspend(memberID);
                    System.out.println();
                    break;
                case "7":
                    //Give warning
                    System.out.println();
                    System.out.println("Select member ID to add a warning! ");
                    int memberID2 =Integer.parseInt(scan.nextLine().trim());
                    service.warning(memberID2);
                    System.out.println();
                    break;
                case "8":
                    //Exit
                    run = false;
                    System.out.println("Exiting the page! Thank you for today and enjoy your day! ");
                    break;
                default:
                    System.out.println("Invalid option selected, please try again!");

            }
        }
    }
}





