package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.Diffusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiffusionRepository extends JpaRepository<Diffusion, Long> {

}