package Content;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Content {
    private List<Content> contents = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public void removeContent(Content content) {
        contents.remove(content);
    }

    @Override
    public void displayContentDetails() {
        System.out.println("Folder Name: " + this.name);
        for (Content content : contents) {
            content.displayContentDetails();
        }
    }
}
