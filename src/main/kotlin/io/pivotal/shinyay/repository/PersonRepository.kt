package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Gender
import io.pivotal.shinyay.entity.Person
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class PersonRepository {
    val persons = mutableListOf<Person>()

    @PostConstruct
    fun init() {
        save(Person(null, "Rei Ayanami", 14, Gender.FEMALE))
        save(Person(null, "Shinji Ikari", 14, Gender.MALE))
        save(Person(null, "Asuka Langley Sohryu", 14, Gender.FEMALE))
    }

    fun save(person: Person): Person {
        person.id = (persons.maxBy { it.id!! }?.id ?: 0 ) + 1
        persons.add(person)
        return person
    }

    fun findAll() = persons

    fun findById(id: Int) = persons.singleOrNull { it.id == id }

    fun update(person: Person): Person {
        val index = persons.indexOfFirst { it.id == person.id }
        if(index >= 0){
            persons[index] = person
        }
        return person
    }

    fun removeById(id: Int) = persons.removeIf { it.id == id }
}