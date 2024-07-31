package entities;

import java.util.Objects;

public class Students {
    private int id;

    public Students(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
