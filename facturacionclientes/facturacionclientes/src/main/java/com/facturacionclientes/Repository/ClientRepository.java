package com.facturacionclientes.Repository;

import com.facturacionclientes.Domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
 List<Client> findByPremiumAndCountryOrderByNameAsc(boolean premium, String country);
}
