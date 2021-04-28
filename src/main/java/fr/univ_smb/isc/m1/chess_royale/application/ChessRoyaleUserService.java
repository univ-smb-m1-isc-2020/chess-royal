package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserDetails;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class ChessRoyaleUserService implements UserDetailsService {

    private final ChessRoyaleUserRepository userRepository;

    public ChessRoyaleUserService(ChessRoyaleUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<ChessRoyaleUser> user = userRepository.findByUsername(userName);

        if (user.isEmpty())
            throw new UsernameNotFoundException("Username not found : "+ userName);
        else
            return new ChessRoyaleUserDetails(user.get());
    }
}
