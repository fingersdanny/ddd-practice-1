package com.practice.order.infrastructure.partner;

import org.springframework.stereotype.Component;

import com.practice.order.common.exception.EntityNotFoundException;
import com.practice.order.domain.partner.Partner;
import com.practice.order.domain.partner.PartnerReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReaderImpl implements PartnerReader {
	private final PartnerRepository partnerRepository;

	@Override
	public Partner getPartner(String partnerToken) {
		return partnerRepository.findByPartnerToken(partnerToken).orElseThrow(EntityNotFoundException::new);
	}
}
