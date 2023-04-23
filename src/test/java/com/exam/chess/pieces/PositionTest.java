package com.exam.chess.pieces;

import org.junit.jupiter.api.Test;

import static com.exam.chess.pieces.Position.position;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void testEquals(){
        Position position1 = position(0, 1);
        Position position2 = position(0, 1);
        Position position3 = position(1, 1);

        assertEquals(true, position1.equals(position2));
        assertEquals(false, position1.equals(position3));
        assertEquals(false, position2.equals(position3));
    }

}