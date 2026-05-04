package com.gallery.backend;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Генерує геттери, сеттери, toString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paintings")
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String description;
    private String imageUrl;
}