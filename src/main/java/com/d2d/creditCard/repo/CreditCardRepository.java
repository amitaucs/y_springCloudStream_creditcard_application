package com.d2d.creditCard.repo;

import com.d2d.creditCard.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    List<CreditCard> findByPublishStatus(boolean isPublished);
}
