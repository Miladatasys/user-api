package com.milacode.user_api.models;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "phones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String citycode;

    @Column(nullable = false)
    private String countrycode;

    @ManyToOne
    @JoinColumn(name = "user_id") // nombre de la columna en la tabla phones
    private User user;
}
