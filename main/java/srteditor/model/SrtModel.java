package srteditor.model;

import java.util.List;

import srteditor.Srt;

import com.jgoodies.binding.list.SelectionInList;

public class SrtModel {
	private SelectionInList<Srt> list;

	public SrtModel(List<Srt> subs) {
		list = new SelectionInList<>(subs);
	}

	public SelectionInList<Srt> getList() {
		return list;
	}

}
