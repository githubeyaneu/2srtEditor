package eu.eyan.srteditor.gui;

import java.awt.event.KeyEvent;

import org.junit.Test;

import eu.eyan.srteditor.data.Srt;
import eu.eyan.srteditor.testutils.Abstract2SrtEditorGuiTest;

import static org.fest.assertions.Assertions.assertThat;

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

    @Test
    public void collapse_works()
    {
        Srt srt1 = new Srt.Builder()
                .withIndex(1)
                .withTime("00:00:41,420 --> 00:00:44,410")
                .withLines("Subtitle 1")
                .build();

        Srt srt2 = new Srt.Builder()
                .withIndex(2)
                .withTime("00:00:46,680 --> 00:00:50,640")
                .withLines("Subtitle 2")
                .build();

        leftSrtList.requireItemCount(9);
        assertThat(leftSrtList.item(0).value()).isEqualTo(srt1.toString());
        leftSrtList.selectItem(0).pressKey(KeyEvent.VK_C);
        leftSrtList.requireItemCount(8);

    }
}
