package com.gallery.backend; // Змініть на вашу назву пакету, якщо вона інша!

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings") // Базова адреса для всіх методів цього контролера
public class PaintingRestController {

    @Autowired
    private PaintingRepository repository;

    // 1. Читання (Read): Отримати список усіх картин
    // Відповідає на GET-запит за адресою: http://localhost:8080/api/paintings
    @GetMapping
    public List<Painting> getAllPaintings() {
        return repository.findAll();
    }

    // 2. Створення (Create): Додати нову картину
    // Відповідає на POST-запит (дані передаються у форматі JSON в тілі запиту)
    @PostMapping
    public Painting createPainting(@RequestBody Painting painting) {
        return repository.save(painting);
    }

    // 3. Оновлення (Update): Змінити існуючу картину за її ID
    // Відповідає на PUT-запит за адресою: http://localhost:8080/api/paintings/{id}
    @PutMapping("/{id}")
    public Painting updatePainting(@PathVariable Long id, @RequestBody Painting paintingDetails) {
        Painting painting = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не знайдено картину з ID: " + id));

        // Оновлюємо дані
        painting.setTitle(paintingDetails.getTitle());
        painting.setArtist(paintingDetails.getArtist());
        painting.setDescription(paintingDetails.getDescription());
        painting.setImageUrl(paintingDetails.getImageUrl()); // Змініть на getImage(), якщо у вас 'image'

        return repository.save(painting);
    }

    // 4. Видалення (Delete): Видалити картину за її ID
    // Відповідає на DELETE-запит за адресою: http://localhost:8080/api/paintings/{id}
    @DeleteMapping("/{id}")
    public void deletePainting(@PathVariable Long id) {
        repository.deleteById(id);
    }
}