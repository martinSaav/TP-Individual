package fi.uba.api.service;


import fi.uba.api.interfaces.BaseService;
import fi.uba.api.model.Base;
import fi.uba.api.repository.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;


public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    protected BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public E findById(ID id) {
        return findByIdAux(id);
    }

    @Transactional
    @Override
    public E save(E entity) {
        return baseRepository.save(entity);
    }

    @Transactional
    @Override
    public boolean delete(ID id) throws EntityNotFoundException {
        E entityFound = findByIdAux(id);
        baseRepository.delete(entityFound);
        return true;
    }

    private E findByIdAux(ID id) {
        return baseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("La entidad con el id: " + id + " no existe"));
    }
}
