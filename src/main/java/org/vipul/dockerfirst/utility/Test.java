package org.vipul.dockerfirst.utility;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        List<List<String>> lists = List.of(
          List.of("Ram", "Shyam"),
          List.of("Alice", "Bob"),
          List.of("Charlie", "David")
        );

        List<String> res = lists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(res);
    }
}
