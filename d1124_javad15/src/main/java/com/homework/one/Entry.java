package com.homework.one;

import lombok.Data;

/**
 * @author LYH
 * @date 2023/11/24 22:27
 */
@Data
public class Entry<K,V>{
    private K key;
    private V value;

    public Entry(K key,V value){
        this.key = key;
        this.value = value;
    }

    public Entry(){}

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Entry)){
            return false;
        }else{
            if(!((Entry)obj).getKey().equals(this.getKey())){
                return false;
            }else{
                if(((Entry)obj).getValue().equals(this.getValue())){
                    return true;
                }
            }
        }
        return false;
    }
}
