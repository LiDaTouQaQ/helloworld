package com.iweb.test5;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/** 元注解
 * @author LYH
 * @date 2023/11/25 14:03
 */
@Target({METHOD,TYPE}) // 注解可以加在什么地方 注解的使用范围
@Retention(RUNTIME) // 注解存在的时间
@Inherited // 注解可以被继承
@Documented // 可以自动生成JavaDOC文档
// @Repeatable // 1.8新增的元注解 表示同一个位置当前自定义注解可以出现多次
public @interface JDBCConfig {
    String url();
    String username();
    String password();
}











