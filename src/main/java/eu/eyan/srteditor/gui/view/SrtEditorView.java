package eu.eyan.srteditor.gui.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

public class SrtEditorView implements IView
{
    public JScrollPane srtLeftPanel = new JScrollPane();
    public JScrollPane srtRightPanel = new JScrollPane();
    public JButton savebutton = new JButton("Save");
    public JButton copyTimesFromLeftToRightButton = new JButton("Times ->");
    public JButton copyTimesFromRightToLeftButton = new JButton("Times <-");

    @Override
    public Component getComponent()
    {
        JPanel panel = new JPanel(new FormLayout("pref:grow, pref:grow", "fill:pref, fill:pref:grow, pref"));
        panel.add(upperPanel(), CC.xyw(1, 1, 2));
        panel.add(srtLeftPanel, CC.xy(1, 2));
        panel.add(srtRightPanel, CC.xy(2, 2));
        panel.add(buttonPanel(), CC.xyw(1, 3, 2));
        return panel;
    }

    private JLabel upperPanel()
    {
        return new JLabel("d: Delete, c: Collapse with next.");
    }

    private JPanel buttonPanel()
    {
        JPanel panel = new JPanel();
        panel.add(savebutton);
        panel.add(copyTimesFromLeftToRightButton);
        panel.add(copyTimesFromRightToLeftButton);

        copyTimesFromLeftToRightButton.setToolTipText("Copy all the times from left to right.");
        copyTimesFromRightToLeftButton.setToolTipText("Copy all the times from right to left.");
        return panel;
    }

}
