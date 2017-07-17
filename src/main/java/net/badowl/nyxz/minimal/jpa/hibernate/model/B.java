package net.badowl.nyxz.minimal.jpa.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "b", schema = "test")
public class B {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "label")
    private String label;

    @OneToOne
    private A a;

    public int getId() {
        return id;
    }

    public B setId(int id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public B setLabel(String label) {
        this.label = label;
        return this;
    }

    public A getA() {
        return a;
    }

    public B setA(A a) {
        this.a = a;
        return this;
    }

    @Override
    public String toString() {
        return String.format("A [ %d , %s ]", id, label);
    }
}
