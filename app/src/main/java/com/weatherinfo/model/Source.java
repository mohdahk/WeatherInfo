
package com.weatherinfo.model;


public class Source {

    private String title;
    private String slug;
    private String url;
    private Integer crawlRate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCrawlRate() {
        return crawlRate;
    }

    public void setCrawlRate(Integer crawlRate) {
        this.crawlRate = crawlRate;
    }

}
