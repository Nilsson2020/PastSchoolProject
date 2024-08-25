import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class PMT {

    @Test
    void SumOfMonth_Mocking(){
        PSS mock_let = mock(PSS.class);
        PM check = new PM(mock_let);

        when(mock_let.getP(new Date(2020, 5,1), new Date(2020,5,31))).
                thenReturn(new P[]{new P(1,new Date(2020,5,5),230,"N",1),
                        new P(1,new Date(2020,5,5), 230, "N", 2)});


        assertEquals(460, check.sumOfMonth(2020,5));
    }
    @Test
    void sumOfMonth() {
        PSS store = new PSS();
        PM cut = new PM(store);

        store.kop.add(new P(1, new Date(2022, 11, 21), 4, " N4", 1));
        store.kop.add(new P(2, new Date(2023, 9, 4),49, "N1", 3));
        store.kop.add(new P(3, new Date(2019, 8, 7), 90, "N2", 1));


        assertEquals(4, cut.sumOfMonth(2022, 11));
    }


    @Test
    void yearlyAvgPerCat() {

        PSS store = new PSS();
        PM check = new PM(store);



        store.kop.add(new P(2, new Date(2023, 9, 19), 100, "X", 2));
        store.kop.add(new P(2, new Date(2023, 9, 19), 100, "X", 2));
        store.kop.add(new P(1, new Date(2023, 9, 19), 200, "X", 1));
        store.kop.add(new P(1, new Date(2023, 9, 19), 600, "X", 1));
        store.kop.add(new P(3, new Date(2023, 9, 19), 800, "X", 3));
        store.kop.add(new P(3, new Date(2023, 9, 19), 600, "X", 3));

        store.Cat.add(new C(1, "X"));
        store.Cat.add(new C(2, "X"));
        store.Cat.add(new C(3, "X"));


        assertArrayEquals(new float[] {400, 100,700}, check.yearlyAvgPerC(2023));
    }
    @Test
    void MontlhyAvgCat_Mocking() {
        IPS mock_pur = mock(IPS.class);
        PM check = new PM(mock_pur);


        when(mock_pur.getAllC()).thenReturn(new C[]
                {new C(1,"X"), new C(2,"X"), new C(3,"X")
                        , new C(4, "X")});

        when(mock_pur.getP(new Date(2022,1,1), new Date(2022,12,31))).
                thenReturn(new P[]{
                        new P(1,  new Date(2022,1,15), 800,"X",1),
                        new P(2,  new Date(2022,1,15), 800,"X",1),
                        new P(3,  new Date(2022,1,15), 400,"X",2),
                        new P(4,  new Date(2022,1,15), 400,"X",2),
                        new P(5,  new Date(2022,1,15), 800,"X",3),
                        new P(6,  new Date(2022,1,15), 400,"X",3),
                        new P(2,  new Date(2022,1,15), 900,"X",4),
                        new P(2,  new Date(2022,1,15), 900,"X",4)});

        float[] expected = new float[] {800,400,600,900};


        assertArrayEquals(check.yearlyAvgPerC(2022),expected);


    }





    @Test
    void MontlhyAvg_Mocking(){
        IPS mock_let = mock(IPS.class);
        PM check = new PM(mock_let);

        when(mock_let.getP(new Date(2023, 1,1), new Date(2023,1,31))).
                thenReturn(new P[]{new P(1,new Date(2023,1,5),200,"X",1),
                        new P(1, new Date(2023,1,6), 2000, "X", 1)});
        when(mock_let.getP(new Date(2023, 2,1), new Date(2023,2,31))).
                thenReturn(new P[]{new P(1,new Date(2023,2,5),0,"X",1)});
        when(mock_let.getP(new Date(2023, 3,1), new Date(2023,3,31))).
                thenReturn(new P[]{new P(1,new Date(2023,3,5),100,"X",1)});
        when(mock_let.getP(new Date(2023, 4,1), new Date(2023,4,31))).
                thenReturn(new P[]{new P(1,new Date(2023,4,5),300,"X",1)});
        when(mock_let.getP(new Date(2023, 5,1), new Date(2023,5,31))).
                thenReturn(new P[]{new P(1,new Date(2023,5,5),100,"X",1)});
        when(mock_let.getP(new Date(2023, 6,1), new Date(2023,6,31))).
                thenReturn(new P[]{new P(1,new Date(2023,6,5),100,"X",1)});
        when(mock_let.getP(new Date(2023, 7,1), new Date(2023,7,31))).
                thenReturn(new P[]{new P(1,new Date(2023,7,5),280,"X",1)});
        when(mock_let.getP(new Date(2023, 8,1), new Date(2023,8,31))).
                thenReturn(new P[]{new P(1,new Date(2023,8,5),700,"X",1)});
        when(mock_let.getP(new Date(2023, 9,1), new Date(2023,9,31))).
                thenReturn(new P[]{new P(1,new Date(2023,9,5),200,"X",1)});
        when(mock_let.getP(new Date(2023, 10,1), new Date(2023,10,31))).
                thenReturn(new P[]{new P(1,new Date(2023,10,5),900,"X",1)});
        when(mock_let.getP(new Date(2023, 11,1), new Date(2023,11,31))).
                thenReturn(new P[]{new P(1,new Date(2023,11,5),400,"X",1)});
        when(mock_let.getP(new Date(2023, 12,1), new Date(2023,12,31))).
                thenReturn(new P[]{new P(1,new Date(2023,12,5),200,"X",1)});



        float[] expected = new float[] {1100,0,100,300,100,100,280,700,200,900,400,200};
        assertArrayEquals(check.monthlyAvg(2023),expected);


    }

    @Test
    void monthlyAvg() {
        PSS store = new PSS();
        PM check= new PM(store);

        P t1 = new P(1, new Date(2019, 1, 6), 100, "X", 1);
        P t1x1 = new P(1, new Date(2019, 1, 6), 100, "X", 2);
        P t1x2 = new P(1, new Date(2019, 1, 6), 100, "X", 2);
        P t2 = new P(1, new Date(2019, 2, 14), 100, "X", 3);
        P t3 = new P(1, new Date(2019, 3, 10), 100, "X", 4);
        P t4 = new P(1, new Date(2019, 4, 6), 0, "X", 2);
        P t5 = new P(1, new Date(2019, 5, 6), 0, "X", 1);
        P t6 = new P(1, new Date(2019, 6, 6), 0, "X", 1);
        P t7 = new P(1, new Date(2019, 7, 11), 100, "X", 9);
        P t8 = new P(1, new Date(2019, 8, 12), 100, "X", 3);
        P t9 = new P(1, new Date(2019, 9, 13), 600, "X", 7);
        P t10 = new P(1, new Date(2019, 10, 14), 800, "X", 7);
        P t11 = new P(1, new Date(2019, 11, 15), 750, "X", 2);
        P t12 = new P(1, new Date(2019, 12, 16), 900, "X", 1);

        store.kop.add(t1);
        store.kop.add(t1x1);
        store.kop.add(t1x2);
        store.kop.add(t2);
        store.kop.add(t3);
        store.kop.add(t4);
        store.kop.add(t5);
        store.kop.add(t6);
        store.kop.add(t7);
        store.kop.add(t8);
        store.kop.add(t9);
        store.kop.add(t10);
        store.kop.add(t11);
        store.kop.add(t12);



        float[] expected = new float[]{100, 100, 100, 0, 0, 0, 100, 100, 600, 800, 750,900};

        assertArrayEquals(expected, check.monthlyAvg(2019));

    }
}

