package com.zhouyer.spbdemo.study.regex;

import jdk.nashorn.internal.ir.annotations.Ignore;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexExample1
 * @Description 正则表达式
 * @Author zhouyer
 * @Date 2020/4/7 23:31
 * @Version 1.0
 **/
@SpringBootTest
public class RegexExample1 {

    @Test
    @Ignore
    public void test01() {
        String str = "Tno";
        //.匹配任意一个字符
        String regex = "t.o";
        // 返回 false
        boolean ismatch = Pattern.matches(regex, str);
        System.out.println(ismatch);
        //内部原理：
        //1、指定校验格式
        Pattern p = Pattern.compile(regex);
        //2、将当前的规则与需判断字符串进行匹配
        Matcher matcher = p.matcher(str);
        //3、获取匹配结果
        boolean result = matcher.matches();
        System.out.println(result);
    }

    @Test
    @Ignore
    public void test02() {
        String str = "sfsdfsderdsd";
        String regex = "^sf\\w{8,}sd$";
        System.out.println(Pattern.matches(regex, str));// true
    }

    public void test03() {
        Regex regex = new Regex("\b[A-Za-z]+ +\1\b");
        //System.out.println(regex.matcher("red color color color red"));
    }
    @Test
    public void test4() {
        // 定义字符串
        String str = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
        String regex = "\\b\\w{3}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        // 通过find方法就是查找有没有满足条件的子串
        // public boolean find()
//        System.out.println(matcher.find());
        // 如何得到值呢?
        // // public String group()
//        System.out.println(matcher.group());
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

}
