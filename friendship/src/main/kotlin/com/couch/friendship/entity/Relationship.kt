package com.couch.friendship.entity

import jakarta.persistence.*

@Entity
class Relationship {

    @Id
    @GeneratedValue
    private var relationship_degree_user_id: Long = Long.MIN_VALUE
    @OneToOne
    @JoinColumn(name = "main_user")
    private lateinit var main_user: User
    @OneToOne
    @JoinColumn(name = "chosen_user")
    private lateinit var chosen_user: User
    @OneToOne
    @JoinColumn(name = "degree_id")
    private lateinit var degree: Degree

    fun setRelationshipDegreeUserId(s: Long) {
        relationship_degree_user_id = s
    }

    fun getRelationshipDegreeUserId(): Long {
        return relationship_degree_user_id
    }

    fun setMainUser(s: User) {
        main_user = s
    }

    fun getMainUser(): User {
        return main_user
    }

    fun setChosenUser(s: User) {
        chosen_user = s
    }

    fun getChosenUser(): User {
        return chosen_user
    }

    fun setDegree(s: Degree) {
        degree = s
    }

    fun getDegree(): Degree {
        return degree
    }
}