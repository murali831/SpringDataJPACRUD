package com.spring.learn.BankingApplicationRestAPI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.BankingApplicationRestAPI.controller.exception.AccountNotHavingMinimumBalanceException;
import com.spring.learn.BankingApplicationRestAPI.dto.AccountDTO;
import com.spring.learn.BankingApplicationRestAPI.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountInfo( @PathVariable long id){
		AccountDTO accountDto = accountService.getAccountInfo(id);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> deposit(@PathVariable long id, @RequestBody Map<String,Double> request){
		double depositAmount  = request.get("Amount"); 
		return new ResponseEntity<>(accountService.depositAmount(id,depositAmount), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable long id, @RequestBody Map<String,Double> request) throws AccountNotHavingMinimumBalanceException{
		double withdrawAmount  = request.get("Amount"); 
		AccountDTO accountDto = accountService.withdrawAmount(id,withdrawAmount);
		return ResponseEntity.ok(accountDto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccountsInfo(){
		List<AccountDTO> accountDto = accountService.getAllAccountsInfo();
		return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
	    accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted succesfully");
	}
}
