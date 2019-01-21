package com.soumyadeep.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.soumyadeep.microservices.model.Hotel;
import com.soumyadeep.microservices.model.QHotel;
import com.soumyadeep.microservices.repoisitory.HotelRepository;

@RestController
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;

	@RequestMapping(value = "/all")
	public List<Hotel> findAll() {

		return hotelRepository.findAll();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody Hotel hotel) {

		hotelRepository.save(hotel);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody Hotel hotel) {

		hotelRepository.save(hotel);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") String id) {

		hotelRepository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Hotel getById(@PathVariable(name = "id") String id) {

		return hotelRepository.findById(id);
	}

	@GetMapping(value = "/price/{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable(name = "maxPrice") int maxPrice) {

		return hotelRepository.findByPricePerNightLessThan(maxPrice);
	}

	// db.getCollection('Hotels').find({"address.country":"France"})
	// What if we want to filter by city in address, then we cannot use the naming
	// convention but we can do so by @Query annotation
	@GetMapping(value = "/address/{city}")
	public List<Hotel> getByCity(@PathVariable(name = "city") String city) {

		return hotelRepository.findByCity(city);
	}

	@GetMapping(value = "/country/{country}")
	public List<Hotel> getByCountry(@PathVariable(name = "country") String country) {

		QHotel qHotel = new QHotel("hotel");

		BooleanExpression filterByCountry = qHotel.address.country.eq(country);

		List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll(filterByCountry);
		return hotels;
	}

	@GetMapping(value = "/recommended")
	public List<Hotel> getByRecommendation() {

		final int maxPrice = 160;
		final int minRating = 2;
		QHotel qHotel = new QHotel("hotel");
		BooleanExpression filterByPrice = qHotel.pricePerNight.eq(maxPrice);
		BooleanExpression filterByRating = qHotel.reviews.any().rating.eq(minRating);
		List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll(filterByPrice.and(filterByPrice));
		return hotels;
	}
}
