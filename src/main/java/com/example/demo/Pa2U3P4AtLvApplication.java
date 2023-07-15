package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
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
		 
		List<Hotel>listaHotel =this.hotelService.buscarInnerJoin();
		for(Hotel h:listaHotel) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones");
			for(Habitacion ha:h.getHabitaciones()) {
			System.out.println(ha.getNumero());	
			}
		}
		System.out.println("SQL Join Fetch");
		List<Hotel>listaHotelF =this.hotelService.buscarJoinFetch();
		for(Hotel h:listaHotelF) {
			System.out.println(h.getNombre());
			System.out.println("Fetch las siguientes habitaciones");
			for(Habitacion ha:h.getHabitaciones()) {
			System.out.println(ha.getNumero());	
			}
		}
		
		 Hotel ho=new Hotel();
		 ho.setDireccion("sangol");
		 ho.setNombre("Varadero");
		
	     Habitacion ha1=new Habitacion();
	     ha1.setNumero("32");
	     ha1.setValor(new BigDecimal(69));
	     ha1.setHotel(ho);
	     
	     Habitacion ha2=new Habitacion();
	     ha2.setNumero("89");
	     ha2.setValor(new BigDecimal(78));
	     ha2.setHotel(ho);
	     
	     Habitacion ha3=new Habitacion();
	     ha3.setNumero("87");
	     ha3.setValor(new BigDecimal(87));
	     ha3.setHotel(ho);
	     
	     
	     List<Habitacion> listaHabi=new ArrayList<>();
	     listaHabi.add(ha1);
	     listaHabi.add(ha2);
	     listaHabi.add(ha3);
	     
	     ho.setHabitaciones(listaHabi);
	     this.hotelService.guardar(ho);
	     
	     
	
	
	}

}
