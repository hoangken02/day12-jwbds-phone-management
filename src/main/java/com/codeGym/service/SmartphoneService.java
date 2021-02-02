package com.codeGym.service;

import com.codeGym.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone smartphone);
    Smartphone delete(Integer id);
}
