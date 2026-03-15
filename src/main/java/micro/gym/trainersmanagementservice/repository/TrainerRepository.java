package micro.gym.trainersmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import micro.gym.trainersmanagementservice.model.Trainer;
import micro.gym.trainersmanagementservice.model.TrainerId;

public interface TrainerRepository extends JpaRepository<Trainer, TrainerId> {
}
