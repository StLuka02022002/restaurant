package com.example.restaurant.service;

import com.example.restaurant.entity.RestaurantTable;

public interface BookingService {

    RestaurantTable booking(Long visitorId, Long restaurantTableId, Integer countSeat);

    RestaurantTable unBooking(Long restaurantTableId);
}
