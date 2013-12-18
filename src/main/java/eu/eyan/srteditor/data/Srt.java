package eu.eyan.srteditor.data;

import java.util.List;

import com.google.common.base.Joiner;

import static com.google.common.collect.Lists.newArrayList;

public class Srt
{
    private int index;
    private String time;
    private List<String> lines;

    private Srt()
    {
    }

    public Srt(int index, String time, List<String> lines)
    {
        this.setIndex(index);
        this.setTime(time);
        this.setLines(lines);
    }

    @Override
    public String toString()
    {
        return Joiner.on(" - ").join(getIndex(), getTime(), getLines());
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public List<String> getLines()
    {
        return lines;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public static class Builder
    {
        private Srt srt = new Srt();

        public Builder withIndex(int index)
        {
            this.srt.index = index;
            return this;
        }

        public Builder withTime(String time)
        {
            this.srt.time = time;
            return this;
        }

        public Builder withLines(String... lines)
        {
            this.srt.lines = newArrayList(lines);
            return this;
        }

        public Srt build()
        {
            return srt;
        }
    }
}
