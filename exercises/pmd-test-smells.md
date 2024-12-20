# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

- Test smells implémentés par les règles PMD

    En analysant la documentation, les règles PMD permettent d’identifier plusieurs test tel que:

    - L'absence ou le manque de clarté des assertions dans les tests.
    - Les dépendance à des configurations ou données externes non déclarées.
    - Utilisation excessive de configurations globales inutilisées.

- Utilisation d'une règle PMD

    - J’ai utilisé la règle JUnitTestsShouldIncludeAssert qui a permis d’identifier le test smell Assertion Roulette, où des tests manquent d'assertions claires pour diagnostiquer les échecs.

- Amélioration
    - Pour corriger ce test smell, il est recommandé d’ajouter des assertions explicites et des messages descriptifs afin de rendre les tests plus lisibles et faciles à maintenir.
    
