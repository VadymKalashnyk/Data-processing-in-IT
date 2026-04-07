package com.gallery.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
@CrossOrigin(origins = "http://localhost:5173")
public class PaintingController {

    @Autowired
    private PaintingRepository repository;

    @GetMapping
    public List<Painting> getAllPaintings() {
        return repository.findAll();
    }

    @PostMapping
    public Painting createPainting(@RequestBody Painting painting) {
        return repository.save(painting);
    }
}