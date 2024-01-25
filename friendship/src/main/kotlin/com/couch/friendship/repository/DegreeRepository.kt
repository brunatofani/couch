package com.couch.friendship.repository

import com.couch.friendship.entity.Degree
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DegreeRepository : JpaRepository<Degree?, Long?>