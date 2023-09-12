package de.stabi.content.structure;

public abstract class Content {
    protected ContentDetails contentDetails;
    public long creationDate;

    public Content(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
        this.creationDate = System.currentTimeMillis();
    }

    public abstract void printStructure(String indent);
    
    public abstract String getName();

}
