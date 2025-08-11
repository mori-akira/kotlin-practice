package com.example.notes.controller

import com.example.notes.domain.Note
import com.example.notes.service.NoteService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put
import org.springframework.test.web.servlet.delete

@WebMvcTest(NoteController::class)
@AutoConfigureMockMvc(addFilters = false)
class NoteControllerWebTest @Autowired constructor(
    private val mockMvc: MockMvc,
) : FunSpec() {

    @MockkBean
    lateinit var service: NoteService

    override fun extensions() = listOf(SpringExtension)

    init {

        test("GET /api/notes lists notes") {
            every { service.list() } returns listOf(
                Note(title = "t1", content = "c1"),
                Note(title = "t2", content = "c2")
            )

            mockMvc.get("/api/notes")
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].title") { value("t1") }
                    jsonPath("$[1].content") { value("c2") }
                }
        }

        test("GET /api/notes/{id} returns one") {
            every { service.get(1L) } returns Note(title = "t", content = "c")

            mockMvc.get("/api/notes/1")
                .andExpect {
                    status { isOk() }
                    jsonPath("$.title") { value("t") }
                }
        }

        test("POST /api/notes creates note") {
            every { service.create("t", "c") } returns Note(title = "t", content = "c")

            mockMvc.post("/api/notes") {
                contentType = MediaType.APPLICATION_JSON
                content = """{"title":"t","content":"c"}"""
            }.andExpect {
                status { isCreated() }
                jsonPath("$.content") { value("c") }
            }
        }

        test("PUT /api/notes/{id} updates note") {
            every { service.update(1L, "nt", "nc") } returns Note(title = "nt", content = "nc")

            mockMvc.put("/api/notes/1") {
                contentType = MediaType.APPLICATION_JSON
                content = """{"title":"nt","content":"nc"}"""
            }.andExpect {
                status { isOk() }
                jsonPath("$.title") { value("nt") }
            }
        }

        test("DELETE /api/notes/{id} deletes note") {
            every { service.delete(1L) } just runs

            mockMvc.delete("/api/notes/1")
                .andExpect { status { isNoContent() } }
        }
    }
}
