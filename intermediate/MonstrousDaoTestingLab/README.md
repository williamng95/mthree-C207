# Monstrous DAO testing

A number of different implementations for an interface is provided. Only one implementation is correct, the remainder contain some bugs.

This document serves to note down the different errors caught in the buggy implementations, and how the tests were setup.

## Test Setup

To enforce the DRY principle, and reuse the tests, we can defer to the [Junit5 user guide](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-interfaces-and-default-methods).

The suggested method to test interface contracts is as follows:
1. Setup a test interface containing common test cases for the contract.
2. Implement the test interface in the test class, thereby inheriting corresponding tests.

## Errors encountered

### DaoA
Did not assign the add monster ID correctly, leading to NullPointerException from the start.

### DaoB
Remove method not implemented correctly, DaoB's implementation simply gets the ID without removing.

### DaoC
`getAllMonster()` implemented incorrectly, always returns empty

### DaoD
`updateMonster()` adds a new monster if the update ID does not yet exist.

### DaoE
Getting a monster actually removes a monster; however this was initially masked as remove() does provide back the object at the provided ID. Simply calling `getMonster()` again reveals the issue.

### DaoF
Two issues:
- `getMonster()` overwrites existing with null: equivalent to removing.
- `getAllMonsters()` initializes with `Map.values`, but adds on to this by iterating through the Map again with `keySet()`. This results in twice the correct number of objects returned.