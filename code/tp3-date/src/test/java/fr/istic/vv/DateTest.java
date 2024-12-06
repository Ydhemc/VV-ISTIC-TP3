package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

	@Test
    public void testValidDate() {
		//Jours
			//Valide
		for(int i=1; i<=31;i++) {
			assertTrue(Date.isValidDate(i, 8, 2024));
		}
        	//Invalide
        assertFalse(Date.isValidDate(-1, 12, 2024));
        assertFalse(Date.isValidDate(-10, 6, 2004));
        assertFalse(Date.isValidDate(40, 2, 1960));
        assertFalse(Date.isValidDate(32, 8, 2024));
        assertFalse(Date.isValidDate(0, 8, 2024));
        
        //Mois
    	//Valide
        for(int i=1; i<=12;i++) {
			assertTrue(Date.isValidDate(15, i, 2024));
		}
        	//Invalide
        assertFalse(Date.isValidDate(10, 13, 2024));
        assertFalse(Date.isValidDate(5, 0, 2004));
        assertFalse(Date.isValidDate(4, 50, 1960));
        assertFalse(Date.isValidDate(1, -10, 2024));
        
        //Année
        	//Valide
        assertTrue(Date.isValidDate(1, 1, 2024));
        assertTrue(Date.isValidDate(31, 12, 2024));
        	//Invalide
        assertFalse(Date.isValidDate(1, 1, -1)); 
        assertFalse(Date.isValidDate(31, 12, 0));
        
    }
	
	@Test
    public void testLeapYear() {
        // Années bissextiles
        assertTrue(Date.isLeapYear(2020));
        assertTrue(Date.isLeapYear(2024));
        assertTrue(Date.isLeapYear(2000)); 
        
        // Pas bissextile
        assertFalse(Date.isLeapYear(1900)); 
        assertFalse(Date.isLeapYear(2023));
    }
	
	@Test
    public void testNextDate() {
		
        Date date = new Date(28, 2, 2024);
        
        //année bissextile
        Date nextDate = date.nextDate();
        assertEquals(new Date(29, 2, 2024), nextDate);

        // Dernier jour de l'année
        date = new Date(31, 12, 2024); 
        nextDate = date.nextDate();
        assertEquals(new Date(1, 1, 2025), nextDate); // Le jour suivant est le 1er janvier de l'année suivante
    }
	
	@Test
    public void testPreviousDate() {
		
        Date date = new Date(1, 3, 2024);
        Date previousDate = date.previousDate();
        assertEquals(new Date(29, 2, 2024), previousDate);

        date = new Date(1, 1, 2025);
        previousDate = date.previousDate();
        assertEquals(new Date(31, 12, 2024), previousDate);
	
	}
	
	@Test
    public void testCompareTo() {
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(1, 1, 2024);
        Date date3 = new Date(2, 1, 2024);
        Date date4 = new Date(1, 2, 2024);

        // Comparaison de dates identiques
        assertEquals(0, date1.compareTo(date2));

        // Comparaison de dates dans un ordre chronologique
        assertTrue(date1.compareTo(date3) < 0); 
        assertTrue(date4.compareTo(date1) > 0); 
        
        // Comparaison avec null (doit lancer une exception)
        assertThrows(NullPointerException.class, () -> date1.compareTo(null));
        
        //ajout après coverage (rouge)
        Date date5 = new Date(1, 1, 2024);  // 1er janvier 2024
        Date date6 = new Date(1, 1, 2025);  // 1er janvier 2025

        assertTrue(date5.compareTo(date6) < 0);

        assertTrue(date6.compareTo(date5) > 0);
    }
	
	
	//Test des méthodes supplémentaire (histoire d'avoir un jolie coverage)
	@Test
    public void testToString() {
        // Test de la méthode toString()
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(31, 12, 2024);
        Date date3 = new Date(9, 5, 2024);

        // Test que la méthode toString() retourne bien la date au format "jj/mm/aaaa"
        assertEquals("01/01/2024", date1.toString());
        assertEquals("31/12/2024", date2.toString());
        assertEquals("09/05/2024", date3.toString());

        // Test d'une date avec un jour et un mois à un chiffre
        Date date4 = new Date(1, 3, 2024);
        assertEquals("01/03/2024", date4.toString());
    }

    @Test
    public void testEquals() {
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(1, 1, 2024);
        Date date3 = new Date(2, 1, 2024);
        Date date4 = new Date(1, 1, 2025);

        // Test que deux dates identiques sont égales
        assertTrue(date1.equals(date2));

        // Test que deux dates différentes ne sont pas égales
        assertFalse(date1.equals(date3)); 
        assertFalse(date1.equals(date4)); 

        // Test avec un objet de type différent
        String notADate = "1/1/2024";
        assertFalse(date1.equals(notADate));
        
        // Test avec un objet null
        assertFalse(date1.equals(null)); 
        
        assertTrue(date1.equals(date1));
    }
        
}