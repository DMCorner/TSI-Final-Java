package UIElements.Game;
// film_id, title, description, release_year, language_id, original_language_id, rental_duration,
// rental_rate,length, replacement_cost, rating, special_features, last_update


import jakarta.persistence.*;

@Entity
@Table(name="film")

public class Film {
    @Id
    @Column(name = "film_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Film_ID;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    public Film() {}

    public Film(String title, String description) {
        title = title;
        description = description;
    }

    public int getFilm_ID() {
        return Film_ID;
    }
    // there are multiple lastname Jackman


    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public void setFilm_ID(int film_ID) {Film_ID = film_ID;}
    public int getFilm_ID(int film_ID) {return Film_ID;}

}