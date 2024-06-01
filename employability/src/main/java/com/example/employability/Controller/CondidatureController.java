package com.example.employability.Controller;

import com.example.employability.Entity.Condidature;
import com.example.employability.Service.CondidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condidatures")
public class CondidatureController {
    @Autowired
    private CondidatureService condidatureService;

    @GetMapping
    public List<Condidature> getAllCondidatures() {
        return condidatureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condidature> getCondidatureById(@PathVariable Long id) {
        Optional<Condidature> condidature = condidatureService.findById(id);
        return condidature.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Condidature createCondidature(@RequestBody Condidature condidature) {
        return condidatureService.save(condidature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condidature> updateCondidature(@PathVariable Long id, @RequestBody Condidature condidatureDetails) {
        Optional<Condidature> optionalCondidature = condidatureService.findById(id);
        if (optionalCondidature.isPresent()) {
            Condidature condidature = optionalCondidature.get();
            condidature.setCandidateName(condidatureDetails.getCandidateName());
            condidature.setCandidateCV(condidatureDetails.getCandidateCV());
            condidature.setOffers(condidatureDetails.getOffers());
            return ResponseEntity.ok(condidatureService.save(condidature));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCondidature(@PathVariable Long id) {
        if (condidatureService.findById(id).isPresent()) {
            condidatureService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
