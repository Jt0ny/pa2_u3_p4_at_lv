package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Artista;
import com.example.demo.repository.modelo.Cancion;
import com.example.demo.repository.modelo.Hotel;

public interface ArtistaRepository {
	
	public void insertar (Artista artista);
	
	public List<Artista> seleccionarArtistasInnerJoin();
	public List<Cancion> seleccionarCancionesInnerJoin();
	
	public List<Artista> seleccionarArtistasOuterRigthJoin();
	public List<Cancion> seleccionarCancionesOuterRigthJoin();
	
	public List<Artista> seleccionarArtistasOuterLeftJoin();
	public List<Cancion> seleccionarCancionesOuterLeftJoin();
	
	public List<Artista> seleccionarArtistasOuterFulltJoin();
	public List<Cancion> seleccionarCancionesOuterFulltJoin();
	
	public List<Artista> seleccionarArtistasWhereJoin();
	public List<Cancion> seleccionarCancionesWhereJoin();
	


}
