package com.restfullwebservices.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
private static List<Post> posts = new ArrayList<>();
	
	private static int postCount = 0;
	static {
		posts.add(new Post());
		posts.add(new Post());
		posts.add(new Post());
	}
	
	public List<Post> findAll(){
		return posts;
	}
	
	public Post save(Post post) {
		post.setId(++postCount);
		posts.add(post);
		return post;
	}
	
	public Post findOne(int id) {
		Predicate<? super Post> predicate = post -> post.getId().equals(id);
		return posts.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super Post> predicate = post -> post.getId().equals(id);
		posts.removeIf(predicate);
	}
}
