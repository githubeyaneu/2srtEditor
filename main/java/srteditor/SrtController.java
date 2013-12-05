package srteditor;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import srteditor.model.SrtModel;
import srteditor.parser.SrtParser;

import com.jgoodies.binding.adapter.Bindings;

public class SrtController {

	private SrtView view;
	private SrtModel model;
	private String path;

	public SrtController(String path) {
		this.path = path;
		List<Srt> subs = SrtParser.parse(path);
		updateListNumbers(subs);
		view = new SrtView();
		model = new SrtModel(subs);
		
        Bindings.bind(view, model.getList());
        
        
		view.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getSource() instanceof SrtView) {
					SrtView view = (SrtView) e.getSource();
					switch (e.getKeyCode()) {
					case KeyEvent.VK_D:
						System.out.println("Delete " + view.getSelectedValue());
						model.getList().getList().remove(view.getSelectedValue());
						updateListNumbers(model.getList().getList());
						model.getList().fireContentsChanged(view.getSelectedIndex(), view.getSelectedIndex());
						break;
					case KeyEvent.VK_C:
						System.out.println("Collapse with next: " + view.getSelectedValue());
						int selectedIndex = view.getSelectedIndex();
						if(model.getList().getSize()-1 > selectedIndex){
							Srt srt = model.getList().getList().get(selectedIndex);
							Srt next = model.getList().getList().get(selectedIndex+1);
							srt.getLines().addAll(next.getLines());
							srt.setTime(srt.getTime().split(" --> ")[0]+" --> "+next.getTime().split(" --> ")[1]);
							model.getList().getList().remove(next);
							updateListNumbers(model.getList().getList());
							model.getList().fireContentsChanged(view.getSelectedIndex(), view.getSelectedIndex()+1);
						}
						
						break;

					default:
						break;
					}
				}
			}

		});
	}

	public Component getView() {
		return view;
	}

	private void updateListNumbers(List<Srt> list) {
		int counter = 1;
		for (Srt srt : list) {
			srt.setIndex(counter++);
		}
	}

	public void save() {
		SrtParser.save(path, model.getList().getList());
	}
}
