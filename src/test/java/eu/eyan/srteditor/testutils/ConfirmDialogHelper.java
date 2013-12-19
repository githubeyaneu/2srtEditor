package eu.eyan.srteditor.testutils;

import org.fest.swing.core.matcher.JButtonMatcher;
import org.fest.swing.fixture.FrameFixture;

public class ConfirmDialogHelper
{

    private final FrameFixture window;

    public ConfirmDialogHelper(final FrameFixture window)
    {
        this.window = window;
    }

    public void clickYes()
    {
        clickButtonWithText("Yes");
    }

    private void clickButtonWithText(final String text)
    {
        window.dialog().button(JButtonMatcher.withText(text)).click();
    }

    public void clickNo()
    {
        clickButtonWithText("No");
    }

}
