package com.d2d.creditCard.service;

import com.d2d.creditCard.dto.CreditCardRequest;
import com.d2d.creditCard.entity.CreditCard;
import com.d2d.creditCard.repo.CreditCardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CreditCardService {

    private CreditCardRepository creditCardRepository;

    public Optional<String> saveApplication(CreditCardRequest creditCardRequest) {
        try {
            var creditCard = new CreditCard();
            BeanUtils.copyProperties(creditCardRequest, creditCard);
            creditCard.setPublishStatus(false);
            creditCard.setRefId(RandomString.make(10));
            var creditCardSaved = creditCardRepository.save(creditCard);
            return Optional.of(creditCardSaved.getRefId());
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
