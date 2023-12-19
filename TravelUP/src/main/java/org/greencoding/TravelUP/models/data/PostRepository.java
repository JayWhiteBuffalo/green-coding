package org.greencoding.TravelUP.models.data;


import org.greencoding.TravelUP.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
