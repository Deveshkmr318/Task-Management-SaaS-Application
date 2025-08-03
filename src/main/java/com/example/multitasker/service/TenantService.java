package com.example.multitasker.service;

import com.example.multitasker.exception.TenantNotFoundException;
import com.example.multitasker.model.Tenant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TenantService {

    Tenant createTenant(Tenant tenant);

    Optional<Tenant> getTenantById(Long id) throws TenantNotFoundException;

    List<Tenant> getAllTenants();

}
