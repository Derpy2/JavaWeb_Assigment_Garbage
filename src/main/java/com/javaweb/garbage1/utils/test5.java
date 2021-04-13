package com.javaweb.garbage1.utils;


class tt{
    int s;
}
public class test5 {
    static tt superm(tt x, double y){
        x.s = 7;
        y = 6;
        return x;
    }
    public static void main(String args[]){
        tt obj1 = new tt();
        tt obj2 = new tt();
        double d = 9;
        obj2.s = 8;
        obj2 = superm(obj1, d);
        System.out.println(obj1.s);
        System.out.println(obj2.s);
        System.out.println(d);
    }
}
