package com.moviereview.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private ObjectId id;
    private String body;
    private String imdbId; // Add this field
    private LocalDateTime created;
    private LocalDateTime updated;

    // Add a constructor that matches the arguments used in ReviewService
    public Review(String body, String imdbId, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.imdbId = imdbId;
        this.created = created;
        this.updated = updated;
    }
}
