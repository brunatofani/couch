package com.couch.friendship.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
class User() {
    constructor(name: String) : this()

    @Id
    @GeneratedValue
    private var user_id: Long? = null
    private var name: String = ""

    fun User (name: String) {
        this.name = name
    }

    fun setName(s: String) {
        name = s
    }

    fun getName(): String {
        return name
    }

    fun getUserId(): Long? {
        return this.user_id
    }
    fun setUserId(s: Long) {
        user_id = s
    }
}