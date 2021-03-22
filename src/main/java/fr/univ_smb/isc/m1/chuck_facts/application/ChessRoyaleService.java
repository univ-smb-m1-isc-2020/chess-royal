package fr.univ_smb.isc.m1.chuck_facts.application;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessRoyaleService {

    public List<ChessRoyale> facts() {
        return List.of(new ChessRoyale("Chuck Norris once lost his wedding ring....since then it's been war in Middle Earth"));
    }

}
