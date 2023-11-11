package com.rockypatel.diplomazone.Adapter;

public class mModel {

    String id, chapter, pdflink;
    public mModel() {

    }

    public mModel(String id, String chapter, String pdflink, String img, String videolink) {
        this.id = id;
        this.chapter = chapter;
        this.pdflink = pdflink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getPdflink() {
        return pdflink;
    }

    public void setPdflink(String pdflink) {
        this.pdflink = pdflink;
    }
}
