package eu.eyan.srteditor.data;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

public class SubtitleTest
{
    @Test
    public void test_Constructor()
    {
        Subtitle subtitle = new Subtitle(2, "testtime", newArrayList("line1", "line2"));

        assertThat(subtitle.toString()).isEqualTo("2 - testtime - [line1, line2]");
    }

    @Test
    public void testBuilder()
    {
        Subtitle subtitle = new SubtitleBuilder()
                .withIndex(2)
                .withTime("testtime")
                .withLines("line1", "line2")
                .build();

        assertThat(subtitle.toString()).isEqualTo("2 - testtime - [line1, line2]");
    }

}
