package fi.uba.api.service;


import fi.uba.api.interfaces.SnapMsgService;
import fi.uba.api.model.SnapMsg;
import fi.uba.api.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SnapMsgServiceImpl extends BaseServiceImpl<SnapMsg, UUID> implements SnapMsgService {


    protected SnapMsgServiceImpl(BaseRepository<SnapMsg, UUID> baseRepository) {
        super(baseRepository);
    }
}
