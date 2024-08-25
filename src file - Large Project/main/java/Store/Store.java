package Store;

import Book_Member.Member;
import Db.InfDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {        //pratar med databasen
    private static final Logger log = LogManager.getLogger(Store.class);      //skapar ett logobjekt som är knutet till klassen

    private InfDB idb;
    public Member member;

    public Store(Member member) throws Exception {
        this();
        this.member = member;
    }

    public Store() throws Exception {
        this.idb = new InfDB();
    }

    public Member login_query(String p_nmr) throws Exception { // DENNA SKA CALLAS I DB API
        HashMap<String, String> result;
        String query = "SELECT Name, Personal_number, Level_ID FROM Member WHERE Personal_number = '" + p_nmr + "'";
        result = idb.fetchRow(query);

        String name = result.get("Name");
        String personalnumber = result.get("Personal_number");
        String level = result.get("Level_ID");
        int lvl = Integer.parseInt(level);
        Long pnr = Long.parseLong(personalnumber); // Long för att det är för stora siffror annars
        if (!result.isEmpty()) {
            System.out.println(name);
            System.out.println(personalnumber);
            System.out.println(level);
            return new Member(name, pnr, lvl);
        }
        throw new Exception("Fel i Login: login_query()");
    }

    static boolean continue_or_not(boolean b)       // Från DB api --> user interface
    {
        if (b) {
            return true;
        }
        return false;
    }

    public int register_try(String[] user_details) throws Exception {

        int returned = 0;
        try {
            String name = user_details[0];
            String personal_number = user_details[1];
            String level = user_details[2];

            ArrayList<String> result = idb.fetchColumn("SELECT Personal_number FROM Member WHERE Personal_number = " + "\""+ personal_number +"\"");
            if (result.isEmpty()) {
                String query = "INSERT INTO Member (Name, Personal_number, Suspended, Level_ID, Warnings) VALUES (\"" + name + "\", " + personal_number + ", \"N\", " + level + " , 0)";
                System.out.println(query);
                idb.insert(query);
            } else {
                returned = 1;
                System.out.println("Member already registered in database");

            }
        } catch (RuntimeException e) {
            System.out.println("Crashing in register_try");
            throw new RuntimeException(e);
        }
        return returned;

    }


    public int delete(int choice) {
        int status = 0;
        try {
            idb.delete("DELETE FROM Member WHERE Member_ID = \"" + choice + " \";");
            System.out.println("Member successfully deleted");  //Måste ändras till så att det inte står member successfully deleted alltid!!
        } catch (Exception e) {
            status = 1;
        }
        return status;
    }

    public List<String> search(String choice) throws Exception {
        if (choice == null) throw new RuntimeException("Empty search request");
        return idb.fetchColumn("SELECT Title FROM Book where Title LIKE '%" + choice + "%' AND Available = 'Y'");

    }

    public Boolean insert_loan(String book) throws Exception {
        ArrayList<String> result;
        result = idb.fetchColumn("SELECT Book_ID FROM Book WHERE Book.Title = \"" + book + "\" AND Available = 'Y'");
        log.debug("Found books matching {}: {}", book, result);
        boolean canLoan = check_if_loan_allowed();
        if (!canLoan)
            return false;

        if (result.size() == 0)
            return false;

       String bookID = result.get(0);
        idb.insert("Insert INTO Loan (Member_ID, Book_ID) VALUES (\"" + get_memberid() + "\"," + "\"" + bookID + "\")");
        String queryupdatebook = "UPDATE Book  SET Available = 'N' WHERE Book_ID = " + bookID;
        idb.update(queryupdatebook);
        return true;

    }

    public boolean check_if_loan_allowed() throws Exception {
        String query = "SELECT Level_ID FROM Member WHERE Member.Member_ID = " + "\"" + get_memberid() + "\"";
        int levelID = Integer.parseInt(idb.fetchSingle(query));

        int max = 0;
        if (levelID == 1) {
            max = 3;
        }
        if (levelID == 2) {
            max = 5;
        }
        if (levelID == 3) {
            max = 7;
        }
        if (levelID == 4) {
            max = 10;
        }

        if (max > loan_amount()) {
            return true;
        }
        return false;

    }

    private int loan_amount() throws Exception {
        List<String> loanlist = fetch_loans();
        int loans = 0;
        for (String s : loanlist) {
            loans++;
        }

        return loans;
    }


    public List<String> fetch_loans() throws Exception {

        ArrayList<String> result;
        String query = "SELECT Title from Book Join Loan ON Book.Book_ID = Loan.Book_ID JOIN Member ON Member.Member_ID = Loan.Member_ID WHERE Member.Personal_number = \"" + member.getPersonal_number() + "\"";
        result = idb.fetchColumn(query);


        return result;
    }

    public int get_warnings(int memberID) throws Exception {
        int warnings = Integer.parseInt(idb.fetchSingle("SELECT Warnings from Member WHERE Member_ID = \"" + memberID + "\";"));
        return warnings;
    }

    public String get_memberid() throws Exception {
        String memberID = idb.fetchSingle("SELECT Member_ID FROM Member WHERE Member.Personal_number = \"" + member.getPersonal_number() + "\"");

        return memberID;
    }

    public String get_bookid(String book) throws Exception {
        String bookID = idb.fetchSingle("SELECT Book_ID FROM Book WHERE Book.Title = \"" + book + "\"");

        return bookID;
    }

    public int try_return(String bookname) throws Exception {
        try {
            String query = "DELETE Loan FROM Loan JOIN Member on Member.Member_ID = Loan.Member_ID JOIN Book on Book.Book_ID = Loan.Book_ID WHERE Book.Title = \"" + bookname + "\"";
            idb.delete(query);
            String queryreturnbook = "UPDATE Book  SET Available = 'Y' WHERE Available = 'N' AND Title = '" + bookname + "'";

        idb.update(queryreturnbook);
            System.out.println("Book successfully returned");
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }


    public ArrayList fetch_member() throws Exception {

        ArrayList<String> result;
        InfDB idb = new InfDB("1ik173v23-1", "3306", "la224ab", "la224ab");
        String query2 = "SELECT Member_ID from Member;";
        result = idb.fetchColumn(query2);
        return result;
    }

    public int suspend_member(int memberID) {
        int status = 0;
        String query = "UPDATE Member SET Suspended = 'Y' WHERE Member_ID = '" + memberID + "';";
        try {
            idb.update(query);
            System.out.println("Member successfully suspended!");  //Måste ändras till så att det inte står member successfully deleted alltid!!
        } catch (Exception e) {
            status = 1;
        }
        return status;
    }

    public int warn_member(int memberID) {
        int status = 0;
        try {
            idb.update("UPDATE Member Set Warnings = \"" + (get_warnings(memberID) + 1) + " \" WHERE Member_ID = \"" + memberID + "\";");
            System.out.println("Member successfully warned!");  //Måste ändras till så att det inte står member successfully deleted alltid!!
        } catch (Exception e) {
            status = 1;
        }
        return status;

    }
}

