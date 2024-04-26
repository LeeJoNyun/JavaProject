package com.practice.toyproject.service;

import com.practice.toyproject.dto.JoinDTO;
import com.practice.toyproject.entity.UserEntity;
import com.practice.toyproject.repsitory.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    private final UserRepository _userRepository;
    private final BCryptPasswordEncoder _bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder){
        _userRepository = userRepository;
        _bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void joinProcess(JoinDTO dto){
        String username = dto.getUsername();
        String password = dto.getPassword();

        Boolean isExist = _userRepository.existsByUsername(username);

        if (isExist){
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(_bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        _userRepository.save(data);
    }

}
