package com.example.notes.service

import com.example.notes.domain.Note
import com.example.notes.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val repo: NoteRepository
) {
    fun list(): List<Note> = repo.findAll()

    fun get(id: Long): Note =
        repo.findById(id).orElseThrow { NoSuchElementException("Note $id not found") }

    fun create(title: String, content: String): Note =
        repo.save(Note(title = title, content = content))

    fun update(id: Long, title: String, content: String): Note {
        val n = get(id)
        n.title = title
        n.content = content
        return repo.save(n)
    }

    fun delete(id: Long) = repo.deleteById(id)
}
