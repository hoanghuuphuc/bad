package com.example.tfttournament.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.ConnectionBuilder;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String fullName;

    @CreationTimestamp
    private LocalDateTime createdAt;


    // COURTS
    @OneToMany(mappedBy = "owner")
    private List<Court> courts;

    // BOOKINGS
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    // MATCH CREATED
    @OneToMany(mappedBy = "createdBy")
    private List<Match> matches;

    // MATCH JOINED
    @OneToMany(mappedBy = "user")
    private List<MatchPlayer> joinedMatches;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Authority> authorities;


}