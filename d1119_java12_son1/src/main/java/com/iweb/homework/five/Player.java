package com.iweb.homework.five;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/20 19:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Thread{
    private String playerName;
    private TaskRoom taskRoom;
    public void getTask(){
        synchronized (taskRoom.getTaskList()){
            if(taskRoom.getSize()==0){
                try {
                    taskRoom.getTaskList().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(playerName+"接取了任务"+taskRoom.getTask());
                taskRoom.getTaskList().notifyAll();
            }
        }
    }

    @Override
    public void run() {
        while (true){
            getTask();
        }
    }
}
