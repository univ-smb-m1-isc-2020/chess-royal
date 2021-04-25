package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChessRoyaleUserRepository extends JpaRepository<ChessRoyaleUser, Long> {

    @Query(" select u from ChessRoyaleUser u " +
            " where u.username = ?1")
    Optional<ChessRoyaleUser> findUserWithName(String username);
}
