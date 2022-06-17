package com.dream.model1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFilter {
    public static void main(String[] args) {
//
        test1();
    }

    public static void test_map_1(){
        List<PbCourse> list = new ArrayList<>() ;
        list.add(new PbCourse(100L, "攀博课堂-Java面向对象教程", 33));
        list.add(new PbCourse(101L, "攀博课堂-Spring全家桶教程", 44));
        list.add(new PbCourse(102L, "攀博课堂-SpringCloud微服务教程", 55));
        list.add(new PbCourse(103L, "攀博课堂-在线教育分布式项目教程", 66));
        list.add(new PbCourse(104L, "攀博课堂-电子商务项目教程", 66));
        
        list.stream().map(pbCourse -> {
            Map<Long,PbCourse> map= new HashMap<Long,PbCourse>();
            map.put(pbCourse.getId(),pbCourse);
            return map;
        }).forEach(longPbCourseMap -> longPbCourseMap.forEach((k, v) -> {
            System.out.println("key:"+k +" value="+v);
        }));
    }

    public static void test_map_2(){
        List<PbCourse> list1 = new ArrayList<>() ;
        list1.add(new PbCourse(100L, "攀博课堂-Java基础语法教程", 0));
        list1.add(new PbCourse(101L, "攀博课堂-Java面向对象教程", 10));
        list1.add(new PbCourse(102L, "攀博课堂-Java面向对象进阶教程", 0));
        list1.add(new PbCourse(103L, "攀博课堂-Java Lambda函数式编程教程", 0));

        List<PbCourse> list2 = new ArrayList<>() ;
        list2.add(new PbCourse(201L, "攀博课堂-Spring全家桶教程", 0));
        list2.add(new PbCourse(202L, "攀博课堂-SpringCloud微服务教程", 0));
        list2.add(new PbCourse(203L, "攀博课堂-在线教育分布式项目教程", 20));
        list2.add(new PbCourse(204L, "攀博课堂-电子商务项目教程", 0));

//        List<List<PbCourse>> list_all = new ArrayList<>();
//        list_all.add(list1);
//        list_all.add(list2);
//
//        Stream<List<PbCourse>> stream = list_all.stream();
//        Stream<Stream<Object>> streamStream = stream.map(s -> s.stream().map(x -> {
//            int price = x.getPrice();
//            if (price > 0) {
//                x.setCourseName("[收费]" + x.getCourseName());
//            } else {
//                x.setCourseName("[免费]" + x.getCourseName());
//            }
//            return x;
//        }));
//        streamStream.forEach(x->x.forEach(System.out::println));

//        Stream<PbCourse> courseStream = Stream.concat(list1.stream(), list2.stream());
//        courseStream.sorted((o1, o2) -> o1.getPrice()-o2.getPrice()).forEach(System.out::println);
//
//        int[] array1 = new int[]{1,2,3,4,5};
//        IntStream intS = Arrays.stream(array1);
//        long count = intS.count();

//        List<PbCourse> list = new ArrayList<>() ;
//        list.add(new PbCourse(100L, "攀博课堂-Java面向对象教程", 33));
//        list.add(new PbCourse(101L, "攀博课堂-Spring全家桶教程", 44));
//        list.add(new PbCourse(102L, "攀博课堂-SpringCloud微服务教程", 55));
//        list.add(new PbCourse(103L, "攀博课堂-在线教育分布式项目教程", 66));
//        list.add(new PbCourse(104L, "攀博课堂-电子商务项目教程", 66));
//
//        Map<Long, PbCourse> map = list.stream().collect(Collectors.toMap((t)->t.getId(),x->x));
//        map.forEach((k,v)->System.out.println("key:"+k+" value:"+v));
//
//        List<PbCourse> list2 = new ArrayList<>();
//        list2.add(new PbCourse(100L, "攀博课堂-Java面向对象教程", 33));
//        list2.add(new PbCourse(101L, "攀博课堂-Spring全家桶教程", 44));
//        list2.add(new PbCourse(105L, "攀博课堂-支付系统教程", 55));
//        list2.add(new PbCourse(106L, "攀博课堂-项目实战教程", 55));55


        Map<Long, PbCourse> collect = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toMap((t) -> t.getId(), x -> x, (v1, v2) -> v1));
        collect.forEach((k,v)->System.out.println("key:"+k+" value:"+v));


    }

    public static void test_collect_groupby_1(){
        List<PbCourse> list = new ArrayList<>() ;
        list.add(new PbCourse(100L, "攀博课堂-Java面向对象教程基础篇", 22,"javase"));
        list.add(new PbCourse(105L, "攀博课堂-Java面向对象教程高级篇", 33,"javase"));
        list.add(new PbCourse(101L, "攀博课堂-Spring全家桶教程", 44,"java框架"));
        list.add(new PbCourse(102L, "攀博课堂-SpringCloud微服务教程", 55,"java框架"));
        list.add(new PbCourse(103L, "攀博课堂-在线教育分布式项目教程", 55,"java项目"));
        list.add(new PbCourse(104L, "攀博课堂-电子商务项目教程", 66,"java项目"));
        //按课程分类分组
        System.out.println("=========按课程分类分组，默认value是List==========");

        Map<String, List<PbCourse>> collect = list.stream().collect(Collectors.groupingBy(x -> x.getCategory()));
        collect.forEach((k,v)-> System.out.println(k+" "+v));

        Map<String, Set<PbCourse>> collect1 = list.stream().collect(Collectors.groupingBy(s -> s.getCategory(), Collectors.toSet()));

        Map<String, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(s -> s.getCategory(), Collectors.mapping(s -> s.getCourseName(), Collectors.toList())));

        Optional<PbCourse> collect3 = list.stream().collect(Collectors.maxBy((o1, o2) -> o1.getPrice() - o2.getPrice()));
        //collect3.ifPresent(pbCourse -> System.out.println(pbCourse));
        PbCourse pbCourse = Optional.ofNullable(collect3).get().orElse(new PbCourse());


    }

    public static void testFlatmap(){
        Map<String,List<String>> map = new HashMap<String,List<String>>(){{
            put("01", Arrays.asList("衣服","手机","电脑"));
            put("02", Arrays.asList("化妆品","瑜伽服","运动鞋"));

        }};
        Stream<Map<String, List<String>>> mapStream = Stream.of(map);
        Stream<List<String>> listStream = mapStream.flatMap(x -> x.values().stream());
        listStream.flatMap(x -> x.stream()).forEach(System.out::println);

    }

    public static void test1(){
        List<Person> personList = new ArrayList<>();
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red",10));
        appleList.add(new Apple("red",10));
        appleList.add(new Apple("red",10));
        Person p1 = new Person("xiaomin",1000);
        p1.setAppleList(appleList);

        List<Apple> appleList1 = new ArrayList<>();
        appleList1.add(new Apple("red",10));

        appleList1.add(new Apple("red",10));
        Person p2 = new Person("xiaomin1",2000);
        p2.setAppleList(appleList1);
        personList.add(p2);

        List<Apple> appleList2 = new ArrayList<>();
        appleList2.add(new Apple("red",10));
        appleList2.add(new Apple("red",10));
        appleList2.add(new Apple("red",10));
        appleList2.add(new Apple("red",10));
        Person p3 = new Person("xiaomin2",2000);
        p3.setAppleList(appleList2);
        personList.add(p3);

        Person p4 = new Person("xiaomin2",2000);
        personList.add(p4);

        Stream<Integer> integerStream = personList.stream().filter(person -> person.getAppleList()!=null).map(s -> s.getAppleList().size());
        //System.out.println(integerStream.max(Integer::compareTo).get());
        //System.out.println(integerStream.min(Integer::compareTo).orElseGet(0));
        //System.out.println(integerStream.reduce(Integer::max).get());

        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        Integer result = numList.stream().reduce(15, (preResult, item) -> preResult - item, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return null;
            }
        });
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> accResult_s = Stream.of(1,2,3,4)
                .reduce(newList,
                        (acc, item) -> {
                            acc.add(item);
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            System.out.println("BiFunction");
                            return acc;
                        }, (acc, item) -> null);
        System.out.println("accResult_s: " + accResult_s);
    }
}
