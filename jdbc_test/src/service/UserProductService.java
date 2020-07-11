package service;

import entity.UserProduct;
import entity.User;

import java.util.List;

public interface UserProductService {
    //查询所有商品
    List<UserProduct> selectAll();

    //添加商品
    int insert(UserProduct userProduct);

    //删除商品
    int delete(UserProduct userProduct);

    //修改商品
    int update(UserProduct userproduct, int sku);

    //按商品名称查询
    List<UserProduct> select(String title);

    //查找商品的价格和打折情况
    List<User> selectAllTwo();

}
