package Content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Folder extends Content {
	private List<Content> contents;

	public Folder(ContentDetails contentDetails) {
		super(contentDetails);
		contents = new ArrayList<>();
	}

	@Override
	public void printStructure(String indent) {
		System.out.println(indent + getName());
		for (Content content : contents) {
			content.printStructure(indent + "  ");
		}
	}
	
	public void addContent(Content content) {
		contents.add(content);
	}

	@Override
	public String getName() {
		SimpleDateFormat formattedYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat formattedMonth = new SimpleDateFormat("MM");

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(creationDate);

		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);

		if (month == 1) {
			return formattedYear.format(new Date(creationDate));
		} else {
			return formattedMonth.format(new Date(creationDate)) + "-" + year;
		}
	}
	
//    public void addContent(Content content) {
//        contents.add(content);
//    }
//
//    public void removeContent(Content content) {
//        contents.remove(content);
//    }

}
