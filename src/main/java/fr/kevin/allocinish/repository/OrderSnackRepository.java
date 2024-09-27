package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.OrderSnack;
import fr.kevin.allocinish.entity.embedded.OrderSnackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSnackRepository extends JpaRepository<OrderSnack, OrderSnackId> {

}