package com.iweb.test3;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/** 反射核心体现在spring
 * IOC 控制反转
 * DI 依赖注入
 * @author LYH
 * @date 2023/11/25 10:58
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 从配置文件中提取所需要的信息
        File springConfigFile = new File("D:\\Idea_workspace\\d1115_javad11_372\\d1125_javad16\\" +
                "src\\main\\java\\com\\iweb\\test3\\spring.properties");
        // 不再使用原生IO流读取 使用Java提供的Properties类进行读取
        Properties springConfig = new Properties();
        // 工具类加载配置文件
        springConfig.load(new FileInputStream(springConfigFile));
        // 工具类会自动提取所有配置文件信息 并且封装成Map
        // 我们只需要通过get方式获取配置文件信息
        String className = (String)springConfig.get("className");
        String methodName = (String)springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserServer> c = uClass.getConstructor();
        // 实例化对象完成方法调用
        m.invoke(c.newInstance());
    }
}
