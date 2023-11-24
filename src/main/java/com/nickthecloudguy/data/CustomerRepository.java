package com.nickthecloudguy.data;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmailIgnoreCase(String email);

    //@Query("SELECT c FROM Contact c JOIN FETCH c.company")
    //List<Customer> findAllWithCompany();
}
