package com.example.restaurant.mapper;

import com.example.restaurant.entity.Administrator;
import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.entity.RestaurantTable;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.web.request.AdministratorRequest;
import com.example.restaurant.web.request.RestaurantTableRequest;
import com.example.restaurant.web.response.AdministratorResponse;
import com.example.restaurant.web.response.RestaurantTableResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {RestaurantService.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdministratorMapper {


    @Mappings({
            @Mapping(source = "restaurantId", target = "restaurant"),
    })
    Administrator toEntity(AdministratorRequest request);

    @Mappings({
            @Mapping(source = "restaurant.id", target = "restaurantId"),
            @Mapping(source = "restaurant.name", target = "restaurantName")
    })
    AdministratorResponse toResponse(Administrator administrator);

    @AfterMapping
    default void mapRestaurantIdToEntity(AdministratorRequest request, @MappingTarget Administrator administrator,
                                         @Context RestaurantService restaurantService) {
        if (request.getRestaurantId() != null) {
            Restaurant restaurant = restaurantService.get(request.getRestaurantId());
            administrator.setRestaurant(restaurant);
        }
    }
}
