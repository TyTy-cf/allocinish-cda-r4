package fr.kevin.allocinish.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class UserCardId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "discount_card_id")
    private Long discountCardId;

    private LocalDateTime validatedAt;

}
