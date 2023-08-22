package Content;

public abstract class Content {
    protected ContentDetails contentDetails;
    protected long creationDate;

    public Content(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
        this.creationDate = System.currentTimeMillis();
    }

    public abstract void printStructure(String indent);
    
    public abstract String getName();

}
