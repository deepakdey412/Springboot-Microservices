package com.ddey.accounts.repository;

import com.ddey.accounts.entity.Accounts;
import com.ddey.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
