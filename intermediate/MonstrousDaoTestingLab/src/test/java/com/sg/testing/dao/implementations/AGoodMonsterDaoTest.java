package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.MonsterDaoTest;

public class AGoodMonsterDaoTest implements MonsterDaoTest {

    @Override
    public MonsterDao setUp() {
        return new AGoodMonsterDao();
    }

}
