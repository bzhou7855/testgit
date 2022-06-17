package com.dream.model1;

import org.junit.Test;
import sun.net.www.ApplicationLaunchException;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterApple {

    public static void main(String[] args) {

    }


    public List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }


    public List<Apple> filterGreenApples(List<Apple> inventory,String color){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }


    public static <T>List<T> filterApples(List<T> inventory, ApplePredicate<T> p){
        List<T> result = new ArrayList<T>();
        for (T e : inventory) {
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }




//    @Test
//    public void testFilter(){
//        List<Apple> apples = Arrays.asList(new Apple("green",80),
//                new Apple("green",180),
//                new Apple("red",120));
//
//        AppleHeavyWeightPredicate heavyWeightPredicate = new AppleHeavyWeightPredicate();
//        AppleGreenColorPredicate appleGreenColorPredicate = new AppleGreenColorPredicate();
//
//        List<Apple> result = filterApples(apples,heavyWeightPredicate);
//        printApple(result);
//
//        result = filterApples(apples,appleGreenColorPredicate);
//        printApple(result);
//    }

    private <T> void printApple(List<T> result) {
        for (T t : result) {
            System.out.println(t);
        }
    }

//    @Test
//    public void testFilter1(){
//        List<Apple> apples = Arrays.asList(new Apple("green",80),
//                new Apple("green",180),
//                new Apple("red",120));
//
//       List result = filterApples(apples, new ApplePredicate() {
//           @Override
//           public boolean test(Apple apple) {
//               return "red".equals(apple.getColor());
//           }
//       });
//        printApple(result);
//    }

    @Test
    public void testFilter2(){
        List<Apple> apples = Arrays.asList(new Apple("green",80),
                new Apple("green",180),
                new Apple("red",120));

//        List result = filterApples(apples, (Apple apple) -> {
//                return "red".equals(apple.getColor());
//        });
//        printApple(result);
//        List<Integer> numbers = Arrays.asList(new Integer[]{12,2,23,55,34});
//        result = filterApples(numbers,(Integer i)-> i%2==0);
//        printApple(result);

//        long count = apples.stream().filter(apple -> apple.getWeight()>100).count();
//
//        System.out.println(count);
//
//        List<String> collected = Stream.of("a","b","hello").map(string->string.toUpperCase()).collect(Collectors.toList());
//
//        printApple(collected);

        List<String> beginningWithNumbers = Stream.of("1a","b","3hello").filter(string-> Character.isDigit(string.charAt(0))).collect(Collectors.toList());
        printApple(beginningWithNumbers);





//        apples.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });

        apples.sort((Apple o1,Apple o2)-> o1.getWeight().compareTo(o2.getWeight()));

        printApple(apples);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread t1 = new Thread(()-> System.out.println("============="));
        t1.start();


    }


}
