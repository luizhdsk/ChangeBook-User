package com.projeto.changebookusers.service;

import com.projeto.changebookusers.domain.User;
import com.projeto.changebookusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeBookDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ChangeBookDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        if (userRepository.existsById(cpf)){
            User changeBookUser = userRepository.findByCpf(cpf);

            List<GrantedAuthority> role_user = AuthorityUtils.createAuthorityList("ROLE_USER");

            return new org.springframework.security.core.userdetails.User(changeBookUser.getCpf(), changeBookUser.getPassword(), role_user);

        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
