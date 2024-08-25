public class C {
    public int Id;
    private String Desc;

    public C(int id, String desc) {
        Id = id;
        Desc = desc;
    }

    public C() {

    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

}


