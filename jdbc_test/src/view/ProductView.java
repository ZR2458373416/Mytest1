package view;

import entity.UserProduct;
import entity.User;
import service.UserProductService;
import service.impl.UserProductServiceImpl;

import java.util.List;
import java.util.Scanner;


public class ProductView {
    private UserProductService service= new UserProductServiceImpl();
    private Scanner sc=new Scanner(System.in);
    //查询所有
    public void selectAll(){

        List<UserProduct> list= service.selectAll();
        //在视图层展示
        if(list==null){
            System.out.println("没有商品信息");
        }else {
            System.out.println("所有的商品信息");
            for(UserProduct userProduct:list){
                System.out.println(userProduct);
            }
        }
        System.out.println();
    }

    //添加商品
    public void insert() {
        System.out.println("输入主键");
        int prold=sc.nextInt();
        System.out.println("输入商品编号");
        int sku=sc.nextInt();
        System.out.println("输入商品名称");
        String title=sc.next();
        UserProduct userProduct=new UserProduct(prold,sku,title);
        int count =service.insert(userProduct);
        System.out.println("--------"+(count >0? "添加成功":"添加失败")+"---------");
        System.out.println();

    }

    //删除商品
    public void delete() {
        System.out.println("输入商品的编号");
        int sku=sc.nextInt();
        UserProduct userProduct=new UserProduct();
        userProduct.setSku(sku);
        int count=service.delete(userProduct);
        System.out.println("--------"+(count >0? "删除成功":"删除失败")+"---------");
        System.out.println();

    }

    //修改商品
    public void update() {
        System.out.println("输入要修改的商品编号");
        int sku=sc.nextInt();
        System.out.println();
        System.out.println("--------输入修改后的内容--------");
        System.out.println("输入修改后的商品编号");
        int sku1=sc.nextInt();
        System.out.println("输入修改后商品名称");
        String title=sc.next();
        UserProduct userProduct=new UserProduct(sku1,title);
        int count =service.update(userProduct,sku);
        System.out.println("--------"+(count >0? "修改成功":"修改失败")+"---------");
        System.out.println();
    }

    /*
        查找指定商品
        按商品名称查找
     */
    public void select() {
        System.out.println("输入要查找的商品名称");
        String title=sc.next();
        List<UserProduct> list=service.select(title);
        if(list==null){
            System.out.println("没有商品信息");
        }else {
            System.out.println("商品的信息为:");
            for(UserProduct userProduct:list){
                System.out.println(userProduct);
            }
        }
        System.out.println();
    }

    //查找商品的价格和打折情况
    public void selectAllTwo() {
        List<User> list= service.selectAllTwo();
        //在视图层展示
        if(list==null){
            System.out.println("没有商品信息");
        }else {
            System.out.println("所有的商品信息");
            for(User userTwoTable:list){
                System.out.println(userTwoTable);
            }
        }
        System.out.println();
    }

}
