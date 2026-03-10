package trainersmanagementservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainer {

    @EmbeddedId
    private TrainerId trainerId;

    @Column(name = "name")
    private String name;

    @Embedded
    private Speciality speciality;

    @Embedded
    private Availability availability;
}
