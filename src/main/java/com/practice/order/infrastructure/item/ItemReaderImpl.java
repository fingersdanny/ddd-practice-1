package com.practice.order.infrastructure.item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.practice.order.common.exception.EntityNotFoundException;
import com.practice.order.domain.item.Item;
import com.practice.order.domain.item.ItemInfo;
import com.practice.order.domain.item.ItemReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {
    private final ItemRepository itemRepository;

    @Override
    public Item getItemBy(String itemToken) {
        return itemRepository.findByItemToken(itemToken)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<ItemInfo.ItemOptionGroupInfo> getItemOptionSeries(Item item) {
        var itemOptionGroupList = item.getItemOptionGroupList();
        return itemOptionGroupList.stream()
                .map(itemOptionGroup -> {
                    var itemOptionList = itemOptionGroup.getItemOptionList();
                    var itemOptionInfoList = itemOptionList.stream()
                            .map(ItemInfo.ItemOptionInfo::new)
                            .collect(Collectors.toList());

                    return new ItemInfo.ItemOptionGroupInfo(itemOptionGroup, itemOptionInfoList);
                }).collect(Collectors.toList());
    }
}
