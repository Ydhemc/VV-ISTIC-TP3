# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1.
    Cette assertion echoue à cause de l'approximation causé par la representation utiliser pour le stockages des nombres Réelle (double, float).
    Cette approximation fait donc que le resultats de l'operations tend vers 1.2 mais n'est pas 1.2.
    On devra donc utiliser une valeur de tolérence.
    
    float ValeurAttendu = 1.2;
    float Resultat = 3*0.4;
    double epsilon = 1e-10 ; //approximation max 
    assertTrue(Math.abs(ValeurAttendu - Resultat) < epsilon);

2.
    assertEquals :
        - Utilise la méthode .equals() des objets.

    assertSame :
        - Compare les references (avec ==).
    //Resultat similaire
    @Test
    public void testEqualsAndSame_sameObject() {
        String str1 = "Test";
        String str2 = str1; 
        assertEquals(str1, str2);
        assertSame(str1, str2);
    }

    //Resultat non similaire
    @Test
    public void testEqualsAndSame_sameObject() {
        String str1 = "Test";
        String str2 = "Test";
        assertEquals(str1, str2);
        assertSame(str1, str2);
    }

3.
    On peut se servir de fail pour pour pré-etablir une classe de test utilisant un objet pas encore implémenter.

    fail("Test non encore implémenté");

4.
    Cette fonctionnalité de Junit5 permet ainsi de faire des tests plus riches et plus lisible, ce qui permet une meilleur maintenabilité.