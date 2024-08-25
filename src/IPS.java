import java.util.Date;

public interface IPS {

    P[] getP(Date startDate, Date endDate);

    P[] getPurchasesByCat(Date startDate, Date endDate, int catId);

    C[] getAllC();

}
