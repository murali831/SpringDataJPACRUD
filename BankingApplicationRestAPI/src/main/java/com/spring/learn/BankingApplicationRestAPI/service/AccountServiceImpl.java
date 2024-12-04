package com.spring.learn.BankingApplicationRestAPI.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.learn.BankingApplicationRestAPI.dto.AccountDTO;
import com.spring.learn.BankingApplicationRestAPI.entity.Account;
import com.spring.learn.BankingApplicationRestAPI.mapper.AccountMapper;
import com.spring.learn.BankingApplicationRestAPI.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public AccountDTO createAccount(AccountDTO accountDto) {
		Account savedAccount = AccountMapper.mapToAccount(accountDto);
		accountRepo.save(savedAccount);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO getAccountInfo(long id) {
	    Account account = accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exists"));
	    AccountDTO accountDTO = AccountMapper.mapToAccountDTO(account);
		return accountDTO;
	}

	@Override
	public AccountDTO depositAmount(long id, double depositAmount) {
		Account account = accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exists"));
		double totalAmount = account.getBalance()+ depositAmount;
		account.setBalance(totalAmount);
		Account savedAccount =  accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO withdrawAmount(long id, double withdrawAmount) {
		Account account = accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exists"));
		if(account.getBalance()<withdrawAmount)
			throw new RuntimeException("Withdraw amount is more than the current balance");
		double totalAmount = account.getBalance() - withdrawAmount;
		account.setBalance(totalAmount);
		Account savedAccount =  accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public List<AccountDTO> getAllAccountsInfo() {
		List<Account> accounts = accountRepo.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account = accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exists"));
		accountRepo.deleteById(id);
	}

}
