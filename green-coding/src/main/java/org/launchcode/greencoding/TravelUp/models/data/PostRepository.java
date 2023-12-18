package org.launchcode.greencoding.TravelUp.models.data;

import org.launchcode.greencoding.TravelUp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
