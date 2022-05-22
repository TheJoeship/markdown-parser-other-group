import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.*;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void newFile2Test() throws IOException{
        String markdown = Files.readString(Path.of("new-file-2.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(markdown));
    }

    @Test
    public void newFile5Test() throws IOException{
        String markdown = Files.readString(Path.of("new-file-5.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(markdown));
    }

    /*
    / Test markdown snippet #1
    */
    @Test
    public void testMarkdownParseSnippet1() throws IOException {

        String fileContents = Files.readString(Path.of("test-file-snippet1.md"));
        ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);
        ArrayList<String> expectedSnip1Links = new ArrayList<>();
        expectedSnip1Links.add("`google.com");
        expectedSnip1Links.add("google.com");
        expectedSnip1Links.add("ucsd.edu");
        for (int i = 0; i < 3; ++i) {
            assertEquals(expectedSnip1Links.get(i), parsedLinks.get(i));
        }

    }

    /*
    / Test markdown snippet #2
    */
    @Test
    public void testMarkdownParseSnippet2() throws IOException {

        String fileContents = Files.readString(Path.of("test-file-snippet2.md"));
        ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);
        ArrayList<String> expectedSnip2Links = new ArrayList<>();
        expectedSnip2Links.add("a.com");
        expectedSnip2Links.add("a.com(())");
        expectedSnip2Links.add("example.com");
        for (int i = 0; i < 3; ++i) {
            assertEquals(expectedSnip2Links.get(i), parsedLinks.get(i));
        }

    }

    /*
    / Test markdown snippet #3
    */
    @Test
    public void testMarkdownParseSnippet3() throws IOException {

        String fileContents = Files.readString(Path.of("test-file-snippet3.md"));
        ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);
        ArrayList<String> expectedSnip3Links = new ArrayList<>();
        expectedSnip3Links.add("https://www.twitter.com");
        expectedSnip3Links.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        expectedSnip3Links.add("https://cse.ucsd.edu/");
        for (int i = 0; i < 3; ++i) {
            assertEquals(expectedSnip3Links.get(i), parsedLinks.get(i));
        }

    }

}