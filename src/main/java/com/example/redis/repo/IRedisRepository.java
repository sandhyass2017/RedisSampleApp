package com.example.redis.repo;

import java.util.Map;

import com.example.redis.model.Movie;

public interface IRedisRepository {
	
	/**
     * Return all movies
     */
    Map<Object, Object> findAllMovies();

    /**
     * Add key-value pair to Redis.
     */
    void add(Movie movie);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);
    
    /**
     * find a movie
     */
    Movie findMovie(String id);

}
