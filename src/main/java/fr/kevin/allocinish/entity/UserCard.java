package fr.kevin.allocinish.entity;

import fr.kevin.allocinish.entity.embedded.UserCardId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class UserCard {

    @EmbeddedId
    private UserCardId id;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "discount_card_id", updatable = false, insertable = false)
    private DiscountCard discountCard;

}