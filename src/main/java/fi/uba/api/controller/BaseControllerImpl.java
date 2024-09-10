package fi.uba.api.controller;


import fi.uba.api.interfaces.BaseController;
import fi.uba.api.model.Base;
import fi.uba.api.service.BaseServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, UUID>> implements BaseController<E, UUID> {

    S service;

    protected BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAllRecord() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (EntityNotFoundException e) {
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        } catch (DataIntegrityViolationException e) {
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (EntityNotFoundException e) {
        } catch (Exception e) {
        }
        return null;
    }
}
