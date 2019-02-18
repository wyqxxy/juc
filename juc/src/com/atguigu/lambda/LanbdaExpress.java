package com.atguigu.lambda;

interface Foo{
    public  int add(int a, int b);
    public  default int de(int a, int b){
        return  a-b;
    }

    public  static  int mul(int a,int b){
        return a*b;
    }
}

public class LanbdaExpress {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public int add(int a, int b) {
                return 0;
            }
        };

        Foo foo1 = (a,b)->{
            return a+b;
        };
        System.out.println(foo1.add(3,4));
        System.out.println(foo.de(6,1));
        System.out.println(Foo.mul(3,6));
    }
}
