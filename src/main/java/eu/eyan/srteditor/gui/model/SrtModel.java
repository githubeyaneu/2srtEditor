package eu.eyan.srteditor.gui.model;

import java.util.List;


import com.jgoodies.binding.list.SelectionInList;

import eu.eyan.srteditor.data.Subtitle;

public class SrtModel {
	private SelectionInList<Subtitle> list;

	public SrtModel(List<Subtitle> subs) {
		list = new SelectionInList<Subtitle>(subs);
	}

	public SelectionInList<Subtitle> getList() {
		return list;
	}

}
