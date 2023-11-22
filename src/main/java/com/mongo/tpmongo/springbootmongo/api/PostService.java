package com.mongo.tpmongo.springbootmongo.api;
import com.mongo.tpmongo.springbootmongo.dto.AuthorPostCount;
import com.mongo.tpmongo.springbootmongo.model.Post;

import java.util.List;

public interface PostService {

    Post insertPost(Post post);

    List<Post> findPost(String id);

    List<Post> findLatestPosts();

    List<Post> findPostsByAuthor(String author);

    List<Post> findPostsByText(String text);

    List<AuthorPostCount> countPostsByAuthor();


}
