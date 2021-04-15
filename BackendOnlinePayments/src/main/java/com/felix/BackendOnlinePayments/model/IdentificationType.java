package com.felix.BackendOnlinePayments.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Identification_type")
public class IdentificationType  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "acronym")
    private String acronym;

    public IdentificationType() {
    }

    public IdentificationType(Integer id, String description, String acronym) {
        this.id = id;
        this.description = description;
        this.acronym = acronym;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationType that = (IdentificationType) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(acronym, that.acronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, acronym);
    }

    @Override
    public String toString() {
        return "IdentificationType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
