package com.example.redis.repo;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redis.model.Movie;

@Repository
public class RedisRepositoryImpl implements IRedisRepository {
	
	private static final String KEY = "Movie";
	    
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
	    

	@Override
	public Map<Object, Object> findAllMovies() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void add(Movie movie) {
		hashOperations.put(KEY, movie.getId(), movie.getName());		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public Movie findMovie(String id) {
		return (Movie) hashOperations.get(KEY, id);
	}

}
