package com.iweb.test5;

import java.util.ArrayList;
import java.util.List;

/** 注解 @Override
 * 注解类--决定了哪些属性
 * 注解对象-- 写好内容的标签值
 * 注解必须结合代码才有实际意义
 * 注解理论上可以出现在类 方法 成员变量等
 * 几乎所有位置
 * 注解本质也是一个类 @interface
 *
 * 三种注解
 * 内置注解 jdk自带的注解
 * @Override
 * @Deprecated  方法在之后的版本中可能被弃用
 * @SupperessWarning  警告抑制 忽略警告信息
 *      deprecation 使用了不赞成的方法的警告
 *      unchecked 执行力未检查的转换时候的警告(集合不使用泛型)
 *      fallthrough switch代码块没有写break的警告
 *      path 类或者源文件路径中有不存在时候的警告
 *      serial 当在可序列化的类上缺少serialVersionUID时候的警告
 *      finally 任何finally子句不能正常完成时的警告
 *      rawtypes 泛型类型未指明
 *      unused 定了引用 但是没有声明
 *      all 以上所有
 * @FunctionalInterface 函数式接口的标记(Runnable)
 *
 * 元注解 用来注解注解的注解
 * 自定义注解 开发者自己定义的注解
 * @author LYH
 * @date 2023/11/25 13:45
 */
public class Test {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList<>();

    }
}
