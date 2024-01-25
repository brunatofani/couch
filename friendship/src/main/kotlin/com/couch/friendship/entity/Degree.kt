package com.couch.friendship.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Degree {
    constructor(description: String) : this()

    constructor()

    @Id
    @GeneratedValue
    private var degree_id: Long? = null
    private var description: String = ""

    fun Degree (description: String) {
        this.description = description
    }

    fun setDescription(s: String) {
        description = s
    }

    fun getDescription(): String {
        return description
    }

    fun getDegreeId(): Long? {
        return this.degree_id
    }

    fun setDegreeId(s: Long) {
        degree_id = s
    }
}