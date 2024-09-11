package fi.uba.api.controller;


import fi.uba.api.exception.UnknownErrorException;
import fi.uba.api.interfaces.BaseController;
import fi.uba.api.model.Base;
import fi.uba.api.service.BaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            description = "Trae todos los registros",
            parameters = {},
            responses = {
                    @ApiResponse(responseCode = "200", ref = "okAPI"),
                    @ApiResponse(responseCode = "401", ref = "unauthorizedAPI"),
                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI")
            }
    )
    public ResponseEntity<?> getAllRecord() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            throw new UnknownErrorException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
    }
}
