package com.couch.friendship

import com.couch.friendship.entity.Degree
import com.couch.friendship.entity.User
import com.couch.friendship.repository.DegreeRepository
import com.couch.friendship.repository.UserRepository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LoadDatabase {
    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @Bean
    fun initDatabase(UserRepository: UserRepository, degreeRepository: DegreeRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->

            log.info("Loading Users " + UserRepository.save(User("Bruna")))
            log.info("Loading Users " + UserRepository.save(User("George")))
            log.info("Loading Users " + UserRepository.save(User("Fabiana")))
            log.info("Loading Users " + UserRepository.save(User("Adam")))

            log.info("Loading Degree " + degreeRepository.save(Degree("2nd")))
            log.info("Loading Degree " + degreeRepository.save(Degree("1st")))
            log.info("Loading Degree " + degreeRepository.save(Degree("4th")))
            log.info("Loading Degree " + degreeRepository.save(Degree("5th")))
            log.info("Loading Degree " + degreeRepository.save(Degree("3rd")))
        }
    }
}