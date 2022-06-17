package com.dream.model1;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {
    //Collection生成流
    public static void test1() {
        //创建collection集合
        List<String> list = new ArrayList<String>() ;
        list.add("hello");
        list.add("www");
        list.add("pbteach") ;
        list.add("com") ;

        // 调用stream方法生成流对象
        Stream<String> stream = list.stream();

        // 对流进行终结操作
        stream.forEach(System.out::println);
    }

    //Map生成流
    public static void test2() {
        //定义一个map
        Map<String,PbCourse> map = new HashMap<>();

        // 添加课程
        map.put("100",new PbCourse(100L, "攀博课堂-Java面向对象教程", 33));
        map.put("101",new PbCourse(101L, "攀博课堂-Spring全家桶教程", 44));
        map.put("102",new PbCourse(102L, "攀博课堂-SpringCloud微服务教程", 55));
        map.put("103",new PbCourse(103L, "攀博课堂-在线教育分布式项目教程", 66));
        map.put("104",new PbCourse(104L, "攀博课堂-电子商务项目教程", 66));

        map.keySet().stream().forEach(s->map.get(s))

    }

    //数组生成流
    public static void test3() {
        String[] strs = new String[] {"hello","www","pbteach","com"};
        Stream<String> stream = Stream.of(strs);//创建Stream流对象
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //test1();
        test2();
        test3();
    }
}
