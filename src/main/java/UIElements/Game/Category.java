package UIElements.Game;

import jakarta.persistence.*;

@Entity
@Table(name="category")

public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Category_ID;

    @Column(name = "name")
    String category_name;

    public Category() {}

    public Category(String cn) {
        category_name = cn;
    }

    public int getCategory_ID() {
        return Category_ID;
    }
    // there are multiple lastname Jackman

    public String getCategory_name() {return category_name;}
    public void setCategory_name(String category_name) {this.category_name = category_name;}
    public void setCategory_ID(int Category_ID) {Category_ID = Category_ID;}
}
