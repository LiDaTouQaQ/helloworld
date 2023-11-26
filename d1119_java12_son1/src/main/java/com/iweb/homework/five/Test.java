package com.iweb.homework.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/20 19:59
 */
public class Test {
    public static void main(String[] args) {
        TaskRoom taskRoom = new TaskRoom();
        for (int i = 0; i < 30; i++) {
            Thread NPC = new NPC("NPC"+i,taskRoom);
            NPC.start();
            Thread player = new Player("Player"+i,taskRoom);
            player.start();
        }
    }
}
