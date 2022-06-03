package pl.tomaszosuch.personlistapi.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.personlistapi.model.User;
import pl.tomaszosuch.personlistapi.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testUserFindById() {
        //given
        User user = new User(1L, "Jan", "Kowalski", LocalDate.now(), "male", "admin", "jan@kowalski.pl", "admin");
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        //when
        User resultFindById = userService.findById(1L);
        //then
        assertEquals(user.getFirstName(), resultFindById.getFirstName());
        assertEquals(user.getLastName(), resultFindById.getLastName());
        assertEquals(user.getDob(), resultFindById.getDob());
        assertEquals(user.getGender(), resultFindById.getGender());
        assertEquals(user.getRole(), resultFindById.getRole());
        assertEquals(user.getEmail(), resultFindById.getEmail());
        assertEquals(user.getPassword(), resultFindById.getPassword());
    }

    @Test
    public void testUserFindAll() {
        //given
        List<User> users = List.of(new User(1L, "Jan", "Kowalski", LocalDate.now(), "male", "admin", "jan@kowalski.pl", "admin"));
        when(userRepository.findAll()).thenReturn(users);
        //when
        List<User> resultFindAll = userService.findAll();
        //then
        assertEquals(1, resultFindAll.size());
    }

    @Test
    public void testUserSave() {
        //given
        User user = new User(1L, "Jan", "Kowalski", LocalDate.now(), "male", "admin", "jan@kowalski.pl", "admin");
        when(userRepository.save(user)). thenReturn(user);
        //when
        User resultSave = userService.save(user);
        //then
        assertEquals(user.getFirstName(), resultSave.getFirstName());
        assertEquals(user.getLastName(), resultSave.getLastName());
        assertEquals(user.getDob(), resultSave.getDob());
        assertEquals(user.getGender(), resultSave.getGender());
        assertEquals(user.getRole(), resultSave.getRole());
        assertEquals(user.getEmail(), resultSave.getEmail());
        assertEquals(user.getPassword(), resultSave.getPassword());
    }

    @Test
    public void testUserDeleteById() {
        //given
        User user = new User(1L, "Jan", "Kowalski", LocalDate.now(), "male", "admin", "jan@kowalski.pl", "admin");
        Long id = user.getId();
        //when
        userService.deleteById(id);
        //then
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUserFindByEmail() {
        //given
        User user = new User("Jan", "Kowalski", LocalDate.now(), "male", "admin", "jan@kowalski.pl", "admin");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
        //when
        User resultFindByEmail = userService.findByEmail("jan@kowalski.pl");
        //then
        assertEquals(user.getFirstName(), resultFindByEmail.getFirstName());
        assertEquals(user.getLastName(), resultFindByEmail.getLastName());
        assertEquals(user.getDob(), resultFindByEmail.getDob());
        assertEquals(user.getGender(), resultFindByEmail.getGender());
        assertEquals(user.getRole(), resultFindByEmail.getRole());
        assertEquals(user.getEmail(), resultFindByEmail.getEmail());
        assertEquals(user.getPassword(), resultFindByEmail.getPassword());
    }
}
