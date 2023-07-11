package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		List<Hotel> listaHotel=this.hotelService.buscarInnerJoin();
		for (Hotel h: listaHotel) {
			System.out.println(h);
		}
		
	}

}
