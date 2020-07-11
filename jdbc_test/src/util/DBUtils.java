package util;

import java.sql.*;

public class DBUtils {

    private  static DBUtils db=null;

    private DBUtils(){}

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //判断DBUtils实例化的对象是否存在 ,不存在就实例化一个
    public static DBUtils getDb(){
        if(db==null){
            synchronized (DBUtils.class) {
                if(db==null){
                    db=new DBUtils();
                }
            }
        }
        return db;
    }

    //连接对象
    public  Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/mysqldb","root","mariadb");
    }

    //关闭资源
    public  void close(Connection conn, Statement stat, ResultSet rs){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        } if(stat!=null){
            try{
                stat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}