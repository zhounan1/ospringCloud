package thread;
/*
 * Copyright © 2016 睿泰集团 版权所有
 */

/**
 * @Autor zhouNan
 * @Date 2019/12/26 16:18
 * @Description Express
 **/
public class Express {

    public final  static String  CITY = "ShangHai";
    private int  km; //里程
    private String site;//快递到达地点

    public Express(){}


    public Express(int km, String  site){
        this.km = km;
        this.site = site;
    }

    //公里数变化
    public synchronized  void changeKm(){
        this.km = 101;
        notifyAll();
    }

    //地点变化、
    public synchronized  void  changeSite(){
        this.site = "BinJin";
        notifyAll();
    }


    public synchronized void  waitKm(){
        while (this.km <= 100){
            try{
                wait();
                System.out.println("线程还在睡眠  thread ="+ Thread.currentThread().getId());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("线程被唤醒" +  Thread.currentThread().getId());
    }


    public synchronized void waitSite(){
        while (CITY.equals(this.site)){
            try{
                wait();
                System.out.println("线程还在睡眠  thread ="+ Thread.currentThread().getId());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("线程被唤醒 执行后面业务逻辑" + Thread.currentThread().getId());
    }
}
