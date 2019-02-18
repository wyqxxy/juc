package com.atguigu.saleticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    //上锁
    Lock lock = new ReentrantLock();
    private int number = 30;

    public  void sale(){
        lock.lock();
        try {
            if (number > 0 ){
                System.out.println(Thread.currentThread().getName()+"线程正在出售第" +number-- + "张票，还剩" +number + "张" );
            }
        }finally {
            lock.unlock();
        }

   }
}

public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                ticket.sale();
            }
        }, "A");
        */
        
        new Thread(()->{for(int i =1;i<40;i++) ticket.sale();},"a").start();
        new Thread(()->{for(int i =1;i<40;i++) ticket.sale();},"b").start();
        new Thread(()->{for(int i =1;i<40;i++) ticket.sale();},"c").start();
    }
    
    


}
