package com.moviereview.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = new Review();
        review.setBody(reviewBody);
        review.setImdbId(imdbId);
        review.setCreated(LocalDateTime.now());
        review.setUpdated(LocalDateTime.now());
        review = repository.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }

    public List<Review> getReviewsByMovieId(String imdbId) {
        return repository.findByImdbId(imdbId);
    }
}
