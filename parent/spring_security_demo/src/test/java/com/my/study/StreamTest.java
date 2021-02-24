package com.my.study;

import org.junit.Test;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tanghuai
 * @date 2021/2/24
 */
public class StreamTest {
    @Test
    public void streamTest() {
        List<String> strings = Arrays.asList("abc", "", "bcd", "def", "acd");

        // sorted 排序
        List<String> sorted = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        // 汉字排序,正序
        List<String> chinese = Arrays.asList("赵丽颖", "啊", "AngelaBaby", "李沁");
        List<String> chineseSorted = chinese.stream().sorted(Collator.getInstance(Locale.CHINA)).collect(Collectors.toList());
        System.out.println(chineseSorted);

        // 汉字排序，倒叙
        List<String> chineseSortedReverse = chinese.stream().sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
        System.out.println(chineseSortedReverse);


        List<User> users = Arrays.asList(new User("张三", 12), new User("AngleBaby", 23), new User("李四", 13),
                new User("张三", 11));
        // 自定义排序规则，先按照用户姓名排序，然后按照年龄排序
        List<User> sortedUser = users.stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Collator collator = Collator.getInstance(Locale.CHINA);
                int count = collator.compare(o1.getUserName(), o2.getUserName());
                return count == 0 ? o1.getAge().compareTo(o2.getAge()) : count;
            }
        }).collect(Collectors.toList());
        ;
    }

    /**
     * 终止符
     */

    @Test
    public void endTest() {
        List<String> strings = Arrays.asList("abc", "", "bcd", "def", "acd");

        // anyMatch 任意一个满足，返回true
        boolean anyMatch = strings.stream().anyMatch(str -> str.contains("bc"));
        System.out.println("anyMatch:" + anyMatch);

        // allMatch 集合中是否都满足
        boolean allMatch = strings.stream().allMatch(str -> str.length() < 8);
        System.out.println("allMatch:" + allMatch);

        // noneMatch 检查是否没有匹配 都不满足条件返回true
        boolean noMatch = strings.stream().noneMatch(s -> s.startsWith("z"));
        System.out.println("noMatch:" + noMatch);

        // findAny 任意返回集合中的元素
        Optional<String> findAny = strings.stream().findAny();
        if (findAny.isPresent()) {
            System.out.println("findAny:" + findAny.get());
        }

        // findFirst 返回第一个元素
        Optional<String> findFirst = strings.stream().findFirst();
        if (findFirst.isPresent()) {
            System.out.println("findFirst:" + findFirst.get());
        }

        // forEach 循环遍历
        // strings.stream().forEach(System.out::print);
        System.out.println("forEach:");
        strings.stream().forEach(s -> System.out.println(s));

        // collect 收集器，将流转换为其他形式
        Set<String> collectSet = strings.stream().collect(Collectors.toSet());

        List<User> users = Arrays.asList(new User("张三", 12), new User("李四", 13),
                new User("张三", 18));
        // 第一个参数是key，第二个参数是value，第三个参数是当key重复时选择老值还是新值
        Map<String, User> collectMap = users.stream().collect(Collectors.toMap(User::getUserName, v -> v, (oldValue, newValue) -> newValue));
        System.out.print("collectMap:" + collectMap);
        System.out.println();


        // reduce 方法一 把流中反复结合起来得到一个元素,其中第一个参数result是返回的最终结果，没有指定result的初始值，默认是""，str是遍历的数组元素,这是reduce一个参数的
        Optional<String> reduceOneParamMethod1 = strings.stream().reduce((result, str) -> {
            return result + str;
        });
        if (reduceOneParamMethod1.isPresent()) {
            System.out.println("reduceOneParamMethod1:" + reduceOneParamMethod1.get());
        }

        // reduce方法二 把流中反复结合起来得到一个元素,其中第一个参数result是返回的最终结果，指定了result的初始值，str是遍历的数组元素,这是reduce二个参数的
        String reduceTwoParamMethod2 = strings.stream().reduce("zhaoliying", (result, str) -> {
            result += str;
            return result;
        });
        System.out.println("reduceTwoParamMethod2:" + reduceTwoParamMethod2);

        // count 获取契合中的数量
        long count = strings.stream().count();
        System.out.println("count:" + count);
    }
}

