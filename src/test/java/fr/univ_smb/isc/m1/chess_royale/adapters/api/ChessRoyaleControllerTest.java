package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
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
}