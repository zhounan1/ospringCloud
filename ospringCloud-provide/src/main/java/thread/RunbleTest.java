package thread;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

/**
 * @Autor zhouNan
 * @Date 2020/1/2 15:39
 * @Description RunbleTest
 **/
public class RunbleTest  implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while ( i == 0){
            System.out.println(Thread.currentThread().getId());
            i++;
        }
    }
}
