package com.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartnerCommand {
	private String partnerName;
	private String businessNo;
	private String email;

	public Partner toEntity() {
		return Partner.builder()
			.partnerName(partnerName)
			.businessNo(businessNo)
			.email(email)
			.build();
	}
}
