package entity;

public class UserProduct {
    private int prold;
    //商品编码
    private int sku;
    //商品名称
    private String title;

    public UserProduct(){}

    public UserProduct( int prold,int sku, String title) {
        this.prold=prold;
       this.sku=sku;
        this.title = title;
    }

    public UserProduct(int sku, String title){
        this.sku=sku;
        this.title = title;
    }
    public int getProld() {
        return prold;
    }

    public void setProld(int Prold) {
        this.prold=prold;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "UserProduct{" +
                "主键=" + prold +
                ", 商品编号=" + sku +
                ", 商品名称='" + title + '\'' +
                '}';
    }
}
