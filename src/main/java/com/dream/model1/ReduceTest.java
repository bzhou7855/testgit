package com.dream.model1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;


public class ReduceTest {

    public static void main(String[] args) throws Exception{
//        List<Foo> fooList = Lists.newArrayList(
//                new Foo("A","san",1.0,2),
//                new Foo("A","nas",13.0,1),
//                new Foo("B","san",112.0,3),
//                new Foo("C","san",43.0,5),
//                new Foo("B","nas",77.0,7)
//        );
//        List<Bar> barList = Lists.newArrayList();
////        fooList
////                .stream()
////                .collect(Collectors.groupingBy(Foo::getName,Collectors.toList()))
////                .forEach((name,fooListByName)->{
////                    Bar bar = new Bar();
////                    bar = fooListByName
////                            .stream()
////                            .reduce(bar,(u,t)->u.sum(t),(u,t)->u);
////                    System.out.println(bar.toString());
////                    barList.add(bar);
////                });
//

        Stream<String> hello = Stream.of("hello", "world", "java8");
        hello.forEach(s -> System.out.println("==="+s));

        Stream.iterate(10, n -> n+1)
                .limit(5)
                .collect(Collectors.toList())
                .forEach(i -> System.out.println(i));

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        ArrayList<Object> list = DoubleStream.of(1.0, 2.0).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        
        String a = "hello world java8";
        String b = a.codePoints().collect(StringBuffer::new,StringBuffer::appendCodePoint,StringBuffer::append).toString();
        System.out.println(b);

        List<Integer> nlist = Arrays.asList(7, 4, 3, 4, 2, 8, 9);
        long count = nlist.stream().filter(x -> x > 3).count();
        System.out.println(count);

        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = stream(strArr)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());


        System.out.println(strList);


        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 8, 9);
        List<Integer> intListNew = intList.stream().map(x -> x + 10).collect(Collectors.toList());

        System.out.println(intList);
        System.out.println(intListNew);

        List<String> alist = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> alist1 = alist.stream().flatMap(s -> stream(s.split(","))).collect(Collectors.toList());

        System.out.println(alist1);
    }



}
