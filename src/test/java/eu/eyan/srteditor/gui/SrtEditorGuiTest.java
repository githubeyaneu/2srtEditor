package eu.eyan.srteditor.gui;

import org.junit.Test;

public class SrtEditorGuiTest extends AbstractEditorGuiTest
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
