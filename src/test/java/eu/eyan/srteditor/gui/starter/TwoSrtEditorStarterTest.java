package eu.eyan.srteditor.gui.starter;

import org.fest.swing.finder.WindowFinder;
import org.junit.Test;

import eu.eyan.srteditor.gui.AbstractGuiTest;
import eu.eyan.srteditor.starter.TwoSrtEditor;

import static eu.eyan.srteditor.gui.controller.SrtEditorController.TWO_SRT_EDITOR_TITLE;

public class TwoSrtEditorStarterTest extends AbstractGuiTest
{
    @Test
    public void _2srtEditor_gets_started_and_visible()
    {
        TwoSrtEditor.main(new String[] {});

        WindowFinder
                .findFrame(TWO_SRT_EDITOR_TITLE)
                .using(robot)
                .requireVisible();
    }
}
