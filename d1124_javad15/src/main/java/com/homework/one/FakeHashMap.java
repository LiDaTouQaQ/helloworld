package com.homework.one;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LYH
 * @date 2023/11/24 22:35
 */
public class FakeHashMap<K,V> implements FakeMap<K,V>{
    ArrayList<LinkedList<Entry<K, V>>> arrayList = new ArrayList<>(2000);
    int size = 0;
    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode()%2000;
        LinkedList<Entry<K,V>> listMap = arrayList.get(hashCode);
        if(listMap == null){
            arrayList.set(hashCode, new LinkedList<Entry<K, V>>());
            Entry<K, V> entry = new Entry<>(key, value);
            arrayList.get(hashCode).add(entry);
            size++;
            return value;
        }else{
            for (Entry<K, V> entry : listMap) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    size++;
                    return value;
                }
            }
            Entry<K, V> entry = new Entry<>(key, value);
            listMap.add(entry);
            size++;
            return value;
        }
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        int hashCode = key.hashCode() % 2000;
        // 根据hashCode找到对应的链表
        LinkedList<Entry<K, V>> linkedList = arrayList.get(hashCode);
        if (linkedList == null) {
            return null;
        }
        for (Entry<K, V> entry : linkedList) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
