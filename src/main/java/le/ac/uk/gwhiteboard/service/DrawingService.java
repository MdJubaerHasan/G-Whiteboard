package le.ac.uk.gwhiteboard.service;

import le.ac.uk.gwhiteboard.model.Drawing;
import le.ac.uk.gwhiteboard.repository.DrawingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawingService {

    private final DrawingRepository drawingRepository;

    @Autowired
    public DrawingService(DrawingRepository drawingRepository) {
        this.drawingRepository = drawingRepository;
    }

    public Drawing saveDrawing(Drawing drawing) {
        return drawingRepository.save(drawing); // Save the drawing to the database
    }

    public List<Drawing> getDrawingsByCanvasId(Long canvasId) {
        // Assuming there's a method in the repository to find drawings by canvasId
        return drawingRepository.findByCanvasId(canvasId);
    }

    // Add more methods as needed for other operations
}
