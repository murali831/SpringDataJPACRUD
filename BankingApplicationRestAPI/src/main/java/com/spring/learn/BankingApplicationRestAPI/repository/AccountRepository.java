package com.spring.learn.BankingApplicationRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.learn.BankingApplicationRestAPI.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
