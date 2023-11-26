package com.homework;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LYH
 * @date 2023/11/23 21:59
 */
@Data
public class Three {
    private volatile AtomicInteger a = new AtomicInteger();
    public Three(){
        this.a.set(0);
    }

    public void add(){
        a.incrementAndGet();
    }
    public void sub(){
        a.decrementAndGet();
    }
}
