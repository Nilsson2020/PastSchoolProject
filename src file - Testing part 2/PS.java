import java.util.Date;

public class PS implements IPS
{

    @Override
public C[] getAllC() {
    return new C[0];
}
    @Override
    public P[] getP(Date startDate, Date endDate) {
        return new P[0];
    }

    @Override
    public P[] getPurchasesByCat(Date startDate, Date endDate, int catId) {
        return new P[0];
    }


}
