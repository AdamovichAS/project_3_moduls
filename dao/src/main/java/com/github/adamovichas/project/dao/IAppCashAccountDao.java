package com.github.adamovichas.project.dao;

import com.github.adamovichas.project.model.dto.AppCashAccountDTO;

public interface IAppCashAccountDao {
    AppCashAccountDTO updateBalance(AppCashAccountDTO appCashAccountDTO);
}