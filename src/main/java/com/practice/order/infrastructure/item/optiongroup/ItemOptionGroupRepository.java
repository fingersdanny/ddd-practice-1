package com.practice.order.infrastructure.item.optiongroup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.order.domain.item.ItemOptionGroup;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}
