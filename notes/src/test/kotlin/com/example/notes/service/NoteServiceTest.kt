package com.example.notes.service

import com.example.notes.domain.Note
import com.example.notes.repository.NoteRepository
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.*
import io.kotest.extensions.spring.SpringExtension
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class NoteServiceTest : FunSpec() {

    @MockkBean
    lateinit var repo: NoteRepository
    @Autowired
    lateinit var service: NoteService

    override fun extensions() = listOf(SpringExtension)

    init {
        test("list delegates to repo.findAll (empty)") {
            val notes = emptyList<Note>()
            every { repo.findAll() } returns notes
            service.list() shouldBe notes
            verify { repo.findAll() }
        }

        test("list delegates to repo.findAll (not empty)") {
            val notes = listOf(
                Note(title = "t1", content = "c1"),
                Note(title = "t2", content = "c2"),
                Note(title = "t3", content = "c3"),
            )
            every { repo.findAll() } returns notes
            service.list() shouldBe notes
            verify { repo.findAll() }
        }

        test("get returns entity when present") {
            val n = Note(title = "t", content = "c")
            every { repo.findById(1L) } returns Optional.of(n)
            service.get(1L) shouldBe n
            verify { repo.findById(1L) }
        }

        test("get throws when missing") {
            every { repo.findById(99L) } returns Optional.empty()
            shouldThrow<NoSuchElementException> {
                service.get(99L)
            }
        }

        test("create saves new entity") {
            val saved = Note(title = "t", content = "c")
            every { repo.save(any<Note>()) } returns saved
            val result = service.create("t", "c")
            result shouldBe saved
            verify { repo.save(match { it.title == "t" && it.content == "c" }) }
        }

        test("update finds and saves") {
            val existing = Note(title = "old", content = "oldc")
            every { repo.findById(1L) } returns Optional.of(existing)
            every { repo.save(existing) } returns existing
            val result = service.update(1L, "new", "newc")
            result.title shouldBe "new"
            result.content shouldBe "newc"
            verifyOrder {
                repo.findById(1L)
                repo.save(existing)
            }
        }

        test("delete delegates to repo.deleteById") {
            every { repo.deleteById(5L) } just Runs
            service.delete(5L)
            verify { repo.deleteById(5L) }
        }
    }
}
