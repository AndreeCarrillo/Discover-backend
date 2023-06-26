package com.example.discoverbackend.services;

import com.example.discoverbackend.entities.Opinion;

import java.util.List;

public interface OpinionService {
    public Opinion createOpinion(Opinion opinion);

    public List<Opinion> listOpinionByUser (Long id);

    public List<Opinion> listAll();
}
