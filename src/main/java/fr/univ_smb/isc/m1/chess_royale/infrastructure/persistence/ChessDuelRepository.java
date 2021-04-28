package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessDuelRepository extends JpaRepository<ChessDuel, Long> {
        ChessDuel findById(long id);
}
