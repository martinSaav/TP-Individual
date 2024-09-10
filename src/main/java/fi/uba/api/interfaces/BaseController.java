package fi.uba.api.interfaces;


import fi.uba.api.model.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;


public interface BaseController<E extends Base, ID extends Serializable> {

    ResponseEntity<?> getAllRecord();

    ResponseEntity<?> getRecordById(@PathVariable ID id);

    ResponseEntity<?> save(@RequestBody E entity);

    ResponseEntity<?> delete(@PathVariable ID id);
}