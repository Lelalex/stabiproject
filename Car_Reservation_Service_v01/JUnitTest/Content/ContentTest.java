package Content;

//class ContentTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class ContentTest {

    @Test
    public void testFileGetName() {
        
        ContentDetails contentDetails = new ContentDetails(null, null);
        File file = new File(contentDetails);
        String expectedNameFormat = "yyyy-MM-dd.java";
        String expectedName = new SimpleDateFormat(expectedNameFormat).format(new Date(file.creationDate)) + ".java";
        assertEquals(expectedName, file.getName());
    }

	@Test
    public void testFolderGetName() {
       
        ContentDetails contentDetails = new ContentDetails(null, null);
        Folder folder = new Folder(contentDetails);
        String expectedNameFormat = "MM-yyyy";
        String expectedName = new SimpleDateFormat(expectedNameFormat).format(new Date(folder.creationDate));

        // Wenn der Monat 1 ist, sollte der erwartete Name das Jahresformat sein (yyyy)
        if (new Date(folder.creationDate).getMonth() == 0) {
            expectedName = new SimpleDateFormat("yyyy").format(new Date(folder.creationDate));
        }
        assertEquals(expectedName, folder.getName());
    }

    @Test
    public void testAddContentToFolder() {

        ContentDetails contentDetails = new ContentDetails(null, null);
        // Booking = new Booking, Payment = new Payment -> Methode im Pckg einfügen
        // Test der Methode addContent aus Contentservice
        Folder folder = new Folder(contentDetails);
        File file = new File(contentDetails);
        folder.addContent(file);
        assertTrue(folder.getContents().contains(file));
    }
}
