package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@Table(name = "GeneratedRandomNumbers")
public class GeneratedRandomNumbers extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "generatedRandomNumbers")
    private String generatedRandomNumbers;

    public GeneratedRandomNumbers() {
    }

    public GeneratedRandomNumbers(String generatedRandomNumbers) {
        this.generatedRandomNumbers = generatedRandomNumbers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGeneratedRandomNumbers(String generatedRandomNumbers) {
        this.generatedRandomNumbers = generatedRandomNumbers;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GeneratedRandomNumbers{" +
                "id=" + id +
                ", generatedRandomNumbers='" + generatedRandomNumbers + '\'' +
                '}';
    }
}

