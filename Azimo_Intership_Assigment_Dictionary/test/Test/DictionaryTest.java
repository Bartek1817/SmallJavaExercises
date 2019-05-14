/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dictionary.Dictionary;
import static dictionary.Dictionary.polishToGerman;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartłomiej Żmuda
 */
public class DictionaryTest {

    String translation = "Brak słowa w słowniku / No word in dictionary / Kein Wort im Wörterbuch";

    @Test
    public void testPolish2EnglishTrue() throws IOException {
        assertTrue(Dictionary.polish2English("POL2ENG.txt", "rower").equals("bike"));
    }

    @Test
    public void testPolish2EnglishFalse() throws IOException {
        assertFalse(Dictionary.polish2English("POL2ENG.txt", "rower").equals("rower"));
    }

    @Test
    public void testPolish2EnglishFalse2() throws IOException {
        assertFalse(!Dictionary.polish2English("POL2ENG.txt", "byleco").equals(translation));
    }

    @Test
    public void testPolish2GermanTrue() throws IOException {
        assertTrue(Dictionary.polishToGerman("POL2ENG.txt", "ENG2GER.txt", "rower").equals("fahrrad"));
    }

    @Test
    public void testPolish2GermanFalse() throws IOException {
        assertFalse(Dictionary.polishToGerman("POL2ENG.txt", "ENG2GER.txt", "rower").equals("rower"));
    }

    @Test
    public void testPolish2GermanFalse2() throws IOException {
        assertFalse(!Dictionary.polishToGerman("POL2ENG.txt", "ENG2GER.txt", "byleco").equals(translation));
    }

}
