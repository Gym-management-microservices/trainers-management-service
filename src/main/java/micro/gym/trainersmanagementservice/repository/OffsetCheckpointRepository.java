package micro.gym.trainersmanagementservice.repository;

import micro.gym.trainersmanagementservice.model.OffsetCheckpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OffsetCheckpointRepository extends JpaRepository<OffsetCheckpoint, Long> {
    Optional<OffsetCheckpoint> findByTopicAndPartition(String topic, int partition);
}
