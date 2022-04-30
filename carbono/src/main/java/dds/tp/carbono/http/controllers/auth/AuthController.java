package dds.tp.carbono.http.controllers.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @GetMapping("/user")
    // @PreAuthorize("hasRole('MEMBER') or hasRole('ORG') or hasRole('ADMIN')")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok().body("asd");
    }
}
