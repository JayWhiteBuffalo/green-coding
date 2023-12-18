package org.launchcode.greencoding.TravelUp.models.data;

import org.launchcode.greencoding.TravelUp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
