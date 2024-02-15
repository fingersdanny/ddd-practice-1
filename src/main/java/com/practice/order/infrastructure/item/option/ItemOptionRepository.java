package com.practice.order.infrastructure.item.option;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.order.domain.item.ItemOption;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}
