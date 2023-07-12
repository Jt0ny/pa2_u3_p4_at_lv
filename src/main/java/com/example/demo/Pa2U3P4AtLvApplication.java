package com.example.demo;

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
		 
		List<Hotel> listaHotel=this.hotelService.buscarInnerJoin();
		for (Hotel h: listaHotel) {
			System.out.println(h.getNombre());
		}
		
		List<Hotel> listaHotel2=this.hotelService.buscarOuterRigthJoin();
		for (Hotel h: listaHotel2) {
			System.out.println(h);
		}
		
		List<Habitacion> habitaciones=this.hotelService.buscarHabitacionOuterLeftJoin();
		for (Habitacion ha: habitaciones) {
			System.out.println(ha);
		}
		
		List<Hotel> listaHotel4=this.hotelService.buscarOuterFulltJoin();
		for (Hotel h: listaHotel4) {
			if(h==null) {
				System.out.println("No existe aun un hotel");
			}else {
				System.out.println(h.getNombre());
			}
		}
		
		List<Hotel> listaHotel5=this.hotelService.buscarWhereJoin();
		for (Hotel h: listaHotel5) {
			System.out.println(h);
		}
	}

}
