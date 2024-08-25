package Service;
import Store.Store;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ServiceTest {

    @Test
    public void testgetloans() throws Exception {           //testar om inga lån finns
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.fetch_loans())
                .thenReturn(List.of());
        assertEquals(List.of(), service.get_loans());
    }

    @Test
    public void testgetloan_bookexist() throws Exception {           //testar om lån finns
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.fetch_loans())
                .thenReturn(List.of("Harry Potter", "Twilight"));
        assertEquals(List.of("Harry Potter", "Twilight"), service.get_loans());
    }

    @Test
    public void testreturnBook() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.try_return(any()))
                .thenReturn(0);
        assertEquals(0, service.returnBook(" "));
    }

    @Test
    public void testreturnBook_2() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.try_return(any()))
                .thenReturn(1);
        assertEquals(1, service.returnBook(" "));
    }

    @Test
    public void testserchbook() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.search("Twilight"))
                .thenReturn(List.of("Twilight"));
        assertEquals(List.of("Twilight"), service.search_book("Twilight"));
    }

    @Test
    public void testserchbook_noloan() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        when(store.search(""))
                .thenReturn(List.of());
        assertEquals(List.of(), service.search_book(""));
    }

    @Test
    public void testardeletemember() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        List<Integer> list = new ArrayList<>();
        list.add(1003);
        list.add(1004);
        doAnswer(invocationOnMock -> {                          //exekvera rad 80
            list.remove(invocationOnMock.getArgument(0));          //ta bort argumentet som skickas in
            return 0;
        }).when(store).delete(1003);
        service.delete_member(1003);
        assertEquals(1,list.size());
        service.delete_member(1000);            //tar bort en member som inte finns
        assertEquals(1,list.size());
    }
    @Test
    public void testarsuspendmember() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        Map<Integer,String> map = new HashMap<>();
        map.put(1003,"N");
        map.put(1004,"N");
        doAnswer(invocationOnMock -> {
            map.put(invocationOnMock.getArgument(0), "Y");
            return 0;
        }).when(store).warn_member(1003);
        service.warning(1003);
        assertEquals("Y",map.get(1003));
        service.warning(1000);
        assertEquals("N",map.get(1004));
    }
    @Test
    public void testarwarnmember() throws Exception {
        Store store = mock(Store.class);
        Service service = new Service(store);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1003,0);
        map.put(1004,0);
        doAnswer(invocationOnMock -> {
            map.put(invocationOnMock.getArgument(0), 1);
            return 0;
        }).when(store).warn_member(1003);
        service.warning(1003);
        assertEquals(1,map.get(1003));
        service.warning(1000);
        assertEquals(0,map.get(1004));
    }
}



