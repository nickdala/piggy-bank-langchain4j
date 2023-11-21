package com.nickthecloudguy.data;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@Query("SELECT c FROM Contact c JOIN FETCH c.company")
    //List<Customer> findAllWithCompany();
}
