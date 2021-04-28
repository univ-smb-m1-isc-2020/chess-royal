package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessDuel;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleGame;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleParticipant;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static java.util.List.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ChessRoyaleControllerTest {

    private ChessRoyaleClientService ChessRoyaleClientService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.ChessRoyaleClientService = mock(ChessRoyaleClientService.class);
        this.mockMvc = standaloneSetup(new ChessRoyaleController(ChessRoyaleClientService)).build();
    }

    @Test
    void shouldPippoTwice() throws Exception {

        when(ChessRoyaleClientService.users())
                .thenReturn(of(
                        new ChessRoyaleUser("pipo-1", "test", "test token"),
                        new ChessRoyaleUser("pipo-2", "test", "test token")
                ));
        mockMvc.perform(get("/list-users"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"pipo-1\",\"pipo-2\"]"));
    }

    @Test
    void shouldReturnGamesThreeTimes() throws Exception {

        when(ChessRoyaleClientService.games())
                .thenReturn(of(
                        new ChessRoyaleGame("game1"),
                        new ChessRoyaleGame("game2"),
                        new ChessRoyaleGame("game3")
                ));

        mockMvc.perform(get("/list-games"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"game1\",\"game2\",\"game3\"]"));
    }

    @Test
    void shouldReturnParticipants() throws Exception {

        var user = new ChessRoyaleUser("toto", "test", "testToken");

        when(ChessRoyaleClientService.participants())
                .thenReturn(of(new ChessRoyaleParticipant(user)));

        mockMvc.perform(get("/list-participants"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"toto\"]"));
    }

    @Test
    void shouldReturn4duels() throws Exception {

        var duel1 = new ChessDuel();
        var duel2 = new ChessDuel();
        var duel3 = new ChessDuel();
        var duel4 = new ChessDuel();

        duel1.setId(1L);
        duel2.setId(2L);
        duel3.setId(3L);
        duel4.setId(4L);


        when(ChessRoyaleClientService.duels())
                .thenReturn(of(
                        duel1,
                        duel2,
                        duel3,
                        duel4));

        mockMvc.perform(get("/list-duels"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"1\",\"2\",\"3\",\"4\"]"));
    }
}