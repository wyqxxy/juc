package com.atguigu.com.atguigu.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotSafeDemo {

    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        for(int i = 1; i <= 30; i++){

        new  Thread(()->{
            map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().replace("-","").substring(0,4));
            System.out.println(map);
        },String.valueOf(i)).start();

        }
    }

    public static void testSet(){
        Set set = new CopyOnWriteArraySet();
        for (int i = 0;i <= 30; i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().replace("-","").substring(0,4));
                System.out.println(set);
            },
                    String.valueOf(i)).start();
        }
    }

    public  static  void testMap(){
        List list = new CopyOnWriteArrayList();
        for(int i = 1; i <= 30; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().replace("-","").substring(0,4));
                System.out.println(list);
            },
                    String.valueOf(i)).start();
        }
    }
}
