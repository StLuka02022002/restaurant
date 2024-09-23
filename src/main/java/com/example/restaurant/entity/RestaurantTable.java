package com.example.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant_tables")
@EqualsAndHashCode(callSuper = false)
public class RestaurantTable extends AbstractEntity {

    @Column(name = "table_number", nullable = false)
    private Integer tableNumber;

    @Builder.Default
    @Column(name = "seat_count", nullable = false)
    private Integer seatCount = 1;

    @Builder.Default
    @Column(name = "reservation_seat")
    private Integer reservationSeat = 0;

    @Builder.Default
    @Column(name = "reservation")
    private Boolean reservation = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

}
