package eu.eyan.srteditor.gui;

import org.fest.swing.core.Robot;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;

public class AbstractGuiTest extends FestSwingTestCaseTemplate
{
    protected Robot robot;

    @Before
    public void setUpTest()
    {
        super.setUpRobot();
        robot = super.robot();
    }

    @After
    public void tearDownTest()
    {
        super.cleanUp();
    }
}
