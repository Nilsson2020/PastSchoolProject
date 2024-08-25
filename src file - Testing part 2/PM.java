import java.util.Date;

public class PM implements IPM{

    IPS let = null;

    public PM(IPS ax){
        let = ax;
    }


    int quantity = 0;
    float[] averageM = new float[12];
    float t = 0;

    float f = 0;






    @Override
    public float[] yearlyAvgPerC(int year) {


        int l = -1;
        C[] categories = let.getAllC();
        float []  AverageCategory =  new float[categories.length];
        for (int i = 0; i < categories.length; i++) {
            l++;

            float t = 0;
            int f = 0;

            for (P x : let.getP(new Date(year, 1, 1), new Date(year, 12,31))) {
                if (x.getCategoryId() == categories[i].Id ) {
                    t += x.getAmount();
                    f++;
                }


            }
            t = t/f;
            AverageCategory[i] = t;

        }
        System.out.println(AverageCategory);
        return AverageCategory;

    }

    @Override
    public float[] monthlyAvg(int year) {

        for (int month = 0; month < 12; month++) {

            for (P p : let.getP(new Date(year,month +1 ,1), new Date(year,month +1 ,31))) {
                quantity++;
                t = t + p.getAmount();
            }
            t = t / quantity;

            System.out.println(t);
            averageM[month] = t;
            quantity = 0;
            t = 0;

        }
        return averageM;
    }
    @Override
    public float sumOfMonth(int year, int month) {


        P[] data = let.getP(new Date(year, month, 1), new Date(year, month, 31));
        for (P datum : data) {
            t += datum.getAmount();
        }
        System.out.println(t);
        return t;
    }






}
