package UIElements.Game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends  JpaRepository<Film,Integer> {

    @Query(value = "SELECT film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name " +
            "from film " +
            "INNER JOIN film_actor ON film.film_id = film_actor.film_id " +
            "INNER JOIN actor ON film_actor.actor_id = actor.actor_id;", nativeQuery = true)
    Iterable<Film_ActorIntf> getAllFilmsActors();

    @Query(value = "SELECT film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name " +
            "from film " +
            "INNER JOIN film_actor ON film.film_id = film_actor.film_id " +
            "INNER JOIN actor ON film_actor.actor_id = actor.actor_id " +
            "WHERE film.film_id = :film_search_id ", nativeQuery = true)
    Iterable<Film_ActorIntf> getFilm_ActorById(@Param("film_search_id") int film_search_id);

    @Query(value = "SELECT film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name " +
            "from film " +
            "INNER JOIN film_actor ON film.film_id = film_actor.film_id " +
            "INNER JOIN actor ON film_actor.actor_id = actor.actor_id " +
            "WHERE actor.actor_id = :actor_search_id ", nativeQuery = true)
    Iterable<Film_ActorIntf> getActor_FilmById(@Param("actor_search_id") int actor_search_id);

    // ----------------FILM_CAT-FILM_CAT-FILM_CAT-FILM_CAT-FILM_CAT-FILM_CAT-FILM_CAT-FILM_CAT-------

    @Query(value = "SELECT film.film_id, film.title, category.category_id, category.name " +
            "from film " +
            "INNER JOIN film_category ON film.film_id = film_category.film_id " +
            "INNER JOIN category ON film_category.category_id = category.category_id; ", nativeQuery = true)
    Iterable<Film_CategoryIntf> getAllFilmsCategories();

    @Query(value = "SELECT film.film_id, film.title, category.category_id, category.name " +
            "from film " +
            "INNER JOIN film_category ON film.film_id = film_category.film_id " +
            "INNER JOIN category ON film_category.category_id = category.category_id " +
            "WHERE category.category_id = :category_search_id ", nativeQuery = true)
    Iterable<Film_CategoryIntf> getFilm_CategoryById(@Param("category_search_id") int category_search_id);

    @Query(value = "SELECT film.film_id, film.title, category.category_id, category.name " +
            "from film " +
            "INNER JOIN film_category ON film.film_id = film_category.film_id " +
            "INNER JOIN category ON film_category.category_id = category.category_id " +
            "WHERE film.film_id = :film_search_id ", nativeQuery = true)
    Iterable<Film_CategoryIntf> getCategory_FilmById(@Param("film_search_id") int film_search_id);
}

