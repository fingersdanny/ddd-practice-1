package com.practice.order.application.partner;

import org.springframework.stereotype.Service;

import com.practice.order.domain.notification.NotificationService;
import com.practice.order.domain.partner.Partner;
import com.practice.order.domain.partner.PartnerCommand;
import com.practice.order.domain.partner.PartnerInfo;
import com.practice.order.domain.partner.PartnerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
	private final PartnerService partnerService;
	private final NotificationService notificationService;

	public PartnerInfo registerPartner(PartnerCommand command) {
		val partnerInfo = partnerService.registerPartner(command);
		notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
		return partnerInfo;
	}
}
