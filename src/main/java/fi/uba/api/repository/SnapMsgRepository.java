package fi.uba.api.repository;


import fi.uba.api.model.SnapMsg;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface SnapMsgRepository extends BaseRepository<SnapMsg, UUID> {

}