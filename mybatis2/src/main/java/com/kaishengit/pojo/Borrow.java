package com.kaishengit.pojo;

import java.io.Serializable;

public class Borrow implements Serializable {
    private static final long serialVersionUID = -6109754036608751495L;
    private  Integer id;
    private  Integer bid;
    private  Integer cid;
    private Book book;
    private Card card;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bid=" + bid +
                ", cid=" + cid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
