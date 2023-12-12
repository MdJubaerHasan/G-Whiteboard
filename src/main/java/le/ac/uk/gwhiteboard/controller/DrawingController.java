package le.ac.uk.gwhiteboard.controller;

import le.ac.uk.gwhiteboard.model.Drawing;
import le.ac.uk.gwhiteboard.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drawing")
public class DrawingController {

    private final DrawingService drawingService;

    @Autowired
    public DrawingController(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @PostMapping("/save")
    public Drawing saveDrawing(@RequestBody Drawing drawing) {
        return drawingService.saveDrawing(drawing);
    }

    @GetMapping("/canvas/{canvasId}")
    public List<Drawing> getDrawingsByCanvasId(@PathVariable Long canvasId) {
        return drawingService.getDrawingsByCanvasId(canvasId);
    }

    // Additional endpoints as needed
}
