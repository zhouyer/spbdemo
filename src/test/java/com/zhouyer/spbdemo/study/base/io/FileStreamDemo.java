package com.zhouyer.spbdemo.study.base.io;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

/**
 * @ClassName FileStreamDemo
 * @Description IO 流 示例
 * @Author zhouyer
 * @Date 2020/8/19 23:21
 * @Version 1.0
 **/
@SpringBootTest
public class FileStreamDemo {
    static String source = "D:\\lock.txt";
    static String dis = "D:\\lock_copy.txt";
    @Test
    @Ignore
    public void copy1() {
        try (Reader fileReader = new FileReader(source); Writer fileWriter = new FileWriter(dis);) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }
        } catch (IOException e) {

        }
    }

    @Test
    public void copy2() throws IOException {
        File sFile = new File(source);
        File dFile = new File(dis);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dFile))){
            String str;
            while((str=bufferedReader.readLine())!=null){
                bufferedWriter.write(str);
            }
        }
    }
}
