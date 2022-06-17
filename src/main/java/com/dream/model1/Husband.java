package com.dream.model1;

public class Husband {
    public void buyHouse(){
        System.out.println("北京买房");
    }

    public void marry(Richable r){
        r.buy();
    }

    public void soHappy(){
        marry(this::buyHouse);
    }
}
