package by.martinyuk.sphere.entity;

public abstract class AbstractShape {
    private long id;

    public AbstractShape(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
