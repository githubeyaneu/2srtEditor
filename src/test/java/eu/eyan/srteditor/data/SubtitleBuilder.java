package eu.eyan.srteditor.data;

import static com.google.common.collect.Lists.newArrayList;

public class SubtitleBuilder
{
    private final Subtitle srt;

    public SubtitleBuilder()
    {
        srt = new Subtitle();
    }

    public SubtitleBuilder(final Subtitle srt)
    {
        this();
        this.srt.setIndex(srt.getIndex());
        this.srt.setLines(srt.getLines());
        this.srt.setTime(srt.getTime());
    }

    public SubtitleBuilder withIndex(final int index)
    {
        this.srt.setIndex(index);
        return this;
    }

    public SubtitleBuilder withTime(final String time)
    {
        this.srt.setTime(time);
        return this;
    }

    public SubtitleBuilder withLines(final String... lines)
    {
        this.srt.setLines(newArrayList(lines));
        return this;
    }

    public Subtitle build()
    {
        return srt;
    }
}