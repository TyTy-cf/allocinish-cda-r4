package fr.kevin.allocinish.entity;

import fr.kevin.allocinish.entity.embedded.TicketId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Ticket {

    @EmbeddedId
    private TicketId id;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "diffusion_id", updatable = false, insertable = false)
    private Diffusion diffusion;

    @ManyToOne
    @JoinColumn(name = "order_id", updatable = false, insertable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "seat_id", updatable = false, insertable = false)
    private Seat seat;

}