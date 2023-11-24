package com.nickthecloudguy.data;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);

    List<Account> findByCustomerId(Long customerId);

}
