package org.greencoding.TravelUP.models.data;


import org.greencoding.TravelUP.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
