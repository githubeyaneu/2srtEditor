package eu.eyan.srteditor.gui;

import javax.swing.JFrame;

import eu.eyan.srteditor.gui.controller.IController;

public final class ControllerStarter
{

    private ControllerStarter()
    {
    }

    public static void inFrame(final IController controller)
    {
        final JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(controller.getView());
        jFrame.setSize(1000, 600);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
