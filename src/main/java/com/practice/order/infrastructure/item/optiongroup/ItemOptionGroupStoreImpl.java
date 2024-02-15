package com.practice.order.infrastructure.item.optiongroup;

import org.springframework.stereotype.Component;

import com.practice.order.domain.item.ItemOptionGroup;
import com.practice.order.domain.item.ItemOptionGroupStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionGroupStoreImpl implements ItemOptionGroupStore {

    private final ItemOptionGroupRepository itemOptionGroupRepository;

    @Override
    public ItemOptionGroup store(ItemOptionGroup itemOptionGroup) {
        return itemOptionGroupRepository.save(itemOptionGroup);
    }
}
