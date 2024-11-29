package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    static List<ExchangeResponseDto> findExchangeByUser(User findUser) {
        if (findUser == null) {
            throw new RuntimeException("존재하지 않는 사용자 입니다.");
        }
        return findExchangeByUser(findUser);
    }
}

