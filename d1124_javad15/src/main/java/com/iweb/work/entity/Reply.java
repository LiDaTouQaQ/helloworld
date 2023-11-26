package com.iweb.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/24 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private int id;
    private String receive;
    private String response;
}
