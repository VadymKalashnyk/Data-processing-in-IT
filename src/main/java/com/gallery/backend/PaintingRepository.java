package com.gallery.backend; // Ваша назва пакету

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Ця анотація каже Spring: "Створи автоматично всі CRUD ендпоінти за адресою /api/paintings"
@RepositoryRestResource(path = "paintings")
public interface PaintingRepository extends JpaRepository<Painting, Long> {
}