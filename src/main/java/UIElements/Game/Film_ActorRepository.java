package UIElements.Game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface Film_ActorRepository extends  JpaRepository<Film_Actor,Integer> {

//    @Query(value =
//            "SELECT film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name from film INNER JOIN film_actor ON film.film_id = film_actor.film_id INNER JOIN actor ON film_actor.actor_id = actor.actor_id;", nativeQuery = true)
//    Collection<Film> getAllFilms_Actors(@Param("film"))



}