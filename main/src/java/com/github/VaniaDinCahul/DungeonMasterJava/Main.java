package com.github.VaniaDinCahul.DungeonMasterJava;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        JPanel Panel;
        JFrame Frame;

        Panel = new JPanel();
        Frame = new JFrame();

        Panel.setPreferredSize(new Dimension(600, 400));
        Panel.setFocusable(true);
//        Panel.setVisible(true);

        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.add(Panel);
        Frame.pack();
//        Frame.setLocation(null);
        Frame.setVisible(true);
    }
}