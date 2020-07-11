package view;

import java.util.Scanner;

public class TotalSystem {
    //用于接收键盘录入
    private Scanner sc=new Scanner(System.in);

    //启动系统
    public void start(){
        System.out.println("-------欢迎访问商品管理系统--------");
        System.out.println("--------请选择您要操作的表---------");
        System.out.println("--------1.Product表-------");
        System.out.println("--------2.OfferPrice表-------");
    }
    //退出系统
    public void exit(){
        System.out.println("-------您已退出商品管理系统--------");
        System.exit(0);

    }
    //显示菜单
    public void menu(){
        System.out.println("-------1.查看表中所有商品信息--------");
        System.out.println("-------2.添加商品信息--------");
        System.out.println("-------3.删除商品信息--------");
        System.out.println("-------4.修改商品信息--------");
        System.out.println("-------5.查找指定商品--------");
        System.out.println("-------6.查找商品的打折情况--------");
        System.out.println("-------7.退出系统--------");
    }
    //接收选择
    public int Choose(){
        System.out.println("输入你的选择");
        return sc.nextInt();
    }
    //表内选择
    public int Choosemenu(){
        System.out.println("输入你的选择");
        return sc.nextInt();
    }
}
