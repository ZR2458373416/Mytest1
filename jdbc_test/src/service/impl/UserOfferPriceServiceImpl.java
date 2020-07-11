package service.impl;

import dao.UserOfferPriceDao;
import dao.impl.UserOfferPriceDaoImpl;
import entity.UserOfferPrice;
import entity.User;
import service.UserOfferPriceService;

import java.util.List;

public class UserOfferPriceServiceImpl implements UserOfferPriceService {
    private UserOfferPriceDao dao= new UserOfferPriceDaoImpl();
    //查询所有商品
    @Override
    public List<UserOfferPrice> selectAll() {
        String sql="select * from offerprice";
        List<UserOfferPrice> list=dao.selectAll(sql);
        return list;
    }

    //添加商品
    @Override
    public int insert(UserOfferPrice userOfferPrice) {
        String sql="insert into offerprice values(?,?,?,?,?,?)";
        int count=dao.insert(sql,userOfferPrice);
        return count;
    }

    //删除商品
    @Override
    public int delete(UserOfferPrice userOfferPrice) {
        String sql="delete from offerprice where prold=?";
        int count=dao.delete(sql,userOfferPrice);
        return count;
    }

    //修改商品
    @Override
    public int update(UserOfferPrice userOfferPrice, int prold) {
        String sql="update offerprice set EffetiveStartDate=?,EffetiveEndDate=?,Prold=?,Price=?,TypeCd=? where Prold=?";
        int count=dao.update(prold,userOfferPrice,sql);
        return count;
    }

    //按商品编号查找
    @Override
    public List<UserOfferPrice> select(int prold) {
        String sql="select * from OfferPrice where prold=?";
        List<UserOfferPrice> list=dao.select(prold,sql);
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
