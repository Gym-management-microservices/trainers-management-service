package micro.gym.trainersmanagementservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)  // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields as arguments
public class Availability {
    private final String availability_value;
    // constructor y métodos
}