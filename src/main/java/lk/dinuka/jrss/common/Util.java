package lk.dinuka.jrss.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static lk.dinuka.jrss.common.HtmlCodes.getHtmlCodes;

public class Util {
    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";
    private static HashMap<String, String> htmlCode = getHtmlCodes();
    private static String HTML_TAGS = "\\<.*?>";

    public static String downloadSource(String url) {
        URL obj;
        StringBuilder sb = new StringBuilder();
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Document normalizeDoc(String url) {
        String html = downloadSource(url);
        StringReader reader = new StringReader(html);
        InputSource inputSource = new InputSource(reader);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            doc = dbFactory.newDocumentBuilder().parse(inputSource);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        return doc;
    }

    public static String purify(String data) {
        String pure = "";
        for (Map.Entry m : htmlCode.entrySet()) {
            pure = data.replaceAll(m.getKey() + "", m.getValue().toString());
        }
        pure = pure.replaceAll(HTML_TAGS, "");
        return pure;
    }

    public static boolean validateElementTag(Element e, String tag) {
        if (!(e.getElementsByTagName(tag).getLength() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public String getFeedType(String url) {
        //TODO: implement to auto identify feed type
        return "";
    }



}
