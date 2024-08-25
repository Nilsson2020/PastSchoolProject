import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PSS extends PS {

    ArrayList<P> kop = new ArrayList<>();
    ArrayList<C> Cat= new ArrayList<>();


    @Override
    public P[] getP(Date startDate, Date endDate) {
        ArrayList<P> store = new ArrayList<P>();
        for (P p : kop) {
            if (p.getDate().compareTo(startDate) >= 0 && p.getDate().compareTo(endDate) <= 0) {

                store.add(p);
            }
        }

        P [] let = new P[store.size()];
        store.toArray(let);
        System.out.println(Arrays.toString(let));
        return let;

    }



    @Override
    public P[] getPurchasesByCat(Date startDate, Date endDate, int catId) {
        kop= new ArrayList<>();
        for (P p : kop) {

            if (p.getCategoryId() == catId && p.getDate().compareTo(startDate) >= 0
                    && p.getDate().compareTo(endDate) <= 0) {

                kop.add(p);
            }
        }
        P [] purr = new P[kop.size()];
        kop.toArray(purr);
        System.out.println(Arrays.toString(purr));

        return purr;


    }

    @Override
    public C[] getAllC() {

        C[] let = new C[Cat.size()];
        Cat.toArray(let);

        System.out.println(Arrays.toString(let));
        return Cat.toArray(let);
    }

}




