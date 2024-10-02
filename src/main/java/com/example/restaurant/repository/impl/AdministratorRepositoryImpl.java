package com.example.restaurant.repository.impl;

import com.example.restaurant.entity.Administrator;
import com.example.restaurant.repository.AdministratorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorRepositoryImpl extends BaseRepositoryImpl<Administrator> implements AdministratorRepository {

    public AdministratorRepositoryImpl() {
        super(Administrator.class);
    }
}
