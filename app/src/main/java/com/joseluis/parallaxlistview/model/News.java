package com.joseluis.parallaxlistview.model;

/**
 * Author: José Luis Sánchez
 */
public class News {

    /**
     * id de la noticia
     */
    private int idNews;

    /**
     * titulo de la noticia
     */
    private String title;

    /**
     * descripción de la noticia
     */
    private String desc;

    /**
     * fecha de la noticia
     */
    private String date;

    /**
     * Constructor por defecto
     */
    public News(){
        super();
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdNews() { return idNews; }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }
}
