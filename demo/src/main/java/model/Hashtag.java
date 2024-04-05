package model;

import java.util.*;
import jakarta.persistence.*;

import repository.PostRepository;

@Entity
public class Hashtag {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
    
    private final PostRepository postRepository;
    
    public Hashtag(PostRepository postRepository) {
    	this.postRepository = postRepository;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hashtag other = (Hashtag) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(nome, other.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
    
    public List<Post> getPosts() {
        return postRepository.findByHashtagNome(this.nome);
    }

}
