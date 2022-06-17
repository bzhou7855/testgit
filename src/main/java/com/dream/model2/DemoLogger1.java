package com.dream.model2;

//延迟加载
public class DemoLogger1 {
    public static void showLog(int level,MessgeBuilder mb){
        if(level==1){
            System.out.println(mb.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello ";
        String msg2 = "World ";
        String msg3 = "Java";
        showLog(1,()->{
            System.out.println("into 执行！");
            return msg1+msg2+msg3;
        });
    }
}
