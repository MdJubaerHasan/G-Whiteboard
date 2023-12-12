package le.ac.uk.gwhiteboard.controller;

import le.ac.uk.gwhiteboard.model.Canvas;
import le.ac.uk.gwhiteboard.service.CanvasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canvas")
public class CanvasController {

    private final CanvasService canvasService;

    @Autowired
    public CanvasController(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @PostMapping("/create")
    public Canvas createCanvas() {
        return canvasService.createNewCanvas();
    }

    @GetMapping("/all")
    public List<Canvas> getAllCanvases() {
        return canvasService.getAllCanvases();
    }

    // Additional endpoints as needed
}
