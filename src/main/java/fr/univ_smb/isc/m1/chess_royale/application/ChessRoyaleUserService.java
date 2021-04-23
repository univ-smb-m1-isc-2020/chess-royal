package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserPrincipal;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class ChessRoyaleUserService implements UserDetailsService {

    @Autowired
    private ChessRoyaleUserRepository chessRoyaleUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        ChessRoyaleUser user = chessRoyaleUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ChessRoyaleUserPrincipal(user);
    }
}
