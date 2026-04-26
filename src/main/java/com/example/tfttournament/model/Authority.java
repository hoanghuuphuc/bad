package com.example.tfttournament.model;

import jakarta.persistence.*;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "authority", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne  @JoinColumn(name = "role_id")
    private Role role;

}
