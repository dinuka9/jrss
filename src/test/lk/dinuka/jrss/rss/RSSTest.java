package lk.dinuka.jrss.rss;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class RSSTest {

    private static String url;
    private static RSSStripper stripper;

    @BeforeClass
    public static void setup(){
        url = "http://feeds.feedburner.com/TechCrunch/";
        stripper = new RSSStripper();
    }

    @Test
    public void testHeader(){
        RSSHeader header = stripper.getRSSHeader(url);
        System.out.println(header.toString());
    }

    @Test
    public void testItems(){
        List<RSSItem> list = stripper.getRSSItemList(url);
        list.forEach(System.out::println);
    }

}
