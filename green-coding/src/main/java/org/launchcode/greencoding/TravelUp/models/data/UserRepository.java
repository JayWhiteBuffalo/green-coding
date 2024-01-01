package org.launchcode.greencoding.TravelUp.models.data;

import org.launchcode.greencoding.TravelUp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
