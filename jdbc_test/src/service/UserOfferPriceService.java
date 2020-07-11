package service;

import entity.UserOfferPrice;
import entity.User;

import java.util.List;

public interface UserOfferPriceService {
    //查询所有商品
    List<UserOfferPrice> selectAll();

    //添加商品
    int insert(UserOfferPrice userOfferPrice);

    //删除商品
    int delete(UserOfferPrice userOfferPrice);

    //修改商品
    int update(UserOfferPrice userOfferPrice, int prold);

    //按商品编号查找
    List<UserOfferPrice> select(int prold);

    //查找商品的价格和打折情况
    List<User> selectAllTwo();

}
