package com.example.clientes.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Editorial {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "editorial_id")
    private int editorialId;
    @Basic
    @Column(name = "editorial")
    private String editorial;

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editorial editorial1 = (Editorial) o;
        return editorialId == editorial1.editorialId && Objects.equals(editorial, editorial1.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editorialId, editorial);
    }
}
