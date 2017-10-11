package by.martinyuk.sphere.entity;

public abstract class AbstractEntitiy {
    private long id;

    public AbstractEntitiy(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
