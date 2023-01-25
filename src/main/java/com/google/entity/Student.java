package com.google.entity;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    @OneToOne
    private Address address;
    @ManyToOne
    private Group group;
}
