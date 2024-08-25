public class P {
    public int Id;
    public String Comment;
    public int CatId;
    public float Amount;
    public P(int id, java.util.Date date, float amount, String comment, int categoryId) {

        Id = id;
        CatId = categoryId;
        Date = date;
        Comment = comment;
        Amount = amount;
    }

    public P() {

    }
    public java.util.Date Date;

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }
    public int getCategoryId() {
        return CatId;
    }

    public void setCategoryId(int categoryId) {
        CatId = categoryId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }


}
