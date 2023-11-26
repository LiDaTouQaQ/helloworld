package com.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 使用synchronized
 * @author LYH
 * @date 2023/11/23 21:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class One{
    private int a;
    public synchronized void add(){
        a++;
    }
    public synchronized void sub(){
        a--;
    }
}
