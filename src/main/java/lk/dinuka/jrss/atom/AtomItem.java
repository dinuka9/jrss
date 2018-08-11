package lk.dinuka.jrss.atom;

import lk.dinuka.jrss.common.Item;

public class AtomItem implements Item{
    //required
    private String id;
    private String title;
    private String updated;

    //recommended
    private String author;
    private String content;
    private String link;
    private String summary;

    //additional
    private String category;
    private String contributor;
    private String published;
    private String rights;
    private String source;

    public AtomItem() {
    }

    public AtomItem(String id, String title, String updated) {
        this.id = id;
        this.title = title;
        this.updated = updated;
    }

    public AtomItem(String id, String title, String updated, String content, String link) {
        this.id = id;
        this.title = title;
        this.updated = updated;
        this.content = content;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String getType() {
        return "atom";
    }
}
