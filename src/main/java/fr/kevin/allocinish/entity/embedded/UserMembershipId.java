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
public class UserMembershipId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "membership_id")
    private Long membershipId;

}