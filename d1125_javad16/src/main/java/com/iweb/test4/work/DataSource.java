package com.iweb.test4.work;

import lombok.Data;

import java.sql.Connection;

/**
 * @author LYH
 * @date 2023/11/25 11:46
 */
@Data
public class DataSource {
    private Connection conn;

}
