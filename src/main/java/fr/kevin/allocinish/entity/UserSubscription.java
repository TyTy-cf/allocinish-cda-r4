package fr.kevin.allocinish.entity;

import fr.kevin.allocinish.entity.embedded.UserMembershipId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class UserSubscription {

    @EmbeddedId
    private UserMembershipId id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime finishedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "membership_id", updatable = false, insertable = false)
    private Membership membership;

}