package eu.eyan.srteditor.data;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

public class SrtTest
{
    @Test
    public void test_Constructor()
    {
        Srt srt = new Srt(2, "testtime", newArrayList("line1", "line2"));

        assertThat(srt.toString()).isEqualTo("2 - testtime - [line1, line2]");
    }

    @Test
    public void testBuilder()
    {
        Srt srt = new Srt.Builder()
                .withIndex(2)
                .withTime("testtime")
                .withLines("line1", "line2")
                .build();

        assertThat(srt.toString()).isEqualTo("2 - testtime - [line1, line2]");
    }

}
