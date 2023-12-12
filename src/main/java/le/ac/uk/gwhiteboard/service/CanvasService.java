package le.ac.uk.gwhiteboard.service;

import le.ac.uk.gwhiteboard.model.Canvas;
import le.ac.uk.gwhiteboard.repository.CanvasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanvasService {

    private final CanvasRepository canvasRepository;

    @Autowired
    public CanvasService(CanvasRepository canvasRepository) {
        this.canvasRepository = canvasRepository;
    }

    public Canvas createNewCanvas() {
        Canvas canvas = new Canvas();
        return canvasRepository.save(canvas); // Save the new canvas to the database
    }

    public List<Canvas> getAllCanvases() {
        return canvasRepository.findAll(); // Retrieve all canvases from the database
    }

    // Add more methods as needed for other operations
}
