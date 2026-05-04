package com.gallery.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j // Логер для консолі
@RestController
@RequestMapping("/api/paintings")
@CrossOrigin(origins = "*") // Вирішує проблему CORS
public class PaintingRestController {

    private final PaintingRepository repository;

    public PaintingRestController(PaintingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Painting> getAll() {
        log.info("📥 Фронтенд затребував список усіх картин");
        return repository.findAll(); // Повертає чистий масив []
    }

    @PostMapping
    public Painting create(@RequestBody Painting painting) {
        log.info("➕ Додавання нової картини: {}", painting.getTitle());
        return repository.save(painting);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.warn("❌ Видалення картини з ID: {}", id);
        repository.deleteById(id);
    }
}