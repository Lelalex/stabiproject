package de.stabi.content.behaviour;

import java.util.Date;

import de.stabi.content.structure.File;
import de.stabi.content.structure.Folder;

public class ContentService {
	public static void createFileSystemStructure() {
		Folder root = new Folder(null);
		
		Date today = new Date();
		Folder monthFolder = new Folder(null);
		File fileToday = new File(null);
		
		monthFolder.addContent(fileToday);
		root.addContent(monthFolder);
		
		root.printStructure("");
	}
}
