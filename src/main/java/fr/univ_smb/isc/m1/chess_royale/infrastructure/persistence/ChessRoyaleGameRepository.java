package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChessRoyaleGameRepository extends JpaRepository<ChessRoyaleGame, Long> {

    List<ChessRoyaleGame> findByName(String name);
    ChessRoyaleGame findById(long id);
}
