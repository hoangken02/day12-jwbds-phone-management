package com.codeGym.repository;

import com.codeGym.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface SmartphoneRepository extends CrudRepository<Smartphone,Integer> {
}
