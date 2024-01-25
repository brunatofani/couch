package com.couch.friendship.controller

import com.couch.friendship.entity.Degree
import com.couch.friendship.repository.DegreeRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


@Service
class DegreeController (val repository: DegreeRepository) {

    @GetMapping("/degress")
    fun all(): MutableList<Degree?> {
        return repository.findAll()
    }


    @GetMapping("/degree/{id}")
    fun one(@PathVariable id: Long?): Degree? {
        return id?.let {
            repository.findById(it)
                .orElseThrow  { RuntimeException() }
        }
    }

    @PostMapping("/degree")
    fun newEmployee(@RequestBody newDegree: Degree): Degree {
        return repository.save(newDegree)
    }

    @DeleteMapping("/degree/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<*> {
        repository.deleteById(id)
        return ResponseEntity.noContent().build<Any>()
    }
}