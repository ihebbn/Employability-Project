package com.example.employability.Service;

import com.example.employability.Entity.Condidature;
import com.example.employability.Repository.CondidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondidatureService {

    @Autowired
    private CondidatureRepository condidatureRepository;

    public List<Condidature> findAll() {
        return condidatureRepository.findAll();
    }

    public Optional<Condidature> findById(Long id) {
        return condidatureRepository.findById(id);
    }

    public Condidature save(Condidature condidature) {
        return condidatureRepository.save(condidature);
    }

    public void deleteById(Long id) {
        condidatureRepository.deleteById(id);
    }
}
