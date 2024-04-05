package service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import repository.HashtagRepository;
import repository.PostRepository;
import model.Hashtag;
import model.Post;

@Service
public class PostService {

	private final PostRepository postRepository;
    private final HashtagRepository hashtagRepository;

    @Autowired
    public PostService(PostRepository postRepository, HashtagRepository hashtagRepository) {
        this.postRepository = postRepository;
        this.hashtagRepository = hashtagRepository;
    }
    
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitolo(String titolo) {
        return postRepository.findByTitolo(titolo);
    }
    
    public List<Post> findByHashtagNome(String hashtagNome) {
        List<Hashtag> hashtags = hashtagRepository.findByNome(hashtagNome);
        List<Post> posts = new ArrayList<>();
        for (Hashtag hashtag : hashtags) {
            posts.addAll(hashtag.getPosts());
        }
        return posts;
    }
    
    public Post findById(Long id) {
    	Optional<Post> optionalPost = postRepository.findById(id);
    	return optionalPost.orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }
    
    public Post update(Long id, @RequestBody Post updatePost) {
        Optional<Post> optionalExistingPost = postRepository.findById(id);
        Post existingPost = optionalExistingPost.orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        existingPost.setTitolo(updatePost.getTitolo());
        existingPost.setCorpo(updatePost.getCorpo());
        existingPost.setStato(updatePost.getStato());
        existingPost.setHashtags(updatePost.getHashtags());

        Post savedPost = postRepository.save(existingPost);
        return savedPost;
    }
    
    public Post create(Post post) {
        return postRepository.save(post);
    }

    public void pubblica(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post non trovato."));
        post.setStato("Pubblicato");
        postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }


}
