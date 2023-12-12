package le.ac.uk.gwhiteboard.repository;

import le.ac.uk.gwhiteboard.model.Drawing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DrawingRepository extends MongoRepository<Drawing, String> {
    List<Drawing> findByCanvasId(Long canvasId);
    // You can add custom queries here if needed
}
