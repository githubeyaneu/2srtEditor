package eu.eyan.srteditor.gui.controller;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import com.jgoodies.binding.adapter.Bindings;

import eu.eyan.srteditor.data.Subtitle;
import eu.eyan.srteditor.gui.model.SrtModel;
import eu.eyan.srteditor.gui.view.SrtView;
import eu.eyan.srteditor.parser.SrtParser;

public class SrtController
{
    private SrtView view;
    private SrtModel model;
    private String path;

    public SrtController(String path)
    {
        this.path = path;
        List<Subtitle> subs = SrtParser.parse(path);
        updateListNumbers(subs);
        view = new SrtView();
        model = new SrtModel(subs);

        Bindings.bind(view, model.getList());

        view.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getSource() instanceof SrtView)
                {
                    SrtView view = (SrtView) e.getSource();
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_D:
                            System.out.println("Delete " + view.getSelectedValue());
                            model.getList().getList().remove(view.getSelectedValue());
                            updateListNumbers(model.getList().getList());
                            model.getList().fireContentsChanged(view.getSelectedIndex(), view.getSelectedIndex());
                            break;
                        case KeyEvent.VK_C:
                            System.out.println("Collapse with next: " + view.getSelectedValue());
                            int selectedIndex = view.getSelectedIndex();
                            if (model.getList().getSize() - 1 > selectedIndex)
                            {
                                Subtitle srt = model.getList().getList().get(selectedIndex);
                                Subtitle next = model.getList().getList().get(selectedIndex + 1);
                                srt.getLines().addAll(next.getLines());
                                srt.setTime(srt.getTime().split(" --> ")[0] + " --> " + next.getTime().split(" --> ")[1]);
                                model.getList().getList().remove(next);
                                updateListNumbers(model.getList().getList());
                                model.getList().fireContentsChanged(view.getSelectedIndex(), view.getSelectedIndex() + 1);
                            }

                            break;

                        default:
                            break;
                    }
                }
            }

        });
    }

    public Component getView()
    {
        return view;
    }

    private void updateListNumbers(List<Subtitle> list)
    {
        int counter = 1;
        for (Subtitle srt : list)
        {
            srt.setIndex(counter++);
        }
    }

    public void save()
    {
        SrtParser.save(path, model.getList().getList());
    }

    public List<Subtitle> getList()
    {
        return model.getList().getList();
    }

    public void refresh()
    {
        model.getList().fireContentsChanged(0, model.getList().getSize() - 1);
    }
}
