package com.dream.model2;

public class DemoLogger {
    public static void showLog(int level,String message){
        if(level==1){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello ";
        String msg2 = "World ";
        String msg3 = "Java";
        showLog(1,msg1+msg2+msg3);
    }
}
