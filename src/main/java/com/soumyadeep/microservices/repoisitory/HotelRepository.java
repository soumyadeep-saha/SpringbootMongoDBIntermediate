package com.soumyadeep.microservices.repoisitory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.soumyadeep.microservices.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>, QueryDslPredicateExecutor<Hotel>{
	
	public Hotel findById(String id);
	
	public List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value="{address.city:?0}")
	public List<Hotel> findByCity(String city);
	
}
