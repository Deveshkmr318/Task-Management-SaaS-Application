package com.example.multitasker.service;

import com.example.multitasker.exception.TenantNotFoundException;
import com.example.multitasker.model.Tenant;
import com.example.multitasker.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService{

    private final TenantRepository tenantRepo;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepo){
        this.tenantRepo = tenantRepo;
    }

    @Override
    public Tenant createTenant(Tenant tenant) {

        return tenantRepo.save(tenant);

    }

    @Override
    public Optional<Tenant> getTenantById(Long id) throws TenantNotFoundException {

        Optional<Tenant> tenant = tenantRepo.findById(id);

        if(tenant.isPresent()){
            return tenant;
        }

        throw new TenantNotFoundException("Tenant with id " + id + " Not Found !!");

    }

    @Override
    public List<Tenant> getAllTenants() {

        List<Tenant> tenantList = tenantRepo.findAll();

        return tenantList;
    }
}
