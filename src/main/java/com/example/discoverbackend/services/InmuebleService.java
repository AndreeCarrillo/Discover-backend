package com.example.discoverbackend.services;

import com.example.discoverbackend.entities.Inmueble;

import java.util.List;

public interface InmuebleService {

    public List<Inmueble> listAll();

    public Inmueble listById(Long id);

    public Inmueble save(Inmueble inmueble);

    public void delete(Long id, boolean forced);
}
