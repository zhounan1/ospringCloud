package thread;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Autor zhouNan
 * @Date 2020/1/2 15:46
 * @Description Test2
 **/
public class Test2 {
    public static  void  main(String[] args) throws InterruptedException{
      /*  RunbleTest rt = new RunbleTest();
        rt.run();
        ConcurrentHashMap<String, String> chmap = new ConcurrentHashMap<>();*/
        int  ab  =  10 ;
        System.out.println(Integer.toBinaryString(ab));
        System.out.println( "" + (345 % 32)+  "or"  + (345&(32-1)));
        System.out.println(10&~11);
        System.out.println( " 5的 二进制 = " +  Integer.toBinaryString(5));
        System.out.println( " 6的 二进制 = " +  Integer.toBinaryString(6));
        System.out.println( " 3的 二进制 = " +  Integer.toBinaryString(3));
        System.out.println(5 ^ 6);

    }
}
