package com.practice.order.interfaces.partner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.order.application.partner.PartnerFacade;
import com.practice.order.common.response.CommonResponse;
import com.practice.order.domain.partner.PartnerCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
	private final PartnerFacade partnerFacade;

	public CommonResponse registerPartner(final PartnerDto.RegisterRequest request) {
		val command  = request.toCommand();
		val partnerInfo = partnerFacade.registerPartner(command);
		val response = PartnerDto.RegisterResponse.builder()
			.partnerInfo(partnerInfo);
		return CommonResponse.success(response);
	}
}
