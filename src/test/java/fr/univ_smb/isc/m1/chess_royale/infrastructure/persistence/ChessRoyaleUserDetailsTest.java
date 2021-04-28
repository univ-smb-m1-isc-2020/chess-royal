package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessRoyaleUserDetailsTest {

    private ChessRoyaleUserDetails chessRoyaleUserDetailsTest;
    private ChessRoyaleUser userTest;


    @BeforeEach
    public void setup() throws Exception {
        this.userTest =  new ChessRoyaleUser("NomTest", "none","token");
        this.chessRoyaleUserDetailsTest = new ChessRoyaleUserDetails(userTest);
    }

    @Test
    void getPassword() {
        userTest.setPassword("newPassword");
        assertEquals("newPassword",chessRoyaleUserDetailsTest.getPassword());
    }

    @Test
    void getUsername() {
        assertEquals(userTest.getUsername(), chessRoyaleUserDetailsTest.getUsername());
    }

    @Test
    void isAccountNonExpired(){
        assertTrue(chessRoyaleUserDetailsTest.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked(){
        assertTrue(chessRoyaleUserDetailsTest.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired(){
        assertTrue(chessRoyaleUserDetailsTest.isCredentialsNonExpired());
    }

    @Test
    void isEnabled(){
        assertTrue(chessRoyaleUserDetailsTest.isEnabled());
    }

}