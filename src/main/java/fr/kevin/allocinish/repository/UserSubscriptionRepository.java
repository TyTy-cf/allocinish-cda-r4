package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.UserSubscription;
import fr.kevin.allocinish.entity.embedded.UserMembershipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UserMembershipId> {

}