package com.dream.model1;

import com.google.errorprone.annotations.Var;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Demo1Function {
    public static void change(String s, Function<String,Integer> fun){
        Integer in = fun.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        String str = "this is a test";
        change(str,(String s)->s.length());
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            
        }

        boolean flag = true;
        //flag.if
        if (flag) {

        }
        //flag.else
        if (!flag) {

        }
        //fori
        for (int i = 0; i < ; i++) {

        }
        //flag.while
        while (flag) {

        }
        //
        String a = "Hello world!";
        try {
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(i->{
            System.out.println(i);
        });

        for (int i = list.size() - 1; i >= 0; i--) {
            
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
