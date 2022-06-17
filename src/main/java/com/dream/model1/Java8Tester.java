package com.dream.model1;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Java8Tester {
    public static void main(String[] args) {
        System.out.println("使用 Java 7：");
        List<String> strings = Arrays.asList("abc","","ddd","  ","dddre","edf");
        System.out.println("列表: " +strings);
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("空字符数量为: " + count);
        count = getCountLength3UsingJava7(strings);
        System.out.println("字符串长度为 3 的数量为: " + count);
        //删除空字符串
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println("筛选后的列表: " + filtered);
        String mergedString = getMergedStringUsingJava7(strings,",");

        System.out.println("使用 Java 8: ");
        System.out.println("列表: " +strings);

        count = strings.stream().filter(x->x.isEmpty()).count();

        String stringsValue = "'"+strings.stream().filter(str->!str.isEmpty()).collect(Collectors.joining("','"))+"'";
        String stringsValue1 = strings.stream().filter(str->!str.isEmpty() && str.trim().length()!=0).reduce("",(a,b)->{
            if(a.isEmpty()){
                return "'"+b+"',";
            }else{
                return a+"'"+b+"',";
            }

        });
        System.out.println(stringsValue1);
        String stringsValue2 = strings.stream().filter(str->!str.isEmpty() && str.trim().length()!=0).
                collect(Collectors.joining("','"));
        System.out.println(stringsValue2);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        Integer min = numbers.stream().reduce(numbers.get(0),(a,b)->a<b?a:b);

        System.out.println("最小值："+min);
        List<Integer> squaresList = numbers.stream().distinct().map(i->i*i).sorted().collect(Collectors.toList());
        System.out.println(squaresList);

        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("="+intSummaryStatistics.getCount());

        String value1 = "null";
        Optional<String> input = Optional.ofNullable(value1);

        String getinput = input.orElse("default value");

        System.out.println(getinput);

    }

    private static String getMergedStringUsingJava7(List<String> strings, String s) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strings) {
            if(!str.isEmpty()){
                sb.append(str).append(s);
            }
        }
        return sb.toString().substring(0,sb.toString().length()-2);
    }

    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
        List<String> newStrings = new ArrayList<>();
        for (String s : strings) {
            if(!s.isEmpty()){
                newStrings.add(s);
            }
        }
        return newStrings;
    }

    private static int getCountLength3UsingJava7(List<String> strings) {
        int count = 0;
        for (String s : strings) {
            if(s.length()==3){
                count++;
            }
        }
        return count;
    }

    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;
        for (String s : strings) {
            if(s.isEmpty()){
                count++;
            }
        }
        return count;
    }
}
