package lk.dinuka.jrss.rss;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static lk.dinuka.jrss.common.Util.normalizeDoc;
import static lk.dinuka.jrss.common.Util.purify;
import static lk.dinuka.jrss.common.Util.validateElementTag;

/**
 * Created by deuke on 6/10/17.
 */
public class RSSStripper {

    public RSSHeader getRSSHeader(String url) {
        Node node = normalizeDoc(url).getElementsByTagName("channel").item(0);
        String title = "", link = "", description = "";
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            if (validateElementTag(eElement, "title")) {
                title = eElement.getElementsByTagName("title").item(0).getTextContent();
                title = purify(title);
            }
            if (validateElementTag(eElement, "link")) {
                link = eElement.getElementsByTagName("link").item(0).getTextContent();
            }
            if (validateElementTag(eElement, "description")) {
                description = eElement.getElementsByTagName("description").item(0).getTextContent();
                description = purify(description);
            }
            if (validateElementTag(eElement, "language")) {
                link = eElement.getElementsByTagName("language").item(0).getTextContent();
            }
            if (validateElementTag(eElement, "webMaster")) {
                link = eElement.getElementsByTagName("webMaster").item(0).getTextContent();
            }
        }
        RSSHeader rssHeader = new RSSHeader(title, link, description, "", "");
        return rssHeader;
    }

    public List<RSSItem> getRSSItemList(String url) {
        List<RSSItem> newsItemList = new ArrayList<>();
        NodeList nList = normalizeDoc(url).getElementsByTagName("item");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String title = "", link = "", description = "", guid = "", catagory = "", pubdate = "";
                if (validateElementTag(eElement, "title")) {
                    title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    title = purify(title);
                }
                if (validateElementTag(eElement, "link")) {
                    link = eElement.getElementsByTagName("link").item(0).getTextContent();
                }
                if (validateElementTag(eElement, "description")) {
                    description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    description = purify(description);
                }
                if (validateElementTag(eElement, "guid")) {
                    guid = eElement.getElementsByTagName("guid").item(0).getTextContent();
                }
                if (validateElementTag(eElement, "category")) {
                    catagory = eElement.getElementsByTagName("category").item(0).getTextContent();
                }
                if (validateElementTag(eElement, "pubDate" )) {
                    pubdate = eElement.getElementsByTagName("pubDate").item(0).getTextContent();
                }
                newsItemList.add(new RSSItem(title, link, description, pubdate));
            }
        }
        return newsItemList;
    }

}
