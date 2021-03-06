package eu.eyan.srteditor.parser;

import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.io.Files;

import eu.eyan.srteditor.data.Subtitle;

public class SrtParser
{

    public static List<Subtitle> parse(final String path)
    {
        List<Subtitle> ret = newArrayList();
        try
        {
            List<String> lines = Files.readLines(new File(path), Charsets.ISO_8859_1);
            int actualLine = 0;
            while (actualLine < lines.size())
            {
                int srtNumber = Integer.parseInt(lines.get(actualLine++));
                String srtTime = lines.get(actualLine++);
                List<String> srtLines = newArrayList();
                while (actualLine < lines.size() && !Strings.isNullOrEmpty(lines.get(actualLine)))
                {
                    srtLines.add(lines.get(actualLine++));
                }
                actualLine++;

                ret.add(new Subtitle(srtNumber, srtTime, srtLines));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public static void save(final String path, final List<Subtitle> list)
    {
        try
        {
            final File file = new File("_" + path);
            if (file.exists())
            {
                Files.deleteRecursively(file);
            }
            for (final Subtitle srt : list)
            {
                final String separator = "\r\n";
                final String text = new StringBuilder()
                        .append(srt.getIndex())
                        .append(separator)
                        .append(srt.getTime())
                        .append(separator)
                        .append(Joiner.on(separator).join(srt.getLines()))
                        .append(separator)
                        .append(separator)
                        .toString();
                Files.append(text, file, Charsets.ISO_8859_1);
            }
        }
        catch (final IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
