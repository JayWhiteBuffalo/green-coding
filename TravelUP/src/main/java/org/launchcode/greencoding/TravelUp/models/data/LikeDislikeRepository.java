package org.launchcode.greencoding.TravelUp.models.data;

import org.launchcode.greencoding.TravelUp.models.LikeDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Integer> {
}
