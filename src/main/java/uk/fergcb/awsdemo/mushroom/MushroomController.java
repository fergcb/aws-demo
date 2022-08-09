package uk.fergcb.awsdemo.mushroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mushrooms")
public class MushroomController {

    @Autowired
    MushroomRepository mushroomRepository;

    public MushroomController(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    @GetMapping
    public Iterable<Mushroom> getMushrooms() {
        return mushroomRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> createMushroom(@RequestBody Mushroom mushroom) {
        mushroomRepository.save(mushroom);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
