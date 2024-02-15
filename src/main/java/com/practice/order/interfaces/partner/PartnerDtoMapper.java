package com.practice.order.interfaces.partner;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.practice.order.domain.partner.PartnerCommand;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PartnerDtoMapper {
	//target method(Source source);

	PartnerCommand of(PartnerDto.RegisterRequest request);

}
