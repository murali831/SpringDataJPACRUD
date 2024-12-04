package com.spring.learn.BankingApplicationRestAPI.mapper;

import com.spring.learn.BankingApplicationRestAPI.dto.AccountDTO;
import com.spring.learn.BankingApplicationRestAPI.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account = new Account(accountDTO.getAccountId(), accountDTO.getAccountNumber(),
				accountDTO.getAccountHolderName(), accountDTO.getBalance());
		return account;
	}

	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO(account.getAccountId(), account.getAccountNumber(),
				account.getAccountHolderName(), account.getBalance());
		return accountDTO;
	}

}
