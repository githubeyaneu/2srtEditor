package eu.eyan.srteditor.starter;

import eu.eyan.srteditor.gui.ControllerStarter;
import eu.eyan.srteditor.gui.controller.SrtEditorController;

public final class SrtEditor
{
    private SrtEditor()
    {
    }

    public static void main(final String[] args)
    {
        ControllerStarter.inFrame(new SrtEditorController());
    }
}
