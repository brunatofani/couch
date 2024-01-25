package com.couch.friendship.controller

import com.couch.friendship.entity.User
import com.couch.friendship.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


@Service
class UserController (val repository: UserRepository) {

    @GetMapping("/users")
    fun all(): MutableList<User?> {
       return repository.findAll()
    }


    @GetMapping("/{id}")
    fun one(@PathVariable id: Long?): User? {
        return id?.let {
            repository.findById(it)
                .orElseThrow  { RuntimeException() }
        }
    }

    @PostMapping("/user")
    fun newEmployee(@RequestBody newUser: User): User {
        return repository.save(newUser)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<*> {
        repository.deleteById(id)
        return ResponseEntity.noContent().build<Any>()
    }
}