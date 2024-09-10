package fi.uba.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/snapMsg")
public class SnapMsgController {

    @GetMapping("")
    public ResponseEntity<?> getAllRecord() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }
}
