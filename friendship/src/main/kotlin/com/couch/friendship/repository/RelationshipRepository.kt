package com.couch.friendship.repository

import com.couch.friendship.entity.Relationship
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationshipRepository : JpaRepository<Relationship?, Long?> {
}