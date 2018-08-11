package lk.dinuka.jrss.atom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static lk.dinuka.jrss.common.Util.*;

public class AtomStripper {

    public List<AtomItem> getRSSItemList(String url) {
        List<AtomItem> newsItemList = new ArrayList<AtomItem>();
        NodeList nList = normalizeDoc(url).getElementsByTagName("entry");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String title = "", link = "", content = "", id = "", catagory = "", updated = "";
                if (validateElementTag(eElement, "id")) {
                    id = eElement.getElementsByTagName("id").item(0).getTextContent();
                }
                if (validateElementTag(eElement, "title")) {
                    title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    title = purify(title);
                }
                if (validateElementTag(eElement, "updated")) {
                    updated = eElement.getElementsByTagName("updated").item(0).getTextContent();
                }
                if (validateElementTag(eElement, "content")) {
                    content = eElement.getElementsByTagName("content").item(0).getTextContent();
                    content = purify(content);
                }
                if (validateElementTag(eElement, "link")) {
                    link = eElement.getElementsByTagName("link").item(0).getTextContent();
                }
                newsItemList.add(new AtomItem(id, title, updated, content, link));
            }
        }
        return newsItemList;
    }
}
