package eu.eyan.srteditor.data;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class SrtTest
{
    @Test
    public void test()
    {
        Srt srt = new Srt(2, "testtime", newArrayList("line1", "line2"));

        assertThat(srt.toString()).isEqualTo("2 - testtime - [line1, line2]");
    }

}
