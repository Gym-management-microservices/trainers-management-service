package trainersmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import trainersmanagementservice.model.Trainer;
import trainersmanagementservice.model.TrainerId;

public interface TrainerRepository extends JpaRepository<Trainer, TrainerId> {
}
