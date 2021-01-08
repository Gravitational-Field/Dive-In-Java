package com.lzj.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {

    private String sn;
    private String name;
    private String author;
    private BigDecimal price;

    public Book(String sn, String name, String author, BigDecimal price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getSn().equals(book.getSn()) &&
                getName().equals(book.getName()) &&
                getAuthor().equals(book.getAuthor()) &&
                getPrice().equals(book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSn(), getName(), getAuthor(), getPrice());
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
