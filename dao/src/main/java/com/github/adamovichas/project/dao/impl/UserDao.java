package com.github.adamovichas.project.dao.impl;

import com.github.adamovichas.project.dao.IUserDao;
import com.github.adamovichas.project.dao.repository.UserRepository;
import com.github.adamovichas.project.entity.UserEntity;
import com.github.adamovichas.project.model.dto.UserDTO;
import com.github.adamovichas.project.util.EntityDtoViewConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;

public class UserDao implements IUserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    private final UserRepository repository;

    public UserDao(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        UserEntity userEntity = EntityDtoViewConverter.getEntity(userDTO);
        repository.save(userEntity);
    }


    @Override
    public UserDTO getUserByLogin(String login) {
        UserEntity userEntity = repository.findById(login).get();
        return EntityDtoViewConverter.getDTO(userEntity);
    }

    @Override
    public void deleteUser(String login) {
        final UserEntity userEntity = repository.findById(login).get();
        userEntity.setIsDeleted(true);
    }

    @Override
    public boolean updateUser(UserDTO user) {
        boolean result = false;
        UserEntity userEntity = repository.findById(user.getLogin()).get();
        setDTOfieldsToEntity(userEntity,user);
        result = true;
        return result;
    }

    private void setDTOfieldsToEntity(UserEntity userEntity, UserDTO userDTO){
        userEntity.setRole(userDTO.getRole());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setIsDeleted(userDTO.getIsDeleted());
    }
}
