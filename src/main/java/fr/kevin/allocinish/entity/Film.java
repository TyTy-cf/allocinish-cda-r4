package fr.kevin.allocinish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime releasedAt;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String poster;

    @Column(nullable = false)
    private String bo;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Director director;

    public String getDurationHM() {
        return "";
    }

}