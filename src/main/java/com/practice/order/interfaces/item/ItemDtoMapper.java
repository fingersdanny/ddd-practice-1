package com.practice.order.interfaces.item;

import org.mapstruct.*;

import com.practice.order.domain.item.ItemCommand;
import com.practice.order.domain.item.ItemInfo;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ItemDtoMapper {

    // Build Tool (Gradle, Maven...)과 관계없이 Lombok의 annotationProcessor가 MapStruct의 annotationProcessor보다 먼저 와야 함
    // 아래처럼 이름이 동일하지 않은 경우에는 @Mapping을 통해서 정확하게 어디에 Mapping 시킬 건지 찾아 줘야함
    // 인스턴스 변수를 호출하듯이 객체의 인스턴스.필드 변수를 통해서 해당 속성의 source를 지정할 수 있음

    @Mappings({@Mapping(source = "request.itemOptionGroupList", target = "itemOptionGroupRequestList")})
    ItemCommand.RegisterItemRequest of(ItemDto.RegisterItemRequest request);

    @Mappings({@Mapping(source = "request.itemOptionList", target = "itemOptionRequestList")})
    ItemCommand.RegisterItemOptionGroupRequest of(ItemDto.RegisterItemOptionGroupRequest request);

    ItemCommand.RegisterItemOptionRequest of(ItemDto.RegisterItemOptionRequest request);

    ItemDto.RegisterResponse of(String itemToken);

    // retrieve
    ItemDto.Main of(ItemInfo.Main main);

    ItemDto.ItemOptionGroupInfo of(ItemInfo.ItemOptionGroupInfo itemOptionGroup);

    ItemDto.ItemOptionInfo of(ItemInfo.ItemOptionInfo itemOption);
}
