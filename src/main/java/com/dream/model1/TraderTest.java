package com.dream.model1;

import java.security.cert.TrustAnchor;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class TraderTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("raoul","Cambridge");
        Trader mario = new Trader("mario","Milan");
        Trader alan = new Trader("alan","Cambridge");
        Trader brian = new Trader("brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,700),
                new Transaction(mario,2013,750),
                new Transaction(alan,2012,950));

        Integer reduce = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result + element;
                    }
                });
        Integer bigger = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer.MIN_VALUE, (result, item) -> result<item ? item : result);

        Optional<Integer> smaller = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer item) {
                        return result > item ? item : result;
                    }
                });

        smaller.ifPresent(integer -> System.out.println("get value:"+integer));

    }
}
