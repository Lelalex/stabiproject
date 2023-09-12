package ressource;

import org.junit.jupiter.api.Test;

import de.stabi.ressource.behaviour.RessourceService;

public class RessourceTest {

    @Test
    public void testGetSelectedRessource() {
        RessourceService service = new RessourceService();
        service.getSelectedRessource();
      
    }
}