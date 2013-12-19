package eu.eyan.srteditor.gui;

import static org.fest.assertions.Assertions.assertThat;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import eu.eyan.srteditor.data.Subtitle;
import eu.eyan.srteditor.data.SubtitleBuilder;
import eu.eyan.srteditor.testutils.Abstract2SrtEditorGuiTest;
import eu.eyan.srteditor.testutils.ConfirmDialogHelper;

public class SrtEditorGuiTest extends Abstract2SrtEditorGuiTest
{
    private static final Subtitle START_LEFT_SUBTITLE_1 = new SubtitleBuilder()
            .withIndex(1)
            .withTime("00:00:41,420 --> 00:00:44,410")
            .withLines("Subtitle 1")
            .build();

    private static final Subtitle START_LEFT_SUBTITLE_2 = new SubtitleBuilder()
            .withIndex(2)
            .withTime("00:00:46,680 --> 00:00:50,640")
            .withLines("Subtitle 2")
            .build();

    private static final Subtitle START_LEFT_SUBTITLE_3 = new SubtitleBuilder()
            .withIndex(3)
            .withTime("00:00:51,260 --> 00:00:53,030")
            .withLines("Subtitle ", "Newline 3")
            .build();

    @Test
    public void default_files_showing()
    {
        leftSubtitleList.requireVisible();
        leftSubtitleList.requireItemCount(9);
        assertThat(leftSubtitleList.item(0).value()).isEqualTo(START_LEFT_SUBTITLE_1.toString());
        assertThat(leftSubtitleList.item(1).value()).isEqualTo(START_LEFT_SUBTITLE_2.toString());
        assertThat(leftSubtitleList.item(2).value()).isEqualTo(START_LEFT_SUBTITLE_3.toString());

        rightSubtitleList.requireVisible();
        rightSubtitleList.requireItemCount(7);
    }

    @Test
    public void collapse_2_srts()
    {
        Subtitle expectedSubtitle1 = new SubtitleBuilder()
                .withIndex(1)
                .withTime("00:00:41,420 --> 00:00:50,640")
                .withLines("Subtitle 1", "Subtitle 2")
                .build();
        Subtitle expectedSubtitle2 = new SubtitleBuilder(START_LEFT_SUBTITLE_3).withIndex(2).build();

        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_C);

        leftSubtitleList.requireItemCount(8);
        assertThat(leftSubtitleList.item(0).value()).isEqualTo(expectedSubtitle1.toString());
        assertThat(leftSubtitleList.item(1).value()).isEqualTo(expectedSubtitle2.toString());
    }

    @Test
    public void delete_srt()
    {
        Subtitle expectedSubtitle1 = new SubtitleBuilder(START_LEFT_SUBTITLE_2).withIndex(1).build();

        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        leftSubtitleList.requireItemCount(8);
        assertThat(leftSubtitleList.item(0).value()).isEqualTo(expectedSubtitle1.toString());
    }

    @Test
    public void save()
    {
        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        saveButton.click();
        assertThat(new File("_en.srt")).exists();
        assertThat(new File("_en.srt")).hasSameContentAs(new File("src/test/resources/expected_saved_left.srt"));
        assertThat(new File("_hu.srt")).exists();
        assertThat(new File("_hu.srt")).hasSameContentAs(new File("src/test/resources/expected_saved_right.srt"));
    }

    @Test
    public void copy_times_from_left_to_right_different_number_of_lines()
    {
        copyTimesFromLeftToRightButton.click();
        new ConfirmDialogHelper(window).clickYes();
        assertThat(rightSubtitleList.item(0).value()).isEqualTo(leftSubtitleList.item(0).value());
    }

    @Test
    public void copy_times_from_left_to_right_equal_number_of_lines()
    {
        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        copyTimesFromLeftToRightButton.click();
        assertTimesFromSubtitlesEquals(rightSubtitleList.item(0).value(), leftSubtitleList.item(0).value());
    }

    @Test
    public void copy_times_from_right_to_left_different_number_of_lines()
    {
        copyTimesFromRightToLeftButton.click();
        new ConfirmDialogHelper(window).clickYes();
        assertThat(leftSubtitleList.item(0).value()).isEqualTo(rightSubtitleList.item(0).value());
    }

    @Test
    public void cancel_copy_times_from_right_to_left_different_number_of_lines()
    {
        copyTimesFromRightToLeftButton.click();
        new ConfirmDialogHelper(window).clickNo();
        assertThat(leftSubtitleList.item(0).value()).isNotEqualTo(rightSubtitleList.item(0).value());
    }

    @Test
    public void copy_times_from_right_to_left_equal_number_of_lines()
    {
        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        leftSubtitleList.selectItem(0).pressKey(KeyEvent.VK_D);
        copyTimesFromRightToLeftButton.click();
        assertTimesFromSubtitlesEquals(leftSubtitleList.item(0).value(), rightSubtitleList.item(0).value());
    }

    @Test
    public void collapse_srts_does_not_work_on_last_item()
    {
        leftSubtitleList.requireItemCount(9);
        leftSubtitleList.selectItem(8).pressKey(KeyEvent.VK_C);
        leftSubtitleList.requireItemCount(9);
    }
}
