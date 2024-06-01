package com.example.employability.Service;

import com.example.employability.Entity.Offer;
import com.example.employability.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public Optional<Offer> findById(Long id) {
        return offerRepository.findById(id);
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public void deleteById(Long id) {
        offerRepository.deleteById(id);
    }
}
