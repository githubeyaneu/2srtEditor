package eu.eyan.srteditor.gui.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import eu.eyan.gui.controller.IGuiController;
import eu.eyan.srteditor.data.Srt;
import eu.eyan.srteditor.gui.view.SrtEditorView;

public class SrtEditorController implements IGuiController
{
    public static final String TWO_SRT_EDITOR_TITLE = "2strEditor";

    public static final String SCROLLPANE_NAME_LEFT = "panel.left";
    public static final String SCROLLPANE_NAME_RIGHT = "panel.right";

    private final SrtController srtRightController = new SrtController("hu.srt");
    private final SrtController srtLeftController = new SrtController("en.srt");
    private final SrtEditorView view = new SrtEditorView();

    public SrtEditorController()
    {
        view.srtLeftPanel.getViewport().add(srtLeftController.getView());
        view.srtLeftPanel.setName(SCROLLPANE_NAME_LEFT);

        view.srtRightPanel.getViewport().add(srtRightController.getView());
        view.srtRightPanel.setName(SCROLLPANE_NAME_RIGHT);

        addEvents();
    }

    private void addEvents()
    {
        view.savebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                // Here is a findbug to test jenkins:
                Object o = null;
                if (1 == System.currentTimeMillis())
                {
                    o = new Object();
                }
                System.out.println(o.equals(""));
                // End of findbug

                srtRightController.save();
                srtLeftController.save();
            }
        });

        view.copyTimesFromLeftToRightButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                copyTimes(srtLeftController.getList(), srtRightController.getList());
                srtRightController.refresh();
            }

        });

        view.copyTimesFromRightToLeftButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                copyTimes(srtRightController.getList(), srtLeftController.getList());
                srtLeftController.refresh();
            }
        });
    }

    @Override
    public Component getView()
    {
        return view.getComponent();
    }

    private void copyTimes(final List<Srt> from, final List<Srt> to)
    {
        if (from.size() != to.size())
        {
            if (JOptionPane.showConfirmDialog(null, "Not equal number of srts! Size1: " + from.size() + ", Size2: " + to.size() + "") != JOptionPane.OK_OPTION)
            {
                return;
            }
        }
        for (int i = 0; i < from.size(); i++)
        {
            if (to.size() > i)
            {
                to.get(i).setTime(from.get(i).getTime());
            }
        }
    }

    @Override
    public String getTitle()
    {
        return TWO_SRT_EDITOR_TITLE;
    }
}
