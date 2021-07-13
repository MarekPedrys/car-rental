package pl.jcommerce.carrental.adnotacje;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Mother mother;

    public Child(String name, Mother mother) {
        this.name = name;
        this.mother = mother;
    }

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }
}
