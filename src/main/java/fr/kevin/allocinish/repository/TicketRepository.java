package fr.kevin.allocinish.repository;

import fr.kevin.allocinish.entity.Ticket;
import fr.kevin.allocinish.entity.embedded.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, TicketId> {

}