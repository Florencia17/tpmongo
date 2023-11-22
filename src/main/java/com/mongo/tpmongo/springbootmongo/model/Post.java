package com.mongo.tpmongo.springbootmongo.model;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private String id;
    private String title;
    private String text;
    private List<String> tags;
    private String resume;
    private List<String> relatedLinks;
    private String author;
    private LocalDate date;

}
