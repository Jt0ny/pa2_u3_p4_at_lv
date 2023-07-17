package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Artista;
import com.example.demo.repository.modelo.Cancion;

public interface ArtistaService {
	
	public void guardar (Artista artista);

	public List<Artista> buscarArtistasInnerJoin();
	public List<Cancion> buscarCancionesInnerJoin();
	
	public List<Artista> buscarArtistasOuterRigthJoin();
	public List<Cancion> buscarCancionesOuterRigthJoin();
	
	public List<Artista> buscarArtistasOuterLeftJoin();
	public List<Cancion> buscarCancionesOuterLeftJoin();
	
	public List<Artista> buscarArtistasOuterFulltJoin();
	public List<Cancion> buscarCancionesOuterFulltJoin();
	
	public List<Artista> buscarArtistasWhereJoin();
	public List<Cancion> buscarCancionesWhereJoin();
	
	public List<Artista> buscarArtistaFetchJoin();
	public List<Cancion> buscarCancionFetchJoin();

}
