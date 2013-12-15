package eu.eyan.srteditor.starter;

import eu.eyan.gui.utils.ControllerStarter;
import eu.eyan.srteditor.gui.controller.SrtEditorController;

public final class TwoSrtEditor
{
    private TwoSrtEditor()
    {
    }

    public static void main(final String[] args)
    {
        ControllerStarter.startControllerInFrame(new SrtEditorController());
    }
}
