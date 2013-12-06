package eu.eyan.srteditor.starter;

import eu.eyan.srteditor.gui.ControllerStarter;
import eu.eyan.srteditor.gui.controller.SrtEditorController;

public class SrtEditor
{
    public static void main(String[] args)
    {
        ControllerStarter.inFrame(new SrtEditorController());
    }
}
