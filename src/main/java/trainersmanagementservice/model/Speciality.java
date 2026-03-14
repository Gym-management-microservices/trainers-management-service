package trainersmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)  // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields as arguments
public class Speciality {
    private final String speciality_value;
    // constructor y métodos
}
