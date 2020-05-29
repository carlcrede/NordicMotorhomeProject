package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MotorhomeMapperTest {

    @Test
    void selectAllStatement() {
    }


    @Test
    void loadEntity() {
        MotorhomeMapper motorhomeMapper = new MotorhomeMapper();
        ArrayList<DomainEntity> actual = motorhomeMapper.readAll();
        assertNotNull(actual);
        assertEquals(21,actual.size());
        System.out.println(actual.size());

    }
}