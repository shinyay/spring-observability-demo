package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Person
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class PersonRepository {
    val persons = mutableListOf<Person>()

    @PostConstruct
    fun init() {

    }

    fun save(person: Person): Person {
        person.id = (persons.maxBy { it.id!! }?.id ?: 0 ) + 1
        persons.add(person)
        return person
    }
}