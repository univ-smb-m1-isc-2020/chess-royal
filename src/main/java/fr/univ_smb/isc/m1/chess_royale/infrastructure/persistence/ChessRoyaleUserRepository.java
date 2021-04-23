package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChessRoyaleUserRepository extends JpaRepository<ChessRoyaleUser, Long> {

    ChessRoyaleUser findByUsername(String username);
    ChessRoyaleUser findById(long id);
}
