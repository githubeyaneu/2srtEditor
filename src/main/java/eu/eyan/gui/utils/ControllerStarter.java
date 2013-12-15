package eu.eyan.gui.utils;

import javax.swing.JFrame;

import eu.eyan.gui.controller.IGuiController;

public final class ControllerStarter
{

    private ControllerStarter()
    {
    }

    public static void startControllerInFrame(final IGuiController controller)
    {
        final JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(controller.getView());
        jFrame.setSize(1000, 600);
        jFrame.pack();
        jFrame.setTitle(controller.getTitle());
        jFrame.setName(controller.getTitle());
        jFrame.setVisible(true);
    }
}
