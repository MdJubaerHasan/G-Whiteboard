package le.ac.uk.gwhiteboard.repository;

import le.ac.uk.gwhiteboard.model.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanvasRepository extends JpaRepository<Canvas, Long> {
    // You can add custom database operations here if needed
}
