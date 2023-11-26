package com.homework.one;

/**
 * @author LYH
 * @date 2023/11/24 22:36
 */
public interface FakeMap<K,V> {
    V put(K key,V value);
    V get(K key);
}
