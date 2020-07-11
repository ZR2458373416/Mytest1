package dao.impl;

import dao.UserProductDao;
import entity.UserProduct;
import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserProductDaoImpl implements UserProductDao {
    //查询所有商品
    @Override
    public List<UserProduct> selectAll(String sql) {
        List<UserProduct> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               int prold = rs.getInt(1);
               int sku=rs.getInt(2);
               String title=rs.getString(3);
               //通过构造赋值
               UserProduct userproduct=new UserProduct(prold,sku,title);
               //讲查询结果放入集合
               list.add(userproduct);
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
    public int insert(String sql, UserProduct userProduct) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userProduct.getProld());
            ps.setInt(2,userProduct.getSku());
            ps.setString(3,userProduct.getTitle());
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
    public int delete(UserProduct userProduct, String sql) {
        Connection conn=null;
        PreparedStatement ps=null;
        int flag=0;
        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userProduct.getSku());
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
    public int update(UserProduct userproduct, String sql,int sku) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userproduct.getSku());
            ps.setString(2,userproduct.getTitle());
            ps.setInt(3,sku);
            int count =ps.executeUpdate();
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getDb().close(conn,ps,null);
        }
        return 0;
    }

    //按商品名称查找
    @Override
    public List<UserProduct> select(String sql, String title) {

        List<UserProduct> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            conn= DBUtils.getDb().getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,title);
            rs=ps.executeQuery();
            while(rs.next()){
               int prold=rs.getInt(1);
               int sku=rs.getInt(2);
               rs.getString(3);
               UserProduct userProduct=new UserProduct(prold,sku,title);
               list.add(userProduct);
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
            conn=  DBUtils.getDb().getConnection();
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
