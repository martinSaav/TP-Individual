package fi.uba.api.controller;


import fi.uba.api.model.SnapMsg;
import fi.uba.api.service.SnapMsgServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/snapMsgs")
public class SnapMsgController extends BaseControllerImpl<SnapMsg, SnapMsgServiceImpl> {


    protected SnapMsgController(SnapMsgServiceImpl service) {
        super(service);
    }
}
