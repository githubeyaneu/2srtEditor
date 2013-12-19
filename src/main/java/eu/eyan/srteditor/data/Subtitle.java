package eu.eyan.srteditor.data;

import java.util.List;

import com.google.common.base.Joiner;

public class Subtitle
{
    public static final String SEPARATOR = " - ";
    private int index;
    private String time;
    private List<String> lines;

    public Subtitle()
    {
    }

    public Subtitle(final int index, final String time, final List<String> lines)
    {
        this.setIndex(index);
        this.setTime(time);
        this.setLines(lines);
    }

    @Override
    public String toString()
    {
        return Joiner.on(SEPARATOR).join(getIndex(), getTime(), getLines());
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(final int index)
    {
        this.index = index;
    }

    public List<String> getLines()
    {
        return lines;
    }

    public void setLines(final List<String> lines)
    {
        this.lines = lines;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(final String time)
    {
        this.time = time;
    }

}
