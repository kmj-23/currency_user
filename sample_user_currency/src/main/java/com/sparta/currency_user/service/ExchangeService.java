package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;

    public ExchangeResponseDto exchange(
            Long userId,
            BigDecimal amountInKrw,
            String currencyName
    ) {

        userRepository.findUserByIdOrElseThrow(userId);

        Currency currency = currencyRepository.findByCurrencyName(currencyName);

        BigDecimal amountAfterExchange = amountInKrw.divide(currency.getExchangeRate(), 2, RoundingMode.UP);

        Exchange exchange = new Exchange(amountInKrw, amountAfterExchange,"NORMAL"); // 상태를 나타낼때는 주로 대문자(?) EX. DELIVEVERED, ON_PROCESS..etc

        Exchange newExchange = exchangeRepository.save(exchange);

        return new ExchangeResponseDto(newExchange.getId(), amountAfterExchange, exchange.getStatus(), currencyName);
    }


    public List<ExchangeResponseDto> findAllExchangesByUserIdOrElseThrow(Long userId) {

        User findUser = userRepository.findUserByIdOrElseThrow(userId);

         List<ExchangeResponseDto> exchangeResponseDtoList = ExchangeRepository.findExchangeByUser(findUser);

         if(exchangeResponseDtoList.isEmpty()) { // == null이랑 무슨차이??
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "환전기록이 없습니다.");
         }
         return exchangeResponseDtoList;
    }

//    public ExchangeResponseDto cancelExchange(Long exchangeId) {
//
//    }
}
