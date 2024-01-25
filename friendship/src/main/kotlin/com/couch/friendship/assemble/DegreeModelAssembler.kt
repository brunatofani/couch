package com.couch.friendship.assemble

import com.couch.friendship.controller.DegreeController
import com.couch.friendship.entity.Degree
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component


@Component
class DegreeModelAssembler : RepresentationModelAssembler<Degree, EntityModel<Degree>> {
    override fun toModel(degree: Degree): EntityModel<Degree> {
        return EntityModel.of(
            degree,
            methodOn(DegreeController::class.java).one(degree.getDegreeId())?.let { linkTo(it).withRel("degree") },
            linkTo(methodOn(DegreeController::class.java).all()).withRel("degrees")
        )
    }
}