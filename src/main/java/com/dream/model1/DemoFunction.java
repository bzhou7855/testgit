package com.dream.model1;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoFunction {
    public static void main(String[] args) {
        int age = getAgeNum("赵丽颖,20",
                s->s.split(",")[1],
                s->Integer.parseInt(s),
                n->n+=100
        );



        System.out.println(age);


        Map<String, String> map = new HashMap<>();

        map.put("张三","北京");
        map.put("张三1","北京1");
        map.put("张三2","北京2");
        map.put("张三3","北京3");



        map.forEach((k,v)->System.out.println("key："+k+",value:"+v));

        map.entrySet().stream().forEach((entry)-> System.out.println("key："+entry.getKey()+",value:"+entry.getValue()));
        Set<String> key = map.keySet();

        Collection<String> value = map.values();

        Set<Map.Entry<String, String>> entries = map.entrySet();


        String str = "this is a test";
        System.out.println(checkString(str,(s)->s.length()>5));

        System.out.println(checkString1(str,(s)->s.length()>5,(s)->s.startsWith("tht")));

        String[] array = {"迪丽热巴,女","古力娜扎,女","马尔多纳,男","赵丽颖,女"};

        Arrays.stream(array);

        Arrays.stream(array).filter(s -> s.split(",")[1].equals("女")).filter(s -> s.split(",")[0].length() > 3).map((String s)->s.length())
                .forEach((Integer i)->System.out.println(String.valueOf(i)));


        List collects1 = filter(array,(String s)->s.split(",")[0].length()>3,(String s)->s.split(",")[1].equals("女"));
        collects1.stream().forEach(System.out::println);

        List<String> list = Arrays.asList(array);
        String[] strArray = list.stream().toArray(String[]::new);
        for (String s : strArray) {
            System.out.println("=="+s);
        }

        System.out.println("--- For String ---");
        String[] ar = Stream.of("Java", "Angular", "Spring")
                .collect(Collectors.toList())
                .toArray(new String[0]);

        for(String e : ar) {
            System.out.println(e);
        }

        System.out.println("--- For Integer ---");
        Integer[] intArray = Stream.of(15, 20, 30)
                .map(e -> e * 2)
                .collect(Collectors.toList())
                .toArray(new Integer[0]);

        for(Integer i : intArray) {
            System.out.println(i);
        }




    }

    public static int getAgeNum(String str, Function<String,String> one, Function<String, Integer> two, Function<Integer,Integer> three){
        return one.andThen(two).andThen(three).apply(str);
    }

    public static boolean checkString(String str, Predicate<String> pre){
        return pre.test(str);
    }

    public static boolean checkString1(String str, Predicate<String> pre, Predicate<String> sec){
        return pre.negate().test(str);
    }

    public static ArrayList<String> filter(String[] arr,Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if(b){
                list.add(s);
            }
        }
        return list;
    }
}
