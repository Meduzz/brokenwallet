package org.fantacy.casino.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.EAGER
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table
data class Account(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long?,
    @Column(name = "player_uid")
    val playerUid: String
)

@Entity
@Table
data class Transaction(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long?,
    @ManyToOne(optional = false, fetch = EAGER)
    @JoinColumn(name = "account_id")
    val account: Account,
    val direction: String,
    @Column(name = "external_uid")
    val externalUid: String,
    val amount: Double,
    val balanceBefore: Double,
    val balanceAfter: Double
)
