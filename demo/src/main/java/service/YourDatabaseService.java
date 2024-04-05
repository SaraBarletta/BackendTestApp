package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Post;

@Service
public class YourDatabaseService {
	@Autowired
    private EntityManager entityManager;

    @Transactional
    public void insertData(String titolo, String corpo) {
    	entityManager.persist(new Post(titolo, corpo));
    }
}
