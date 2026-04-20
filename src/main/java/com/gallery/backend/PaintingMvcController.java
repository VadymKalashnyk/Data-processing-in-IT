package com.gallery.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class PaintingMvcController {

    @Autowired
    private PaintingRepository repository;

    @GetMapping
    public String listPaintings(Model model) {
        Iterable<Painting> paintings = repository.findAll();
        model.addAttribute("paintings", paintings);
        return "index";
    }

    // --- НОВІ МЕТОДИ ДЛЯ ДОДАВАННЯ КАРТИНИ ---

    // Метод для відображення сторінки з формою
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("painting", new Painting());
        return "painting-form";
    }

    // Метод для збереження даних з форми у базу
    @PostMapping("/save")
    public String savePainting(@ModelAttribute("painting") Painting painting) {
        repository.save(painting);
        return "redirect:/";
    }
    // Метод для видалення картини за її ID
    @GetMapping("/delete/{id}")
    public String deletePainting(@PathVariable("id") Long id) {
        repository.deleteById(id);
        // Після видалення оновлюємо сторінку
        return "redirect:/";
    }
    // Метод для відображення форми редагування
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // Шукаємо картину в базі. Якщо не знайдено - викидаємо помилку (щоб програма не впала)
        Painting painting = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неправильний ID картини: " + id));

        // Передаємо знайдену картину в ту саму форму
        model.addAttribute("painting", painting);
        return "painting-form";
    }
}