package eu.eyan.srteditor.gui;

import javax.swing.JFrame;

import eu.eyan.srteditor.gui.controller.IController;

public class ControllerStarter
{
    public static void inFrame(IController controller)
    {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(controller.getView());
        jFrame.setSize(1000, 600);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
