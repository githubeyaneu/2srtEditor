package eu.eyan.srteditor.gui.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eu.eyan.srteditor.data.Srt;
import eu.eyan.srteditor.gui.view.SrtEditorView;

public class SrtEditorController implements IController
{
    private SrtController srtRightController = new SrtController("hu.srt");
    private SrtController srtLeftController = new SrtController("en.srt");
    private SrtEditorView view = new SrtEditorView();

    public SrtEditorController()
    {
//        view.srtLeftPanel.add(srtLeftController.getView());
        view.srtLeftPanel.add(new JLabel("xcv"));
        view.srtRightPanel.add(srtRightController.getView());
        addEvents();
    }

    private void addEvents()
    {
        view.savebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                srtRightController.save();
                srtLeftController.save();
            }
        });

        view.copyTimesFromLeftToRightButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                copyTimes(srtLeftController.getList(), srtRightController.getList());
                srtRightController.refresh();
            }

        });

        view.copyTimesFromRightToLeftButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
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

    private void copyTimes(List<Srt> from, List<Srt> to)
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

}
