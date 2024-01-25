package com.couch.friendship.assemble

import com.couch.friendship.controller.UserController
import com.couch.friendship.entity.User
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component


@Component
class UserModelAssembler : RepresentationModelAssembler<User, EntityModel<User>> {
    override fun toModel(user: User): EntityModel<User> {
        return EntityModel.of(
            user,
            methodOn(UserController::class.java).one(user.getUserId())?.let { linkTo(it).withRel("user") },
            linkTo(methodOn(UserController::class.java).all()).withRel("users")
        )
    }
}