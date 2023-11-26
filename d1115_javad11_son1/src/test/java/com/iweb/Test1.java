package com.iweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/** 批量测试
 * @author LYH
 * @date 2023/11/15 20:37
 */
@RunWith(Suite.class)
// 将测试类同时进行测试
@Suite.SuiteClasses({JDBCTest.class, JDBCTest1.class})
public class Test1 {
}
