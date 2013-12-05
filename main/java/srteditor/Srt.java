package srteditor;

import java.util.List;

import com.google.common.base.Joiner;

public class Srt {

	private int index;
	private String time;
	private List<String> lines;

	public Srt(int index, String time, List<String> lines) {
		this.setIndex(index);
		this.setTime(time);
		this.setLines(lines);
	}
	
	@Override
	public String toString() {
		return Joiner.on(" - ").join(getIndex(), getTime(), getLines());
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
