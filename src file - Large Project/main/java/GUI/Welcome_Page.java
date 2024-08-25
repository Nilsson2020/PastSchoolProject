package GUI;

import Book_Member.Member;
import Store.Store;
import Store.LoginClass;

import java.util.Scanner;

public class Welcome_Page {

    Store store = new Store();

    public Welcome_Page() throws Exception {

    }

    public static void welcome_page() throws Exception {
        Welcome_Page welcome = new Welcome_Page();
        System.out.println("-------Welcome to the library------");
        System.out.println("Please log in or register to continue borrowing books! ");
        System.out.println("Already a member? Y/N");

        Scanner scan = new Scanner(System.in);
        String member = scan.nextLine().toLowerCase();
        switch (member) {
            case "y":
                welcome.login_menu();
                break;
            case "n":
                welcome.create_member_menu();
                break;

            default:
                throw new RuntimeException("Error in first_page()");

        }
    }

     void login_menu() throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("-------Log in to continue-------");
        System.out.print("Enter personal number (YYYYMMDDXXXX): ");
        String personal_number = scan.nextLine();

        LoginClass loginClass = new LoginClass();
        Member member;
        try {
            member = loginClass.login_query(personal_number);
            // Alternativ (member)
            Alternativ_GUI alt = new Alternativ_GUI(member); // Skicka vidare membern
            alt.alternative_page();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();            //VIKTIGAST
            throw new Exception("Fail to login in login_menu()", e);     //lägger till cause kedjr ihop nya exeption med gamla
        }
    }

    void create_member_menu() throws Exception {
        // fr at accessa metoderna i valideringsklassen behöver vi göra ett objekt av den
        Valideringsmetoder val = new Valideringsmetoder();

        Scanner sc = new Scanner(System.in);
        String name, personal_number;
        int level;

        System.out.println("-------Create new user-------");
        //personalnumber, password, name, level
        System.out.println("Please enter your data to create a new user! ");
        System.out.print("Name: ");
        name = sc.nextLine();


        if (!val.check_letters(name)) {
            throw new RuntimeException("Invalid name name");
        }


        System.out.print("Personalnumber (YYYYMMDDXXXX): ");
        personal_number = sc.nextLine();
        if (!val.check_personal_number(personal_number)) {
            throw new RuntimeException("Invalid personal number");
        }

        System.out.println("What type? 1.Undergrad, 2.Master, 3.PhD, 4.Staff");
        level = sc.nextInt();

        if (level < 1 || level > 4) {
            throw new RuntimeException("Wrong input in level");
        }

        String[] details = {name, personal_number, String.valueOf(level)};
        store.register_try(details);

        System.out.println("User registered, login to continue");
        login_menu();
    }
}
