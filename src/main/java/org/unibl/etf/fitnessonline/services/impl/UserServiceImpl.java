package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.exceptions.ConflictException;
import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserDTO;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.EditUserRequest;
import org.unibl.etf.fitnessonline.models.requests.RegisterRequest;
import org.unibl.etf.fitnessonline.repositories.UserEntityRepository;
import org.unibl.etf.fitnessonline.services.MailService;
import org.unibl.etf.fitnessonline.services.ProgramService;
import org.unibl.etf.fitnessonline.services.UserService;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final MailService mailService;
    private final ProgramService programService;
    private final UserEntityRepository repository;

    public UserServiceImpl(ModelMapper modelMapper, MailService mailService, ProgramService programService, UserEntityRepository repository) {
        this.modelMapper = modelMapper;
        this.mailService = mailService;
        this.programService = programService;
        this.repository = repository;
    }

    public List<ProgramDTO> getAllProgramsByUserId(Integer id) {
        return programService.getAllProgramsByUserId(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(NotFoundException::new);
    }

    @Override
    public UserDTO findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), UserDTO.class);
    }

    @Override
    public void insert(RegisterRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent() || repository.findByUsername(request.getUsername()).isPresent()) {
            throw new ConflictException();
        }
        UserEntity userEntity = modelMapper.map(request, UserEntity.class);
        userEntity.setId(null);
        userEntity.setActivated(true);
        userEntity.setVerified(false);
        String verificationToken = generateVerificationToken();
        userEntity.setVerificationToken(verificationToken);
        mailService.sendVerificationEmail(userEntity.getEmail(), verificationToken);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(request.getPassword()));
        repository.saveAndFlush(userEntity);
    }

    @Override
    public void update(Integer id, EditUserRequest request) {
        Optional<UserEntity> user = repository.findById(id);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            userEntity.setFirstName(request.getFirstName());
            userEntity.setLastName(request.getLastName());
            userEntity.setCity(request.getCity());
            userEntity.setEmail(request.getEmail());
            if (request.getPassword() != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                userEntity.setPassword(encoder.encode(request.getPassword()));
            }
            if (request.getAvatar() != null) {
                userEntity.setAvatar(request.getAvatar());
            }
            repository.saveAndFlush(userEntity);
        }
    }

    public String verify(String email, String token) {
        Optional<UserEntity> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            return "Something went wrong...";
        } else {
            UserEntity userEntity = user.get();
            userEntity.setVerified(true);
            userEntity.setVerificationToken(null);
            repository.saveAndFlush(userEntity);
            return "Account verified successfully!";
        }
    }

    @Override
    public void sendNewVerificationMail(String username) {
        Optional<UserEntity> user = repository.findByUsername(username);
        if (user.isEmpty()) {
            return;
        } else {
            UserEntity userEntity = user.get();
            String verificationToken = generateVerificationToken();
            userEntity.setVerificationToken(verificationToken);
            mailService.sendVerificationEmail(userEntity.getEmail(), verificationToken);
            repository.saveAndFlush(userEntity);
        }
    }

    private String generateVerificationToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[16];
        secureRandom.nextBytes(tokenBytes);

        return new BigInteger(1, tokenBytes).toString(16);
    }

}
