package Service;

import Store.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
//SERVCE TALAR MED UI OCH STORE; DENNA MOCKAS

public class Service {
    private static final Logger log = LogManager.getLogger(Service.class);      //skapar ett logobjekt som är knutet till klassen
     Store store;
    public Service(Store store) {
        this.store = store;
    }

    public int returnBook(String bookname) throws Exception {        //MOCKAD
        log.debug("Returning book {}",bookname);      //{} är en placeholder, byter måsvingarna mot bookname
        return store.try_return(bookname);

    }

    public int delete_member(int memberID){             //MOCKAD
        log.debug("Deleting member {}", memberID);
        return store.delete(memberID);
    }

    public List<String> search_book(String bookName) throws Exception {      //MOCKAD
        log.debug("Searching for book {}",bookName);      //{} är en placeholder, byter måsvingarna mot bookname
        return store.search(bookName); // Får tillbaka en arraylist med alla böker av bookname

    }

    public List<String> get_loans() throws Exception {        //bara returnera resultat //MOCKAD
       List<String> loans = store.fetch_loans();
        log.debug("Got loans {}",loans);      //{} är en placeholder, byter måsvingarna mot bookname
        return loans;
    }

    public void suspend(int memberID) throws Exception {            //MOCKAD
        log.debug("Suspending member {}",memberID);      //{} är en placeholder, byter måsvingarna mot bookname
        store.suspend_member(memberID);
    }

    public void warning(int memberID) throws Exception {        //MOCKAD
        log.debug("Warning member {}",memberID);      //{} är en placeholder, byter måsvingarna mot bookname
        store.warn_member(memberID);
    }

    public void insert_loan(String book) throws Exception {
        log.debug("Borrowing book {}",book);      //{} är en placeholder, byter måsvingarna mot bookname
        store.insert_loan(book);
    }

}
