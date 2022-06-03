package pl.tomaszosuch.personlistapi.mapper;

import org.springframework.stereotype.Component;
import pl.tomaszosuch.personlistapi.dto.UserDto;
import pl.tomaszosuch.personlistapi.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapEntityToDto(final User user) {
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getDob(),
                user.getGender(),
                user.getRole(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public User mapDtoToEntity(final UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getDob(),
                userDto.getGender(),
                userDto.getRole(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public List<UserDto> mapToDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
