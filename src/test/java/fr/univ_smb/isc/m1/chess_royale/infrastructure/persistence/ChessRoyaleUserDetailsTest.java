package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    void should_return_permissions() {
        var auth = chessRoyaleUserDetailsTest.getAuthorities();
        var expected = new ArrayList<SimpleGrantedAuthority>();
        expected.add(new SimpleGrantedAuthority("USER"));

        assertEquals(expected, auth);
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