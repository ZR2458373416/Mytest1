package view;

import entity.UserOfferPrice;
import entity.User;
import service.UserOfferPriceService;
import service.impl.UserOfferPriceServiceImpl;


import java.util.List;
import java.util.Scanner;

public class OfferPriceView {
    private UserOfferPriceService service= new UserOfferPriceServiceImpl();
    private Scanner sc=new Scanner(System.in);

    //查询所有商品
    public void selectAll(){
        List<UserOfferPrice> list= service.selectAll();
        //在视图层展示
        if(list==null){
            System.out.println("没有商品信息");
        }else {
            System.out.println("所有的商品信息");
            for(UserOfferPrice userOfferPrice:list){
                System.out.println(userOfferPrice);
            }
        }
        System.out.println();
    }

    //添加商品
    public void insert() {
        System.out.println("输入主键");
        int ofpld=sc.nextInt();
        System.out.println("输入价格有效开始时间");
        String effetiveStartDate=sc.next();
        System.out.println("输入价格有效结束时间");
        String effetiveEndDate=sc.next();
        System.out.println("输入商品编号");
        int prold=sc.nextInt();
        System.out.println("输入商品价格");
        int price=sc.nextInt();
        System.out.println("输入价格类型");
        String typeCd=sc.next();
        UserOfferPrice userOfferPrice=new UserOfferPrice(ofpld,effetiveStartDate,effetiveEndDate,prold,price,typeCd);
        int count =service.insert(userOfferPrice);
        System.out.println("--------"+(count >0? "添加成功":"添加失败")+"---------");
        System.out.println();
    }

    //删除商品
    public void delete() {
        System.out.println("输入商品的编号");
        int prold=sc.nextInt();
        UserOfferPrice userOfferPrice=new UserOfferPrice();
        userOfferPrice.setProld(prold);
        int count=service.delete(userOfferPrice);
        System.out.println("--------"+(count >0? "删除成功":"删除失败")+"---------");
        System.out.println();
    }

    //修改商品
    public void update() {
        System.out.println("输入要修改的商品编号");
        int prold=sc.nextInt();
        System.out.println();
        System.out.println("--------输入修改后的内容--------");
        System.out.println("输入价格有效开始时间");
        String effetiveStartDate=sc.next();
        System.out.println("输入价格有效结束时间");
        String effetiveEndDate=sc.next();
        System.out.println("输入商品编号");
        int prold1=sc.nextInt();
        System.out.println("输入商品价格");
        int price=sc.nextInt();
        System.out.println("输入价格类型");
        String typeCd=sc.next();
        UserOfferPrice userOfferPrice=new UserOfferPrice(effetiveStartDate,effetiveEndDate,prold1,price,typeCd);
        int count =service.update(userOfferPrice,prold);
        System.out.println("--------"+(count >0? "修改成功":"修改失败")+"---------");
        System.out.println();
    }

    //按商品编号查找
    public void select() {
        System.out.println("输入要查找的商品的编号");
        int prold=sc.nextInt();
        List<UserOfferPrice> list=service.select(prold);
        if(list==null){
            System.out.println("没有商品信息");
        }else {
            System.out.println("商品的信息为:");
            for(UserOfferPrice userOfferPrice:list){
                System.out.println(userOfferPrice);
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
