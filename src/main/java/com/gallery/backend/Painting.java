package com.gallery.backend; // Перевірте, щоб назва пакету збігалася з вашою!

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paintings")
@Data // Ця анотація автоматично створює всі гетери, сетери, toString та equals
@NoArgsConstructor // Автоматично створює порожній конструктор
@AllArgsConstructor // Автоматично створює конструктор з усіма полями
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String description;
    private String imageUrl; // Якщо ви використовували 'image' замість 'imageUrl', змініть тут
}