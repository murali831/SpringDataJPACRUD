package com.spring.learn.BankingApplicationRestAPI.service;

import java.util.List;

import com.spring.learn.BankingApplicationRestAPI.controller.exception.AccountNotHavingMinimumBalanceException;
import com.spring.learn.BankingApplicationRestAPI.dto.AccountDTO;

public interface AccountService {
 public AccountDTO createAccount(AccountDTO accountDto);

public AccountDTO getAccountInfo(long id);

public AccountDTO depositAmount(long id, double depositAmount);

public AccountDTO withdrawAmount(long id, double withdrawAmount) throws AccountNotHavingMinimumBalanceException;

public List<AccountDTO> getAllAccountsInfo();

public void deleteAccount(long id);
}
