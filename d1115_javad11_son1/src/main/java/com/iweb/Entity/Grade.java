package com.iweb.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author LYH
 * @date 2023/11/15 18:21
 */
@Data
@NoArgsConstructor
public class Grade {
    private Integer id;
    private String subject;
    private BigDecimal grade;
    private Integer sid;
}
