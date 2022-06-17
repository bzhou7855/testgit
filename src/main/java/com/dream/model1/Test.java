package com.dream.model1;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static int getMax(Supplier<Integer> function){
        return function.get();
    }

    public static void main(String[] args) {
//        List<Integer> numList = Arrays.asList(1,2,3,4,5);
//        List<Integer> numList1 = Arrays.asList(1,2,3,4,5);
//
//        //List<String> strList = numList.stream().map(it->Integer.toString(it)).collect(Collectors.toList());
//        List<String> strList = Stream.of(numList,numList1).flatMap(numbers->numbers.stream()).map(value->Integer.toString(value)+"a").collect(Collectors.toList());
//
//        System.out.println(strList);
//
//
//        int arr[] = {2,3,44,23,66,123,88,54};
//        int maxNum = getMax(()->{
//           int max = arr[0];
//            for (int i : arr) {
//                if(i>max){
//                    max = i;
//                }
//            }
//            return max;
//        });
//        System.out.println(maxNum);
//
//
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//
//        System.out.println(filtered);

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3,2,5,7,3,6,9);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().sorted()
                .collect(Collectors.toList());
        System.out.println(squaresList);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
//
//        long count2 = strings.stream().filter(string->string.isEmpty()).count();
//
//        System.out.println("===parallerstream:"+count1);
//        System.out.println("===stream:"+count2);

        String news = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(";"));
        System.out.println(news);

        DoubleSummaryStatistics stats = numbers.stream().mapToDouble(x -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> first = stream.filter(i -> i > 5).findFirst();
        System.out.println(first.orElse(1));
        System.out.println(first.orElseGet(()->new Random().nextInt()));

        Function<Integer, String> fun = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };
        System.out.println(fun.apply(5));

        Function<Integer, String> fun2 = (x)-> java.lang.String.valueOf(x*5);
        System.out.println(fun2.apply(100));
        System.out.println(testFunction(5,i->i*2+1));

        System.out.println(testFunction1(2,i->i*2+1,j->j*j));

    }

    static int testFunction(int i , Function<Integer, Integer> function){
        return function.apply(i);
    }

    static int testFunction1(int i , Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        //return function1.compose(function2).apply(i);
        return function1.andThen(function2).apply(i);
    }
}
