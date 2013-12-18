package eu.eyan.srteditor.gui;

import org.junit.Test;

import eu.eyan.srteditor.testutils.Abstract2SrtEditorGuiTest;

public class SrtEditorGuiTest extends Abstract2SrtEditorGuiTest
{
    @Test
    public void default_files_showing()
    {
        leftSrtList.requireVisible();
        leftSrtList.requireItemCount(9);

        rightSrtList.requireVisible();
        rightSrtList.requireItemCount(7);
    }
}
