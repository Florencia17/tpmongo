package com.mongo.tpmongo.springbootmongo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Page {
    private String id;
    private String title;
    private String text;
    private String author;
    private LocalDate date;

    public Page(String title, String text, String author, LocalDate date) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.date = date;
    }
}
