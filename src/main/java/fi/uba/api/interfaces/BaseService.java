package fi.uba.api.interfaces;


import fi.uba.api.model.Base;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {

    List<E> findAll();

    E findById(ID id) throws EntityNotFoundException;

    E save(E entity) throws DataIntegrityViolationException;

    boolean delete(ID id) throws EntityNotFoundException;
}
