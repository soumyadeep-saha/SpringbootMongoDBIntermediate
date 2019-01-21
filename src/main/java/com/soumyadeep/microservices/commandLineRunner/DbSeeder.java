package com.soumyadeep.microservices.commandLineRunner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.soumyadeep.microservices.model.Address;
import com.soumyadeep.microservices.model.Hotel;
import com.soumyadeep.microservices.model.Review;
import com.soumyadeep.microservices.repoisitory.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void run(String... Strings) throws Exception {


		Hotel marriot=new Hotel(
				"1",
				"Marriot",
				140,
				new Address("Paris","France"), 
				Arrays.asList(
						new Review("a1",8,true),
						new Review("a2",6,false)
						)
				);
		
		Hotel ibis = new Hotel(
				"2",
				"Ibis",
				150,
				new Address("Bucharest","Romania"),
				Arrays.asList(
						new Review("a3",4,false),
						new Review("a4",10,true)
						)
				);
		
		Hotel sofitel = new Hotel(
				"3",
				"Sofitel",
				160,
				new Address("Florida","USA"),
				Arrays.asList(
						new Review("a5",2,false),
						new Review("a6",12,true)
						)
				);
		
		Hotel demo = new Hotel(
				"4",
				"DemoHotelName",
				170,
				new Address("DemoCity","DemoCountry"),
				Arrays.asList(
						new Review("a7",2,false),
						new Review("a8",14,true)
						)
				);
		
		hotelRepository.deleteAll();
		List<Hotel> list=Arrays.asList(marriot,ibis,sofitel,demo);
		hotelRepository.save(list);
	}
}