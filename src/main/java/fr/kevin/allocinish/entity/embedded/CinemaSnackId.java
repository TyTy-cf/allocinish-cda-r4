package fr.kevin.allocinish.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CinemaSnackId implements Serializable {

    @Column(name = "cinema_id")
    private Long cinemaId;

    @Column(name = "snack_id")
    private Long snackId;

}