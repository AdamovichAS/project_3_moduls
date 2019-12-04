package com.github.adamovichas.project.dao.impl;

import com.github.adamovichas.project.dao.ICashAccountDao;
import com.github.adamovichas.project.dao.repository.CashAccountRepository;
import com.github.adamovichas.project.entity.CashAccountEntity;
import com.github.adamovichas.project.model.dto.CashAccountDTO;
import com.github.adamovichas.project.util.EntityDtoViewConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CashAccountDao implements ICashAccountDao {

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    private final CashAccountRepository repository;

    public CashAccountDao(CashAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean create(String login) {
        boolean result = false;
        CashAccountEntity cashAccountEntity = new CashAccountEntity();
        cashAccountEntity.setValue(0);
        cashAccountEntity.setLogin(login);
        repository.save(cashAccountEntity);
        result =true;
//        try {
//            session.getTransaction().begin();
//            UserEntity userEntity = session.get(UserEntity.class, login);
//            userEntity.setRole(Role.USER_VER);
//                cashAccountEntity.setUserEntity(userEntity);
//                userEntity.setMoney(cashAccountEntity);
//
//            session.save(cashAccountEntity);
//            session.getTransaction().commit();
//            result = true;
//        }catch (RollbackException | NullPointerException | IdentifierGenerationException e){
//            log.error("create exception Login - {}", login);
//            session.getTransaction().rollback();
//        }finally {
//            session.close();
//        }
        return result;
    }

    @Override
    public CashAccountDTO getMoneyByLogin(String login) {
        final CashAccountEntity one = repository.getOne(login);
        return  EntityDtoViewConverter.getDTO(one);
    }

    @Override
    public boolean updateMoneyValue(CashAccountDTO cashAccountDTO) {
//        Session session = repository.getSession();
//        try {
//            session.getTransaction().begin();
//            final CashAccountEntity cashAccountEntity = session.find(CashAccountEntity.class, money.getUserlogin());
//            cashAccountEntity.setValue(money.getValue());
//            session.getTransaction().commit();
//            return true;
//        }catch (RollbackException e){
//            log.error("updateMoney exception Login - {}", money);
//            session.getTransaction().rollback();
//        }finally {
//            session.close();
//        }
        final CashAccountEntity entity = repository.getOne(cashAccountDTO.getLogin());
        entity.setValue(cashAccountDTO.getValue());
        return true;
    }
}