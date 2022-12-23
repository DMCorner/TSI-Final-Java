//package UIElements.Game;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table (name = "film_actor")
//@IdClass(Film_ActorId.class)
//
//
//
//public class Film_Actor {
//    @Id
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
//    Actor actor;
//    @Id
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
//    Film film;
//
//    public Film_Actor() {
//
//    }
//}










//----------------------old stuff-----------------------------------------------------------------------------

package UIElements.Game;
// film_id, title, description, release_year, language_id, original_language_id, rental_duration,
// rental_rate,length, replacement_cost, rating, special_features, last_update


import jakarta.persistence.*;

@IdClass(Film_ActorId.class)
@Entity
@Table(name="film_actor")

public class Film_Actor {



//    //    @Id
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    @Id
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(fetch = FetchType.EAGER)
    Film Film_ID;

    @Id
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    @ManyToOne(fetch = FetchType.EAGER)
    Actor Actor_ID;

    public Film_Actor() {
    }

    public Film getFilm_ID() {
        return Film_ID;
    }

    public void setFilm_ID(Film film_ID) {
        Film_ID = film_ID;
    }

    public Actor getActor_ID() {
        return Actor_ID;
    }

    public void setActor_ID(Actor actor_ID) {
        Actor_ID = actor_ID;
    }

    //
////    @Column(name = "title")
////    String title;
//
//    @Column(name = "actor_ID")
//    int Actor_ID;
//
////    @Column(name = "first_name")
////    String firstname;
////
////    @Column(name = "last_name")
////    String lastname;
//
////    @Column(name = "description")
////    String description;
//
//    public Film_Actor() {}
//
//    public Film_Actor(int film_ID, String title, int actor_ID, String firstname, String lastname) {
//        film_ID = film_ID;
//        title = title;
//        actor_ID = actor_ID;
//        firstname = firstname;
//        lastname = lastname;
//    }
//
//    public int getFilm_ID() {
//        return Film_ID;
//    }
//    public int getActor_ID() {
//        return Actor_ID;
//    }
////    public void setFilm_ID(int film_ID) {Film_ID = film_ID;}
////    public String getTitle() {return title;}
////    public void setTitle(String title) {this.title = title;}
////    public void setActor_ID(int actor_ID) {Actor_ID = actor_ID;}
////    public String getFirstname() {return firstname;}
////    public void setFirstname(String firstname) {this.firstname = firstname;}
////    public String getLastname() {return lastname;}
////    public void setLastname(String lastname) {this.lastname = lastname;}
}