package com.engg.digitalorg.repository;

import com.engg.digitalorg.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CardRepository extends JpaRepository<Card, Integer> {
}
