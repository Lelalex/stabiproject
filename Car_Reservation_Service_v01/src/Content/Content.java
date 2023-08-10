package Content;

public abstract class Content {
    protected String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void displayContentDetails();
}
