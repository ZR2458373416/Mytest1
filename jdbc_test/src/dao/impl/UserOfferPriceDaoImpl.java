package dao.impl;


import dao.UserOfferPriceDao;
import entity.UserOfferPrice;
import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserOfferPriceDaoImpl implements UserOfferPriceDao {
    //查询所有商品
    @Override
    public List<UserOfferPrice> selectAll(String sql) {
        List<UserOfferPrice> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int ofpld = rs.getInt(1);
                String effetiveStartDate=rs.getString(2);
                String effetiveEndDate=rs.getString(3);
                int prold=rs.getInt(4);
                int price=rs.getInt(5);
                String TypeCd=rs.getString(6);
                //通过构造赋值
                UserOfferPrice userOfferPrice=new UserOfferPrice(ofpld,effetiveStartDate,effetiveEndDate,prold,price,TypeCd);
                //讲查询结果放入集合
                list.add(userOfferPrice);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,rs);
        }

        return list;
    }

    //添加商品
    @Override
    public int insert(String sql, UserOfferPrice userOfferPrice) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn=DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userOfferPrice.getOfpld());
            ps.setString(2,userOfferPrice.getEffetiveStartDate());
            ps.setString(3,userOfferPrice.getEffetiveEndDate());
            ps.setInt(4,userOfferPrice.getProld());
            ps.setInt(5,userOfferPrice.getPrice());
            ps.setString(6,userOfferPrice.getTypeCd());
            int count =ps.executeUpdate();
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,null);
        }
        return 0;
    }

    //删除商品
    @Override
    public int delete(String sql, UserOfferPrice userOfferPrice) {
        Connection conn=null;
        PreparedStatement ps=null;
        int flag=0;
        try{
            conn=DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userOfferPrice.getProld());
            int count =ps.executeUpdate();
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,null);
        }
        return 0;
    }

    //修改商品
    @Override
    public int update(int prold, UserOfferPrice userOfferPrice, String sql) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn=DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,userOfferPrice.getEffetiveStartDate());
            ps.setString(2,userOfferPrice.getEffetiveEndDate());
            ps.setInt(3,userOfferPrice.getProld());
            ps.setInt(4,userOfferPrice.getPrice());
            ps.setString(5,userOfferPrice.getTypeCd());
            ps.setInt(6,prold);
            int count =ps.executeUpdate();
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,null);
        }
        return 0;
    }

    //按商品编号查找
    @Override
    public List<UserOfferPrice> select(int prold,String sql) {
        List<UserOfferPrice> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            conn=DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,prold);
            rs=ps.executeQuery();
            while(rs.next()){
                int ofpld = rs.getInt(1);
                String effetiveStartDate=rs.getString(2);
                String effetiveEndDate=rs.getString(3);
                rs.getInt(4);
                int price=rs.getInt(5);
                String TypeCd=rs.getString(6);
                UserOfferPrice userOfferPrice=new UserOfferPrice(ofpld,effetiveStartDate,effetiveEndDate,prold,price,TypeCd);
                list.add(userOfferPrice);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,rs);
        }

        return list;
    }

    //查找商品的价格和打折情况
    @Override
    public List<User> selectAllTwo(String sql) {
        List<User> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int prold =rs.getInt(1);
                int sku=rs.getInt(2);
                String title=rs.getString(3);
                String effetiveStartDate=rs.getString(4);
                String effetiveEndtDate=rs.getString(5);
                int proce=rs.getInt(6);
                String typecd=rs.getString(7);
                //通过构造赋值
                User UserTwoTable=new User(prold,sku,title,effetiveStartDate,effetiveEndtDate,proce,typecd);
                //讲查询结果放入集合
                list.add(UserTwoTable);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,rs);
        }

        return list;
    }
}
