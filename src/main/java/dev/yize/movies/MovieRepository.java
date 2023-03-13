package dev.yize.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//actually talking to the database and getting the data back
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    //mongoDB data will understand what we are trying to do
    Optional<Movie> findMovieByImdbId(String imdbId);
}
