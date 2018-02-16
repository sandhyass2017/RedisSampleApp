package com.example.redis.queue;

public interface IMessagePublisher {
	
	void publish(final String message);
}
