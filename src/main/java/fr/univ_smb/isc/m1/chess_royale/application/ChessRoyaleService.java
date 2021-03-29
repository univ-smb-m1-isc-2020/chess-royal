package fr.univ_smb.isc.m1.chess_royale.application;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessRoyaleService {

    public List<ChessRoyale> facts() {
        return List.of(new ChessRoyale("Chuck Norris threw a grenade and killed 50 people, then it exploded."));
    }

}
