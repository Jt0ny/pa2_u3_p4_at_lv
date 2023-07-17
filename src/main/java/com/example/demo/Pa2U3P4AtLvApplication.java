package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.HotelService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication  implements CommandLineRunner{

	@Autowired
	private TransferenciaService transferenciaService;
	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	@Autowired
	private PropietarioService propietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Propietario p1 =new Propietario();
		p1.setNombre("Anthony");
		p1.setApellido("Tipan");
		p1.setCedula("1726");
		this.propietarioService.guardar(p1);
	
		CuentaBancaria c1= new CuentaBancaria();
		c1.setNumero("100");
		c1.setPropietario(p1);
		c1.setSaldo(new BigDecimal(700));
		c1.setTipo("Ahorros");
		this.cuentaBancariaService.guardar(c1);
		//
		Propietario p2 = new Propietario();
		p2.setNombre("Luis");
		p2.setApellido("Valladares");
		p2.setCedula("1412");
		this.propietarioService.guardar(p2);
		
		CuentaBancaria c2= new CuentaBancaria ();
		c2.setNumero("101");
		c2.setPropietario(p2);
		c2.setSaldo(new BigDecimal(800));
		c2.setTipo("Ahorros");
		this.cuentaBancariaService.guardar(c2);
		
		//Transferencia
		this.transferenciaService.realizarTransferencia(c1.getNumero(), c2.getNumero(), new BigDecimal(100));
	
		
		System.out.println("Reporte de transferencias");
		List<Transferencia>reporte= this.transferenciaService.buscarTodos();
		for(Transferencia tran:reporte) {
			System.out.println(tran);
		}
		
		
		
		
	}

}
