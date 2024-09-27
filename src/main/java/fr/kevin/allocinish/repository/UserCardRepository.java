package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.UserCard;
import fr.kevin.allocinish.entity.embedded.UserCardId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, UserCardId> {

}