package fr.kevin.allocinish.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class TicketId implements Serializable {

    @Column(name = "diffusion_id")
    private Long diffusionId;

    @Column(name = "seat_id")
    private Long seatId;

    @Column(name = "order_id")
    private Long orderId;

}