package nb.tech.pointsofinterest.controller;

import org.springframework.web.bind.annotation.RestController;

import nb.tech.pointsofinterest.entity.PointInterest;
import nb.tech.pointsofinterest.repository.PointInterestRepository;

import java.util.List;
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

    @GetMapping("/near-me")
    public ResponseEntity<List<PointInterest>> ListPoint(@RequestParam("x")Long x,
                                                        @RequestParam("y")Long y,
                                                        @RequestParam("dmax")Long dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;
        var body = pointInterestRepository.findNearMe(xMin,xMax,yMin,yMax)
                    .stream()
                    .filter(p -> distanceBetweenPoints(x, y, p.getX(), p.getY())<= dmax)
                    .toList();
        
        return ResponseEntity.ok(body);
    }

    private Double distanceBetweenPoints(Long x1, Long y1, Long x2, Long y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2-y1,2));
    }
    
}
