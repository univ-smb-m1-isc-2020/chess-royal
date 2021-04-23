package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
@Slf4j
public class ChessRoyaleUserService implements UserDetailsService {
    private final ChessRoyaleUserRepository userRepository;
    @Autowired
    public ChessRoyaleUserService(ChessRoyaleUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        ChessRoyaleUser user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
