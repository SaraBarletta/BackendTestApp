package model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable =false)
	private String corpo;
	
	@Column(nullable = false)
    private String stato;

    @Column(nullable = false)
    private String autore;
    
    @ManyToMany
    private Set<Hashtag> hashtags;
    
  	public Post(String titolo, String corpo) {
		super();
		this.titolo = titolo;
		this.corpo = corpo;
	}

	public Long getId() {
          return id;
      }

      public void setId(Long id) {
          this.id = id;
      }

      public String getTitolo() {
          return titolo;
      }

      public void setTitolo(String title) {
          this.titolo = title;
      }

      public String getCorpo() {
          return corpo;
      }

      public void setCorpo(String corpo) {
          this.corpo = corpo;
      }

      public String getStato() {
          return stato;
      }

      public void setStato(String stato) {
          this.stato = stato;
      }

      public String getAutore() {
          return autore;
      }

      public void setAutore(String autore) {
          this.autore = autore;
      }

      public Set<Hashtag> getHashtags() {
          return hashtags;
      }

      public void setHashtags(Set<Hashtag> hashtags) {
          this.hashtags = hashtags;
      }

      @Override
      public boolean equals(Object obj) {
          if (this == obj) {
              return true;
          }
          if (obj == null || getClass() != obj.getClass()) {
              return false;
          }
          Post other = (Post) obj;
          return Objects.equals(id, other.id) &&
                  Objects.equals(titolo, other.titolo) &&
                  Objects.equals(corpo, other.corpo) &&
                  Objects.equals(stato, other.stato) &&
                  Objects.equals(autore, other.autore);
      }

      @Override
      public int hashCode() {
          return Objects.hash(id, titolo, corpo, stato, autore);
      }

}
