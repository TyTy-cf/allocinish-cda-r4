package fr.kevin.allocinish.entity;

import fr.kevin.allocinish.entity.embedded.CinemaSnackId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class CinemaSnack {

    @EmbeddedId
    private CinemaSnackId id;

    @Column(nullable = false)
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "cinema_id", insertable = false, updatable = false)
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "snack_id", insertable = false, updatable = false)
    private Snack snack;

}