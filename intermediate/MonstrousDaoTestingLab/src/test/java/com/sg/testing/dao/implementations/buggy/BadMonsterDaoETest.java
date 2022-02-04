package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.MonsterDaoTest;

public class BadMonsterDaoETest implements MonsterDaoTest {

    @Override
    public MonsterDao setUp() {
        return new BadMonsterDaoE();
    }

}
