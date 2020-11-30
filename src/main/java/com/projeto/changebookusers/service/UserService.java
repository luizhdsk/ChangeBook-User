package com.projeto.changebookusers.service;

import com.projeto.changebookusers.domain.User;
import com.projeto.changebookusers.domain.data.UserResponse;
import com.projeto.changebookusers.domain.data.UserUpdateRequest;
import com.projeto.changebookusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        if (user != null){
            user.setHasPrivileges(false);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }else
            throw new RuntimeException("invalid data.");
    }
    public void updateUser(UserUpdateRequest userUpdate){
        if (userUpdate != null && existsUserById(userUpdate.getCpf())){
            var user = userRepository.findByCpf(userUpdate.getCpf());
            userUpdate.setPassword(user.getPassword());
            userRepository.save(userUpdate.toUser());
        }else
            throw new RuntimeException("invalid data.");
    }

    public UserResponse getUserById(String cpf){
        User user = userRepository.findByCpf(cpf);
        return UserResponse.builder()
                .userName(user.getUserName())
                .cpf(user.getCpf())
                .city(user.getCity())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

    public boolean existsUserById(String cpf){
        return userRepository.existsById(cpf);
    }

}
