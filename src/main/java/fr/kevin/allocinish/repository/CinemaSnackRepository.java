package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.CinemaSnack;
import fr.kevin.allocinish.entity.embedded.CinemaSnackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaSnackRepository extends JpaRepository<CinemaSnack, CinemaSnackId> {

}