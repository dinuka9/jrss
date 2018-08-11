package lk.dinuka.jrss.rss;

/**
 * Created by deuke on 6/10/17.
 */
public class RSSHeader {
    private String title;
    private String link;
    private String description;
    private String language;
    private String webMaster;

    public RSSHeader(String title, String link, String description, String language, String webMaster) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.webMaster = webMaster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }
}
