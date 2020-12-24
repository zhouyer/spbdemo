package com.zhouyer.spbdemo.study.designprinciple.lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LspDemo
 * @Description 里氏替换原则demo
 * @Author zhouyer
 * @Date 2020/9/22 23:20
 * @Version 1.0
 **/
public class LspDemo {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("10-5=" + a.fun1(10, 5));
        System.out.println("1-5=" + a.fun1(1, 5));
        HashMap<String, String> map = new HashMap<>(16);
        a.func(map);
        a.funMap("1","3");

        System.out.println("---------------------------");
        B b = new B();
        // 这里本意是想计算10-5，使用B的父类A中的fun1,结果被子类重新了，导致错误
        System.out.println("10-5=" + b.fun1(10, 5));
        System.out.println("1-5=" + b.fun1(1, 5));
        System.out.println("(6+9)/2=" + b.fun2(6, 9));
        b.func(map);
        b.funMap("1","3");


//        10-5=5
//        1-5=-4
//        ---------------------------
//        10-5=15
//        1-5=6
//        (6+9)/2=7
    }
}

class A {
    public int fun1(int a, int b) {
        return a - b;
    }

    public void func(HashMap<String, String> map) {
        System.out.println("父类被执行");
    }

    public Map<String, String> funMap(String key, String val) {
        System.out.println("父类被执行");
        Map<String, String> map = new HashMap<>(16);
        map.put(key, val);
        return map;
    }
}

// B类继承A
// 增加一个功能：完成两个数相加的和的一半
class B extends A {
    //这里无意识的重新了A类的方法，违背了里氏替换原则
    public int fun1(int a, int b) {
        return a + b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) / 2;
    }

    public void func(Map<String, String> map) {
        System.out.println("子类被执行");
    }

    public HashMap<String, String> funMap(String key, String val) {
        System.out.println("子类被执行");
        HashMap<String, String> map = new HashMap<>(16);
        map.put(key, val);
        return map;
    }
}
