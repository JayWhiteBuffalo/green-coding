package org.launchcode.greencoding.TravelUp.models.data;

import org.launchcode.greencoding.TravelUp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
