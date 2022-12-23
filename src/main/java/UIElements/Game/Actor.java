package UIElements.Game;

import jakarta.persistence.*;

@Entity
@Table(name="actor")

public class Actor {
    @Id
    @Column(name = "Actor_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Actor_ID;

    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    public Actor() {}

    public Actor(String fn, String ln) {
        lastname = ln;
        firstname = fn;
    }

    public int getActor_ID() {
        return Actor_ID;
    }
    // there are multiple lastname Jackman

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setActor_ID(int actor_ID) {Actor_ID = actor_ID;}
}