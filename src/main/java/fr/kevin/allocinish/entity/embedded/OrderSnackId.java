package fr.kevin.allocinish.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class OrderSnackId implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "snack_id")
    private Long snackId;

}