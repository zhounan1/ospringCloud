package thread;
/*
 * Copyright © 2016 睿泰集团 版权所有
 */

/**
 * @Autor zhouNan
 * @Date 2019/12/26 16:08
 * @Description Test1
 **/
public class Test1 {
    private  static  Express express  = new Express(0,Express.CITY);

    private static class CheckKm extends Thread{
        public void run(){
            express.waitKm();
        }
    }


    private static class CheckSite implements Runnable{
        public void run(){
            express.waitSite();
        }
    }

    public static  void  main(String[] args) throws InterruptedException{
        for (int i =0; i<3; i++){
            new  CheckKm().start();
        }

        for (int i =0; i<3; i++){
            new CheckSite().run();
        }

        Thread.sleep(1000);
        express.changeSite();

    }


}
