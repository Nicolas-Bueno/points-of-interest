package nb.tech.pointsofinterest.controller;

import org.springframework.web.bind.annotation.RestController;

import nb.tech.pointsofinterest.entity.PointInterest;
import nb.tech.pointsofinterest.repository.PointInterestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PointInterestController {

    @Autowired
    private PointInterestRepository pointInterestRepository;

    @PostMapping("/points-of-interest")
    public ResponseEntity<Void> createPoint(@RequestBody PointInterestDto entity) {
        pointInterestRepository.save(new PointInterest(entity.namePOI(), entity.x(), entity.y()));
        
        return ResponseEntity.ok().build();
    }

   
    
}
