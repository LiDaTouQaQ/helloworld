package com.iweb.homework.one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/20 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action extends Thread {
    private String actionName;
    private Docker docker;
    private int count;

    @Override
    public void run() {
        if(actionName.contains("add")){
            store();
        }else{
            get();
        }
    }

    public synchronized void store(){
        while (count >0){
            try {
                docker.add(actionName);
                count--;
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void get(){
        while (count>0){
            try {
                docker.remove(actionName);
                count--;
                this.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
