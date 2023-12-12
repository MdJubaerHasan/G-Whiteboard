package le.ac.uk.gwhiteboard.controller;

import le.ac.uk.gwhiteboard.DTO.ResponseDTO;
import le.ac.uk.gwhiteboard.DTO.UserLoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/whiteboard")
public class WhiteboardController {

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("forward:/index.html");
    }

    @GetMapping("/test")
    @ResponseBody
    public String testEndpoint() {
        return "Whiteboard backend is running!";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) {
        if ("admin".equals(loginDTO.getUsername()) && "admin".equals(loginDTO.getPassword())) {
            return ResponseEntity.ok(new ResponseDTO(true, "Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(false, "Invalid credentials"));
        }
    }
}
