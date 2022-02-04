package com.sg.testing.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;

import org.junit.jupiter.api.Test;

public interface MonsterDaoTest {
    MonsterDao setUp();

    Monster MONSTER_1 = new Monster("Jane", MonsterType.LIZARDMAN, 10, "Waffles");
    Monster MONSTER_2 = new Monster("Peter", MonsterType.YETI, 1, "Pizza");

    @Test
    default void testAddGetMonster() {
        MonsterDao testDao = setUp();
        Monster addResult = testDao.addMonster(1, MONSTER_1);
        // check that testdao initailly does not contain any members
        assertNull(addResult, "Add Result should be null");

        Monster retrievedMonster = testDao.getMonster(1);
        assertEquals(MONSTER_1.getName(), retrievedMonster.getName(),
                String.format("Monster's name should be %s", MONSTER_1.getName()));
        assertEquals(MONSTER_1.getType(), retrievedMonster.getType(),
                String.format("Monster's type should be %s", MONSTER_1.getType()));
        assertEquals(MONSTER_1.getPeopleEaten(), retrievedMonster.getPeopleEaten(),
                String.format("Monster should have eater %d people", MONSTER_1.getPeopleEaten()));
        assertEquals(MONSTER_1.getFavoriteFood(), retrievedMonster.getFavoriteFood(),
                String.format("Monster's favorite food should be %s", MONSTER_1.getFavoriteFood()));
        assertEquals(MONSTER_1, testDao.getMonster(1),"Getting a monster should not remove it");

    }

    @Test
    default void testGetAllMonsters() {
        MonsterDao testDao = setUp();

        // assertNotNull(testDao.getAllMonsters(), "Empty DAO should not return null for
        // getAll.");

        testDao.addMonster(1, MONSTER_1);
        testDao.addMonster(2, MONSTER_2);

        List<Monster> allMonsters = testDao.getAllMonsters();

        // check list props
        assertNotNull(allMonsters, "List should not be null");
        assertEquals(2, allMonsters.size(), "There should only be 2 monsters in the list");

        // check items
        for (Monster monster : new Monster[] { MONSTER_1, MONSTER_2 }) {
            assertTrue(allMonsters.contains(monster), String.format("List should contain %s", monster.getName()));
        }

    }

    @Test
    default void testRemoveMonster() {
        MonsterDao testdao = setUp();

        testdao.addMonster(1, MONSTER_1);
        testdao.addMonster(2, MONSTER_2);

        Monster[] monsterArr = { MONSTER_1, MONSTER_2 };
        for (int i = 0; i < 2; i++) {
            int monsterID = i+1;
            Monster removedMonster = testdao.removeMonster(monsterID);
            String expectedMonsterName = monsterArr[i].getName();

            assertEquals(monsterArr[i], removedMonster,
                    String.format("Monster removed should be %s", expectedMonsterName));
            // List<Monster> allMonster = testdao.getAllMonsters();
            // //check getAll 
            // assertEquals(1 - i, allMonster.size(), String.format("There should be %d monsters left", 1-i));

            // assertFalse(allMonster.contains(monsterArr[i]),
            //         String.format("List should not contain %s", expectedMonsterName));
            // check get by id
            assertNull(testdao.getMonster(monsterID),String.format("Null expected for monster id %d", monsterID));
        }

    }

    @Test
    default void testUpdateMonster() {
        Random rng = new Random();
        MonsterDao testdao = setUp();
        int randID = rng.nextInt();

        testdao.addMonster(randID, MONSTER_1);
        testdao.updateMonster(randID, MONSTER_2);

        Monster updatedMonster = testdao.getMonster(randID);

        assertEquals(MONSTER_2, updatedMonster, "Monster stored should be Peter");

        // test updating at unassociated monster ID
        testdao.updateMonster(randID+10, MONSTER_2);
        assertNull(testdao.getMonster(randID+10), "Update should not add a new monster, should be null");

    }
}
