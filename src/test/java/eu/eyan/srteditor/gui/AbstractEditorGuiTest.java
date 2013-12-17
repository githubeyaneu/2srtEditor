package eu.eyan.srteditor.gui;

import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JListFixture;
import org.junit.Before;

import eu.eyan.srteditor.gui.controller.SrtEditorController;
import eu.eyan.srteditor.gui.view.SrtView;
import eu.eyan.srteditor.starter.TwoSrtEditor;

import static eu.eyan.srteditor.gui.controller.SrtEditorController.*;

public class AbstractEditorGuiTest extends AbstractGuiTest
{
    FrameFixture window;
    private final SrtEditorController controller = new SrtEditorController();
    protected JListFixture leftSrtList;
    protected JListFixture rightSrtList;

    @Before
    public void setUpWindow()
    {
        TwoSrtEditor.main(new String[] {});

        window = WindowFinder
                .findFrame(controller.getTitle())
                .using(robot);

        leftSrtList = getSrtListFixture(SCROLLPANE_NAME_LEFT);
        rightSrtList = getSrtListFixture(SCROLLPANE_NAME_RIGHT);
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
}
