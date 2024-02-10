package com.practice.order.domain.partner;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
	private final PartnerStore partnerStore;
	private final PartnerReader partnerReader;
	@Override
	public PartnerInfo registerPartner(PartnerCommand command) {
		// 1. command -> initPartner
		// 2. initPartner save to DB
		// 3. Partner -> PartnerInfo AND return

		val initPartner = command.toEntity();
		Partner partner = partnerStore.store(initPartner);
		return PartnerInfo.builder()
			.partner(partner)
			.build();
	}

	@Override
	public PartnerInfo getPartnerInfo(String partnerToken) {
		// 1. partnerToken -> Partner
		// Partner -> Partner AND return

		Partner partner = partnerReader.getPartner(partnerToken);
		return PartnerInfo.builder()
			.partner(partner)
			.build();
	}

	@Override
	public PartnerInfo enablePartner(String partnerToken) {
		// 1. partnerToken -> Partner
		// 2. partner.enable()

		Partner partner = partnerReader.getPartner(partnerToken);
		partner.enable();
		return PartnerInfo.builder()
			.partner(partner)
			.build();
	}

	@Override
	public PartnerInfo disablePartner(String partnerToken) {
		// 1. partnerToken -> Partner
		// 2. partner.disable()

		Partner partner = partnerReader.getPartner(partnerToken);
		partner.disable();
		return PartnerInfo.builder()
			.partner(partner)
			.build();
	}
}
