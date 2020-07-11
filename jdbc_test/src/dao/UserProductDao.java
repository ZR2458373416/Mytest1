package dao;

import entity.UserProduct;
import entity.User;

import java.util.List;

public interface UserProductDao {
    //查询所有商品
    List<UserProduct> selectAll(String sql);

    //添加商品
    int insert(String sql, UserProduct userProduct);

    //删除商品
    int delete(UserProduct userProduct, String sql);

    //修改商品
    int update(UserProduct userproduct, String sql,int sku);

    //按商品名称查找
    List<UserProduct> select(String sql, String title);

    //查找商品的价格和打折情况
    List<User> selectAllTwo(String sql);
}
