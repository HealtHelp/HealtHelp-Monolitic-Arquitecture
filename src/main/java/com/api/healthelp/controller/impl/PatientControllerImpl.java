package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.PatientController;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;
import com.api.healthelp.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.lang.invoke.MethodHandles;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PatientControllerImpl implements PatientController {

    @Autowired
    private EntityLinks entityLinks;
    private PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public PatientControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public ResponseEntity<Resources<PatientDTO>> getPatients() throws RuntimeException {
        logger.info(" -- GET  /patients");
        Resources<PatientDTO> resources = new Resources<>(patientService.getPatients());
        resources.add(this.entityLinks.linkToCollectionResource(Patient.class));
        return new ResponseEntity(resources,HttpStatus.OK);
    }

    @Override
<<<<<<< HEAD
    public ResponseEntity<PatientDTO> getPatientById(Long id) throws RuntimeException {
=======
    public ResponseEntity<Resource<PatientDTO>> getPatientById(Long id) throws RuntimeException {
>>>>>>> 0a5d7dd3b7ed502ecf22fc9e41717adf0e9e654c
        logger.info(" -- GET  /patient/{}",id);
        Resource<PatientDTO> resource = new Resource<>(patientService.getPatientById(id));
        resource.add(this.entityLinks.linkToCollectionResource(Patient.class));
        return new ResponseEntity(resource,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PatientDTO> getPatientByName(String name) throws RuntimeException {
        logger.info(" -- GET  /patient/{}",name);
        Resource<PatientDTO> resource = new Resource<>(patientService.getPatientByName(name));
        resource.add(this.entityLinks.linkToCollectionResource(Patient.class));
        return new ResponseEntity(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<PatientDTO>> insertPatient(Patient patient) {
        logger.info(" -- POST  /patient/",patient.getPatientName());
        Resource<PatientDTO> resource = new Resource<>(patientService.insertPatient(patient));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).insertPatient(patient));
        resource.add(linkTo.withRel("insert-patient"));
        return new ResponseEntity(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<PatientDTO>> updatePatient(Patient patient) {
        logger.info(" -- PUT  /patient/",patient.getPatientName());
        Resource<PatientDTO> resource = new Resource<>(patientService.updatePatient(patient));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).updatePatient(patient));
        resource.add(linkTo.withRel("update-patient"));
        return new ResponseEntity(resource,HttpStatus.OK);
    }


}
