package com.exam.chess.model;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testScanner(){
        Scanner scanner = new Scanner(System.in);

        String token = scanner.next();

        System.out.println(token);

    }

}