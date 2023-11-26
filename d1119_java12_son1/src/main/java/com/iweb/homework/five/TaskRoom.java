package com.iweb.homework.five;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/20 19:47
 */
@Data
public class TaskRoom {
    private LinkedList<String> taskList = new LinkedList<String>();
    public void publishTask(String name){
        taskList.add(name);
    }
    public String getTask(){
        return taskList.pollLast();
    }
    public int getSize(){
        return taskList.size();
    }
}
