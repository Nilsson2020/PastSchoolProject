package Store;

import Book_Member.Member;
import Db.InfDB;

import java.util.HashMap;

public class LoginClass {

    static InfDB idb;
/*
    public LoginClass() throws Exception {
        idb = new InfDB("1ik173v23-1", "3306", "la224ab", "la224ab");
    }

 */


    public Member login_query(String p_nmr) throws Exception { // DENNA SKA CALLAS I DB API
        idb = new InfDB("1ik173v23-1", "3306", "la224ab", "la224ab");
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
}
