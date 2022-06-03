package pl.tomaszosuch.personlistapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String role;
    private String email;
    private String password;
}
