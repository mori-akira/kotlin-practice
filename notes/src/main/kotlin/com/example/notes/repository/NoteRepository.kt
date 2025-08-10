package com.example.notes.repository

import com.example.notes.domain.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long>
