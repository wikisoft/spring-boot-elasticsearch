package com.normasys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.normasys.entities.Post;
import com.normasys.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
	postRepository.save(post);
	return post;
    }

    public Post findOne(String id) {
	return postRepository.findOne(id);
    }

    public Iterable<Post> findAll() {
	return postRepository.findAll();
    }

    public Page<Post> findByTagsName(String tagName, Pageable pageable) {
	return postRepository.findByTagsName(tagName, pageable);
    }

}
