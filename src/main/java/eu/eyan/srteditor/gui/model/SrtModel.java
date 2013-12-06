package eu.eyan.srteditor.gui.model;

import java.util.List;


import com.jgoodies.binding.list.SelectionInList;

import eu.eyan.srteditor.data.Srt;

public class SrtModel {
	private SelectionInList<Srt> list;

	public SrtModel(List<Srt> subs) {
		list = new SelectionInList<>(subs);
	}

	public SelectionInList<Srt> getList() {
		return list;
	}

}
