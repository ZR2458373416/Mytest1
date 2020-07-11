package test;

import view.TotalSystem;
import view.OfferPriceView;
import view.ProductView;

public class Test {
    public static void main(String[] args) {
        TotalSystem allSystem = new TotalSystem();
        ProductView productSystem = new ProductView();
        OfferPriceView offerPriceSystem=new OfferPriceView();
        //欢迎界面
        allSystem.start();
        //输入选择
        int index = allSystem.Choose();

        if (index == 1) {
            //操作Product表
            while (true) {
                //选择增删改查
                allSystem.menu();
                //输入选择
                int indextable = allSystem.Choosemenu();

                switch (indextable) {
                    case 1:
                        //查看所有商品
                        productSystem.selectAll();
                        break;
                    case 2:
                        //添加商品
                        productSystem.insert();
                        break;
                    case 3:
                        //删除商品
                        productSystem.delete();
                        break;
                    case 4:
                        //修改商品
                        productSystem.update();
                        break;
                    case 5:
                        //查找商品
                        productSystem.select();
                        break;
                        //查找两表
                    case 6:
                        productSystem.selectAllTwo();
                        break;
                    case 7:
                        //退出系统
                        allSystem.exit();
                }
            }
        } else if (index == 2) {
            //操作OfferPrice表
            while (true) {
                //选择增删改查
                allSystem.menu();
                //输入选择
                int indextable = allSystem.Choosemenu();

                switch (indextable) {
                    case 1:
                        //查看所有商品
                        offerPriceSystem.selectAll();
                        break;
                    case 2:
                        //添加商品
                        offerPriceSystem.insert();
                        break;
                    case 3:
                        //删除商品
                        offerPriceSystem.delete();
                        break;
                    case 4:
                        //修改商品
                        offerPriceSystem.update();
                        break;
                    case 5:
                        //查找商品
                        offerPriceSystem.select();
                        break;
                    case 6:
                        //查找俩表
                        offerPriceSystem.selectAllTwo();
                        break;
                    case 7:
                        //退出系统
                        allSystem.exit();
                }
            }
        }
    }
}
