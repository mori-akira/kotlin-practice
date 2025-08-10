package com.example.notes.controller

import com.example.notes.api.dto.CreateNoteRequest
import com.example.notes.api.dto.UpdateNoteRequest
import com.example.notes.domain.Note
import com.example.notes.service.NoteService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(
    private val service: NoteService
) {
    @GetMapping
    fun list(): List<Note> = service.list()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Note = service.get(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody req: CreateNoteRequest): Note =
        service.create(req.title, req.content)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody req: UpdateNoteRequest
    ): Note = service.update(id, req.title, req.content)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = service.delete(id)
}
