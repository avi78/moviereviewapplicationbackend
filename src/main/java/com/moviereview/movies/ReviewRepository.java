package com.moviereview.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    // Find reviews by imdbId
    List<Review> findByImdbId(String imdbId);
}
