package fr.kevin.allocinish.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private int status;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Ticket> tickets = new ArrayList<>();

    public float getTotalPrice() {
        return 0.0f;
    }

}