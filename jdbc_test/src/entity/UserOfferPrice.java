package entity;
import java.text.ParseException;

public class UserOfferPrice {
    //主键
    private int Ofpld ;
    //价格有效开始时间
    private String EffetiveStartDate;
    //价格有效结束时间
    private String EffetiveEndDate;
    //关联Product表
    private int Prold;
    //单价
    private int Price;
    //价格类型
    private String TypeCd;
    public UserOfferPrice(){}

    public UserOfferPrice(int ofpld, String effetiveStartDate, String effetiveEndDate, int prold, int price, String typeCd) {
        Ofpld = ofpld;
        EffetiveStartDate = effetiveStartDate;
        EffetiveEndDate = effetiveEndDate;
        Prold = prold;
        Price = price;
        TypeCd = typeCd;
    }

    public UserOfferPrice(String effetiveStartDate, String effetiveEndDate, int prold,int price, String typeCd){
        Prold = prold;
        EffetiveStartDate = effetiveStartDate;
        EffetiveEndDate = effetiveEndDate;
        Price = price;
        TypeCd = typeCd;
    }
    public int getOfpld() {
        return Ofpld;
    }

    public void setOfpld(int ofpld) {
        Ofpld = ofpld;
    }

    public String getEffetiveStartDate() {
        return EffetiveStartDate;
    }

    public void setEffetiveStartDate(String EffetiveStartDate) throws ParseException {

        this.EffetiveStartDate=EffetiveStartDate;

    }

    public String getEffetiveEndDate() {
        return EffetiveEndDate;
    }

    public void setEffetiveEndDate(String EffetiveEndDate) throws ParseException {

        this.EffetiveEndDate=EffetiveEndDate;
    }

    public int getProld() {
        return Prold;
    }

    public void setProld(int prold) {
        Prold = prold;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getTypeCd() {
        return TypeCd;
    }

    public void setTypeCd(String typeCd) {
        TypeCd = typeCd;
    }

    @Override
    public String toString() {
        return "UserOfferPrice{" +
                "主键=" + Ofpld +
                ", 价格有效开始时间='" + EffetiveStartDate + '\'' +
                ", 价格有效结束时间='" + EffetiveEndDate + '\'' +
                ", 商品编号='" + Prold + '\'' +
                ", 单价=" + Price +
                ", 价格类型='" + TypeCd + '\'' +
                '}';
    }
}
