package eu.eyan.srteditor.testutils;

import static eu.eyan.srteditor.gui.controller.SrtEditorController.SCROLLPANE_NAME_LEFT;
import static eu.eyan.srteditor.gui.controller.SrtEditorController.SCROLLPANE_NAME_RIGHT;
import static org.fest.assertions.Assertions.assertThat;

import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JListFixture;
import org.junit.Before;

import eu.eyan.srteditor.data.Subtitle;
import eu.eyan.srteditor.gui.AbstractGuiTest;
import eu.eyan.srteditor.gui.controller.SrtEditorController;
import eu.eyan.srteditor.gui.view.SrtEditorView;
import eu.eyan.srteditor.gui.view.SrtView;
import eu.eyan.srteditor.starter.SrtEditorStarter;

public class Abstract2SrtEditorGuiTest extends AbstractGuiTest
{
    protected FrameFixture window;
    private final SrtEditorController controller = new SrtEditorController();
    protected JListFixture leftSubtitleList;
    protected JListFixture rightSubtitleList;
    protected JButtonFixture saveButton;
    protected JButtonFixture copyTimesFromLeftToRightButton;
    protected JButtonFixture copyTimesFromRightToLeftButton;

    @Before
    public void setUpWindow()
    {
        SrtEditorStarter.startEditor();

        window = WindowFinder
                .findFrame(controller.getTitle())
                .using(robot);

        leftSubtitleList = getSrtListFixture(SCROLLPANE_NAME_LEFT);
        rightSubtitleList = getSrtListFixture(SCROLLPANE_NAME_RIGHT);
        saveButton = window.button(SrtEditorView.NAME_BUTTON_SAVE);
        copyTimesFromLeftToRightButton = window.button(SrtEditorView.COPY_TIMES_FROM_LEFT_TO_RIGHT_BUTTON);
        copyTimesFromRightToLeftButton = window.button(SrtEditorView.COPY_TIMES_FROM_RIGHT_TO_LEFT_BUTTON);
    }

    protected JListFixture getSrtListFixture(final String scrollpaneName)
    {
        SrtView srtView = (SrtView) window
                .scrollPane(scrollpaneName)
                .target
                        .getViewport()
                        .getComponent(0);
        JListFixture leftSrtList = new JListFixture(robot, srtView);
        return leftSrtList;
    }

    protected void assertTimesFromSubtitlesEquals(final String subtitle1, final String subtitle2)
    {
        System.out.println(subtitle1);
        assertThat(getTimeFromSubtitle(subtitle1)).isEqualTo(getTimeFromSubtitle(subtitle2));

    }

    private String getTimeFromSubtitle(final String subtitle1)
    {
        return subtitle1.split(Subtitle.SEPARATOR)[1];
    }
}
