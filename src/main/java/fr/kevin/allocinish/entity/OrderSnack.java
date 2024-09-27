package fr.kevin.allocinish.entity;

import fr.kevin.allocinish.entity.embedded.OrderSnackId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderSnack {

    @EmbeddedId
    private OrderSnackId id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", updatable = false, insertable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "snack_id", updatable = false, insertable = false)
    private Snack snack;

}