package com.iweb.homework.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/20 14:13
 */
public class Test {
    public static void main(String[] args) {
        Docker d = new Docker();
        List<Action> addList = new ArrayList<Action>();
        List<Action> removeList = new ArrayList<Action>();
        for (int i = 0; i < 30; i++) {
            addList.add(new Action("add"+i,d,20));
            removeList.add(new Action("reomve"+i,d,20));
        }
        for (Action a :addList) {
            a.start();
        }
        for (Action a :removeList) {
            a.start();
        }
    }
}
