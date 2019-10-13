package com.github.adamovichas.data.impl;

import com.github.adamovichas.data.impl.DataUserService;
import com.github.adamovichas.mysql_data.impl.DataUser;
import com.github.adamovichas.user.User;
import com.github.adamovichas.user.UserCreater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DataUserServiceTest {

    @Mock
    public DataUser dataUser;

    @Mock
    public UserCreater userCreater;

    @InjectMocks
    public DataUserService dataUserService;

    @BeforeEach
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginIsExist(){
        String login = "test";
        when(dataUser.loginIsExist(login)).thenReturn(login);
        boolean isExist = dataUserService.loginIsExist(login);
        assertTrue(isExist);
    }

    @Test
    public void userIsExist(){
        List<String>logPas = new ArrayList<>(Arrays.asList("login","password"));
        when(dataUser.userIsExist(logPas.get(0),logPas.get(1))).thenReturn(logPas);
        boolean isExist = dataUserService.userIsExist(logPas.get(0), logPas.get(1));
        assertTrue(isExist);
    }

  /*  @Test
    public void addNewUser(){
        Map<String,String>userFields = new HashMap<>();
        userFields.put("login","login");
        userFields.put("password","password");
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        when(userCreater.createUser(userFields)).thenReturn(user);
        when(dataUser.addUser(user)).thenReturn(true);
        boolean addNewUser = dataUserService.addNewUser(userFields);
        assertTrue(addNewUser);
    }

    @Test
    public void getUserByLogin(){
        String login = "login";
        User user = new User();
        user.setLogin(login);
        dataUserService.getUserByLogin(login);
        verify(dataUser,times(1)).addUser(user);

    }*/
}
