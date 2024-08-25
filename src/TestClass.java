import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    @Test
    //Get positive average

    void getPosAverage() throws ArithmeticException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{1, 2, 3, 4, 5};
        Assertions.assertEquals(3, NewArray.getAverage());
    }






    @Test
    //Get average in empty array

    void getEmptyAverage() throws NullPointerException {
        Array test = new Array();
        test.dataArray = new int[]{};
        assertThrows(ArithmeticException.class, () -> test.getAverage());
    }

    @Test
    //Find positive position

    void findPosPosition() throws NullPointerException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{20, 30, 40, 60, 70};
        assertArrayEquals(new int[]{1}, NewArray.findPositions(30));
    }
    @Test
    //Find negative position

    void findNegPosition() throws NullPointerException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{20, 30, 40, 60, 70};
        assertNotEquals(new int[]{1}, NewArray.findPositions(30));
    }

    @Test
    //Position in empty array

    void findPositionEmpty() throws NullPointerException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{};
        assertThrows(NullPointerException.class, () -> NewArray.findPositions(1));
    }

    @Test
    //AppendLast positive

    void appendLastPositive() throws NullPointerException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{1, 2, 3, 4, 5, 6};
        NewArray.appendLast(7);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, NewArray.dataArray);
    }

    @Test
    //AppendLast in empty array

    void appendLastEmpty() throws ArithmeticException {
        Array a = new Array();
        a.dataArray = new int[]{};
        assertThrows(ArithmeticException.class, () -> a.appendLast(7));
    }

    @Test
    //Positive InsertAt

    void insertAtPositive() throws IndexOutOfBoundsException {
        Array a = new Array();
        a.dataArray = new int[]{1, 2, 3, 4, 5};
        a.insertAt(2, 4);
        assertArrayEquals(new int[]{1, 2, 4, 3, 4, 5}, a.dataArray);
    }


    //


    @Test
    //InsertAt empty array

    void insertAtEmpty() throws IndexOutOfBoundsException {
        Array NewArray = new Array();
        NewArray.dataArray = new int[]{};
        assertThrows(IndexOutOfBoundsException.class, () -> NewArray.insertAt(2, 4));
    }

    @Test
    //GetAt - positive

    void getAt() throws ArithmeticException {
        Array test = new Array();
        test.dataArray = new int[]{1, 2, 3, 4, 5, 6};

        assertEquals(3, test.getAt(2));
    }



    @Test
    //GetAt - empty array

    void getAtEmpty() throws ArithmeticException {
        Array test = new Array();
        test.dataArray = new int[]{};
        assertThrows(ArithmeticException.class, () -> test.getAt(0));
    }

    @Test
    //SetAt positive

    void setAtPositive() throws ArithmeticException {
        Array test = new Array();
        test.dataArray = new int[]{1, 2, 3, 4, 5};

        int[] NewArray = new int[]{1, 2, 3, 4, 5};
        test.setAt(3, 4);
        assertArrayEquals(NewArray, test.dataArray);
    }



    @Test
    //SetAt empty

    void setAtEmpty() throws ArithmeticException {
        Array test = new Array();
        test.dataArray = new int[]{};

        assertThrows(ArithmeticException.class, () -> test.setAt(2, 6));
    }

    @Test
    //DeleteAt positive

    void deleteAtPositive() throws ArithmeticException, ArrayIndexOutOfBoundsException, IIntArray.anotherException {
        Array test = new Array();
        test.dataArray = new int[]{20, 30, 40, 50, 60};

        assertEquals(40, test.deleteAt(2));
    }

    @Test
    //DeleteAt - negative

    void deleteAtNegative() throws ArithmeticException, IIntArray.anotherException {
        Array test = new Array();
        test.dataArray = new int[]{1, 2, 3, 4};

        int Array1 = test.deleteAt(2);

        Array NewArray = new Array();
        NewArray.dataArray = new int[]{1, 2, 3, 4};


        int Array2 = NewArray.deleteAt(1);

        assertNotEquals(Array1, Array2);
    }

    @Test
    //DeleteAt - empty

    void deleteAtEmpty() throws IIntArray.anotherException, ArrayIndexOutOfBoundsException {
        Array test = new Array();
        test.dataArray = new int[]{20, 30, 40, 50};

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> test.deleteAt(4));
    }
}