package com.normasys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.normasys.entities.Post;

public interface PostRepository extends ElasticsearchCrudRepository<Post, String> {

    Page<Post> findByTagsName(String tagName, Pageable pageable);

}
