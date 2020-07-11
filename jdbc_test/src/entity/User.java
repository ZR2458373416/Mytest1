package entity;

public class User {
    private int  prold;
    private int sku;
    private String title;
    private String effetiveStartDate;
    private String effetiveEndDate;
    private int price;
    private String typeCd;

    public User(int prold, int sku, String title, String effetiveStartDate, String effetiveEndDate, int price, String typeCd) {
        this.prold = prold;
        this.sku = sku;
        this.title = title;
        this.effetiveStartDate = effetiveStartDate;
        this.effetiveEndDate = effetiveEndDate;
        this.price = price;
        this.typeCd = typeCd;
    }

    @Override
    public String toString() {
        return "UserTwoTable{" +
                "主键=" + prold +
                ", 商品编号=" + sku +
                ", 商品名称='" + title + '\'' +
                ", 价格有效开始时间='" + effetiveStartDate + '\'' +
                ", 价格有效结束时间='" + effetiveEndDate + '\'' +
                ", 价格=" + price +
                ", 价格类型='" + typeCd + '\'' +
                '}';
    }
}
