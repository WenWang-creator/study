package org.ww.study.type;

/**
 * @author Wen
 */
public class Example {
    public static void main(String[] args) {
        //java是强类型语言，类型要区分好

        //八大基本数据类型
        //范围可以在包装类中查看
        //整数
        // 占一个字节
        byte num1 = 127;
        // 占两个字节
        short num2 = 32767;
        // 占四个字节
        int num3 = 111111111;
        // L用于区分 long和int
        // 占八个字节
        long num4 = 1111111111111111111L;
        //小数
        //F用法和L一样
        // 占四个字节
        float num5 = 111111111.11F;
        // 占八个字节
        double num6 = 11111.11;

        //字符，占两个字节
        char c = 'a';

        //布尔值 ，占一个字节
        boolean flag = true;
    }
}

class ExampleExt{
    public static void main(String[] args) {
        // 浮点数 是有限的，离散的，存在舍入误差
        // 精度要求高则不应该使用浮点数来表示
        float f = 0.1F;
        double d = 0.1;
        System.out.println(f == d);
        float f1 = 11111111111111111F;
        double d1 = f1 + 1;
        System.out.println(f1 == d1);
    }
}
