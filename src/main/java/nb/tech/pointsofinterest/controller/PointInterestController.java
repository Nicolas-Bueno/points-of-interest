package nb.tech.pointsofinterest.controller;

import org.springframework.web.bind.annotation.RestController;

import nb.tech.pointsofinterest.entity.PointInterest;
import nb.tech.pointsofinterest.repository.PointInterestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PointInterestController {

    @Autowired
    private PointInterestRepository pointInterestRepository;

    @PostMapping("/points-of-interest")
    public ResponseEntity<Void> createPoint(@RequestBody PointInterestDto entity) {
        pointInterestRepository.save(new PointInterest(entity.namePOI(), entity.x(), entity.y()));
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/points-of-interest")
    public ResponseEntity<Page<PointInterest>> ListPoint(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                        @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize) {

        var body = pointInterestRepository.findAll(PageRequest.of(page, pageSize));
        
        return ResponseEntity.ok(body);
    }
    
}
