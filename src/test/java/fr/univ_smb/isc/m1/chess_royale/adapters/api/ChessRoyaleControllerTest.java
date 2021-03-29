package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyale;
import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.List.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ChessRoyaleControllerTest {

    private ChessRoyaleService ChessRoyaleService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.ChessRoyaleService = mock(ChessRoyaleService.class);
        this.mockMvc = standaloneSetup(new ChessRoyaleController(ChessRoyaleService)).build();
    }

    @Test
    public void shouldPippoTwice() throws Exception {

        when(ChessRoyaleService.facts())
                .thenReturn(of(new ChessRoyale("pipo-1"), new ChessRoyale("pipo-2")));

        mockMvc.perform(get("/chess-royale"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"pipo-1\",\"pipo-2\"]"));
    }
}