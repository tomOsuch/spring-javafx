package pl.tomaszosuch.personlistapi.service;

import pl.tomaszosuch.personlistapi.model.User;

public interface UserService extends GenericService<User> {

    User findByEmail(String email);
}
