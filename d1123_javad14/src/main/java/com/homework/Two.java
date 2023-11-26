package com.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** ReentrantLock方法
 * @author LYH
 * @date 2023/11/23 21:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Two {
    private Lock lock;
    private int a;
    public void add(){
        lock.lock();
        a++;
        lock.unlock();
    }
    public void sub(){
        lock.lock();
        a--;
        lock.unlock();
    }
}
