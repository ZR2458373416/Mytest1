package service.impl;

import dao.UserProductDao;
import dao.impl.UserProductDaoImpl;
import entity.UserProduct;
import entity.User;
import service.UserProductService;

import java.util.List;

public class UserProductServiceImpl implements UserProductService {
    private UserProductDao dao= new UserProductDaoImpl();
    //查询所有商品
    @Override
    public List<UserProduct> selectAll() {
        String sql="select * from Product";
        List<UserProduct> list=dao.selectAll(sql);
        return list;
    }

    //添加商品
    @Override
    public int insert(UserProduct userProduct) {
        String sql="insert into Product values(?,?,?)";
        int count=dao.insert(sql,userProduct);
        return count;
    }

    //删除商品
    @Override
    public int delete(UserProduct userProduct) {
        String sql="delete from product where sku=?";
        int count=dao.delete(userProduct,sql);
        return count;
    }

    //修改商品
    @Override
    public int update(UserProduct userproduct, int sku) {
        String sql="update product set sku=?,Title=? where sku=?";
        int count=dao.update(userproduct,sql,sku);
        return count;
    }

    //按商品名称查询
    @Override
    public List<UserProduct> select(String title) {
        String sql="select * from product where title=?";
        List<UserProduct> list =dao.select(sql,title);
        return list;
    }

    //查找商品的价格和打折情况
    @Override
    public List<User> selectAllTwo() {
        String sql="select p.Prold,p.Sku,p.Title,o.EffetiveStartDate,o.EffetiveEndDate,o.Price,o.TypeCd from product p join OfferPrice o on p.Sku = o.Prold";
        List<User> list=dao.selectAllTwo(sql);
        return list;
    }

}
