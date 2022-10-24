package org.fantacy.casino.domain

data class CreateAccountCommand(
    val playerUid: String
)

data class CreateAccountDocument(
    val account: Long
)

data class AccountBalanceQuery(
    val playerUid: String
)

data class AccountBalanceDocument(
    val balances: List<AccountBalanceDTO>
)

data class CreditAccountCommand(
    val account: Long,
    val amount: Double,
    val externalUid: String
)

data class CreditAccountDocument(
    val details: AccountBalanceDTO
)

data class DebitAccountCommand(
    val account: Long,
    val amount: Double,
    val externalUid: String
)

data class DebitAccountDocument(
    val details: AccountBalanceDTO
)

data class ListTransactionsQuery(
    val playerUid: String
)

data class ListTransactionsDocument(
    val transactions: List<TransactionDTO>
)

data class AccountBalanceDTO(val account: Long, val balance: Double)

data class TransactionDTO(
    val account: Long,
    val direction: String,
    val externalUid: String,
    val amount: Double
)
