package com.example.notes.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "notes")
data class Note(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false, length = 4000)
    var content: String = "",

    @Column(nullable = false)
    var createdAt: Instant = Instant.now(),

    @Column(nullable = false)
    var updatedAt: Instant = Instant.now()
) {
    @PrePersist
    fun onCreate() {
        val now = Instant.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    fun onUpdate() {
        updatedAt = Instant.now()
    }
}
