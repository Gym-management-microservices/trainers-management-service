package TrainerService.repository;

import TrainerService.model.Trainer;
import TrainerService.model.TrainerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, TrainerId> {
}
