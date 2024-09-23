package com.example.restaurant.entity;

import com.example.restaurant.entity.embeddable.FullName;
import com.example.restaurant.entity.embeddable.Passport;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administrators")
@EqualsAndHashCode(callSuper = false)
public class Administrator extends AbstractEntity{

    @Builder.ObtainVia(method = "getPhoneNumberFrom")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Embedded
    private FullName fullName;

    @Embedded
    private Passport passport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder.Default
    @OneToMany(mappedBy = "administrator")
    private Set<Chef> chefs = new HashSet<>();
}
