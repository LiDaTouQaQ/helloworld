package com.iweb.work.answer.one;

/**
 * @author LYH
 * @date 2023/11/19 11:52
 */
public class Test {
    public static void main(String[] args) {
        Hercules dls = new Hercules();
        TeacherMa mbg = new TeacherMa();
        mbg.setMarble(dls);
        dls.setDaemon(true);
        mbg.start();
        dls.start();

    }
}
