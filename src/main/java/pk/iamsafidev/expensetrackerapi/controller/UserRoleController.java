package pk.iamsafidev.expensetrackerapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pk.iamsafidev.expensetrackerapi.entity.UserRoles;
import pk.iamsafidev.expensetrackerapi.service.UserRoleService;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/roles")
    public ResponseEntity<UserRoles> save(@Valid @RequestBody UserRoles userRoles) {
        return new ResponseEntity<>(userRoleService.saveUserRoleDetails(userRoles), HttpStatus.CREATED);
    }
}
