package dao;

import entity.UserOfferPrice;
import entity.User;

import java.util.List;

public interface UserOfferPriceDao {
    //查询所有商品
    List<UserOfferPrice> selectAll(String sql);

    //添加商品
    int insert(String sql, UserOfferPrice userOfferPrice);

    //删除商品
    int delete(String sql, UserOfferPrice userOfferPrice);

    //修改商品
    int update(int prold, UserOfferPrice userOfferPrice, String sql);

    //按商品编号查找
    List<UserOfferPrice> select(int prold,String sql);

    //查找商品的价格和打折情况
    List<User> selectAllTwo(String sql);
}
