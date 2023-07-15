package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ArtistaRepository;
import com.example.demo.repository.modelo.Artista;
import com.example.demo.repository.modelo.Cancion;

@Service
public class ArtistaServiceImpl implements ArtistaService{

	@Autowired
	private ArtistaRepository artistaRepository;
	
	@Override
	public void guardar(Artista artista) {
		this.artistaRepository.insertar(artista);
		
	}

	@Override
	public List<Artista> buscarArtistasInnerJoin() {
		return this.artistaRepository.seleccionarArtistasInnerJoin();
	}

	@Override
	public List<Cancion> buscarCancionesInnerJoin() {
		
		return this.artistaRepository.seleccionarCancionesInnerJoin();
	}

	@Override
	public List<Artista> buscarArtistasOuterRigthJoin() {
		
		return this.artistaRepository.seleccionarArtistasOuterRigthJoin();
		}

	@Override
	public List<Cancion> buscarCancionesOuterRigthJoin() {
		
		return this.artistaRepository.seleccionarCancionesOuterRigthJoin();
	}

	@Override
	public List<Artista> buscarArtistasOuterLeftJoin() {
		
		return this.artistaRepository.seleccionarArtistasOuterLeftJoin();
	}

	@Override
	public List<Cancion> buscarCancionesOuterLeftJoin() {
		
		return this.artistaRepository.seleccionarCancionesOuterLeftJoin();
	}

	@Override
	public List<Artista> buscarArtistasOuterFulltJoin() {
		
		return this.artistaRepository.seleccionarArtistasOuterFulltJoin();
	}

	@Override
	public List<Cancion> buscarCancionesOuterFulltJoin() {
		
		return this.artistaRepository.seleccionarCancionesOuterFulltJoin();
	}

	@Override
	public List<Artista> buscarArtistasWhereJoin() {
		
		return this.artistaRepository.seleccionarArtistasWhereJoin();
	}

	@Override
	public List<Cancion> buscarCancionesWhereJoin() {
		
		return this.artistaRepository.seleccionarCancionesWhereJoin();
	}

}
