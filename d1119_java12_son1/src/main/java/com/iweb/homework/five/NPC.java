package com.iweb.homework.five;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/20 19:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NPC extends Thread{
    private String NPCName;
    private TaskRoom taskRoom;
    public void publishTask(){
        synchronized (taskRoom.getTaskList()){
            if(taskRoom.getSize() == 20){
                try {
                    taskRoom.getTaskList().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                taskRoom.publishTask(NPCName);
                taskRoom.getTaskList().notifyAll();
            }
        }
    }

    @Override
    public void run() {
        while (true){
            publishTask();
        }
    }
}
