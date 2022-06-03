package pl.tomaszosuch.personlistapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomaszosuch.personlistapi.model.User;
import pl.tomaszosuch.personlistapi.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        userRepository.findById(entity.getId()).orElseThrow();
        return userRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        userRepository.findById(entity.getId()).orElseThrow();
        userRepository.delete(entity);
    }


    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
