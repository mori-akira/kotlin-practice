package com.example.notes.api.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateNoteRequest(
    @field:NotBlank @field:Size(max = 255)
    val title: String,
    @field:NotBlank @field:Size(max = 4000)
    val content: String
)

data class UpdateNoteRequest(
    @field:NotBlank @field:Size(max = 255)
    val title: String,
    @field:NotBlank @field:Size(max = 4000)
    val content: String
)
