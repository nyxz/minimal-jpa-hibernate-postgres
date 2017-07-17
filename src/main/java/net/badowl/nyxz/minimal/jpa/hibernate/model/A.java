package net.badowl.nyxz.minimal.jpa.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "a", schema = "test")
public class A {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "label")
    private String label;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "a")
    private B b;

    public int getId() {
        return id;
    }

    public A setId(int id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public A setLabel(String label) {
        this.label = label;
        return this;
    }

    public B getB() {
        return b;
    }

    public A setB(B b) {
        this.b = b;
        return this;
    }

    @Override
    public String toString() {
        return String.format("A [ %d , %s ]", id, label);
    }
}
