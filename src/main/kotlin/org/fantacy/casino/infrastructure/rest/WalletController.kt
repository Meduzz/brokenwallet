package org.fantacy.casino.infrastructure.rest

import org.fantacy.casino.application.service.WalletService
import org.fantacy.casino.domain.AccountBalanceDTO
import org.fantacy.casino.domain.AccountBalanceDocument
import org.fantacy.casino.domain.AccountBalanceQuery
import org.fantacy.casino.domain.CreateAccountCommand
import org.fantacy.casino.domain.CreateAccountDocument
import org.fantacy.casino.domain.CreditAccountCommand
import org.fantacy.casino.domain.CreditAccountDocument
import org.fantacy.casino.domain.DebitAccountCommand
import org.fantacy.casino.domain.DebitAccountDocument
import org.fantacy.casino.domain.ListTransactionsDocument
import org.fantacy.casino.domain.ListTransactionsQuery
import org.fantacy.casino.domain.TransactionDTO
import org.fantacy.casino.domain.ValidationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/wallet"], consumes = ["application/json"], produces = ["application/json"])
class WalletController(val walletService: WalletService) {

	@PostMapping(path = ["/create"])
	fun createAccount(@RequestBody command: CreateAccountCommand): CreateAccountDocument {
		if (command.playerUid.isNullOrEmpty()) {
			throw ValidationException("playerUid must not be null or empty")
		}

		return walletService.createAccount(command)
	}

	@PostMapping(path = ["/balance"])
	fun accountBalance(@RequestBody query: AccountBalanceQuery):AccountBalanceDocument {
		if (query.playerUid.isNullOrEmpty()) {
			throw ValidationException("playerUid must not be null or empty")
		}

		return walletService.accountBalance(query)
	}

	@PostMapping(path = ["/credit"])
	fun creditAccount(@RequestBody command: CreditAccountCommand):CreditAccountDocument {
		return walletService.creditAccount(command)
	}

	@PostMapping(path = ["/debit"])
	fun debitAccount(@RequestBody command: DebitAccountCommand):DebitAccountDocument {
		return walletService.debitAccount(command)
	}

	@PostMapping(path = ["/list"])
	fun listTransactions(@RequestBody query:ListTransactionsQuery):ListTransactionsDocument {
		if (query.playerUid.isNullOrEmpty()) {
			throw ValidationException("playerUid must not be null or empty")
		}

		return walletService.listTransactions(query)
	}
}