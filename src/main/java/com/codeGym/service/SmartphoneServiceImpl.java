package com.codeGym.service;

import com.codeGym.model.Smartphone;
import com.codeGym.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone delete(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        if (smartphone != null) {
            smartphoneRepository.delete(smartphone);
        }
        return smartphone;
    }
}
