package com.iweb.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Constructor;

/** 在反射的思想中 万物皆是对象
 * 构造方法 方法 成员变量等都可以当作对象来使用
 * 但是必须通过类对象进行获取
 *
 * 设计思想
 * 配置优于实现 约定优于配置
 * @author LYH
 * @date 2023/11/25 9:15
 */
public class Test {
    // 设计一个方法能够根据配置文件中所记录的信息 创建一个Person接口的子类对象
    // 并且使用对象 调用eat方法 在代码不改变的情况下修改配置文件 达到调用不同的eat方法的目的
    public static Person getInstance() {
        File file = new File("D:/Idea_workspace/d1115_javad11_372/" +
                "d1125_javad16/src/main/java/com/iweb/test1/person.config");
        Person person = null;
        try (FileReader fis = new FileReader(file);) {
            char[] chars = new char[(int) file.length()];
            fis.read(chars);
            String str = new String(chars);
            String s = str.split("=")[1];
            Class c1 = Class.forName(s);
            Constructor<Person> c = c1.getConstructor();
            person = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
    public static void main(String[] args) throws Exception {
        // Class c1 = Class.forName("com.iweb.test1.Student");
        // // 根据类对象获取对应的构造器对象 (获取的是无参构造方法的反射对象)
        // Constructor<Student> c = c1.getConstructor();
        // // 利用无参构造方法完成对象的实例化
        // Student s = c.newInstance();
        // // 查看对象属性
        // System.out.println(s);
        // //
        // // 获取有参构造函数的反射对象
        // Constructor<Student> cc = c1.getConstructor(String.class);
        // // 利用有参构造函数 完成对象的创建
        // Student s1 = cc.newInstance("lyh");
        // System.out.println(s1);

        Person p = getInstance();
        p.eat();
    }
}
