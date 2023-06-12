package com.example.discoverbackend.services;

import com.example.discoverbackend.entities.Alquiler;

import java.util.List;

public interface AlquilerService {
    public Alquiler createAlquiler(Alquiler alquiler);

    public List<Alquiler> listAlquilerByUser (Long id);

    public Alquiler updateAlquiler(Long id);

}
