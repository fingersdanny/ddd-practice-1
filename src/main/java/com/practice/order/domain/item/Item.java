package com.practice.order.domain.item;

import java.util.List;

import com.google.common.collect.Lists;
import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.common.util.TokenGenerator;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "items")
public class Item {
	private static final String PREFIX_ITEM = "itm_";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String itemToken;
	private Long partnerId;
	private String itemName;
	private Long itemPrice;

	// Item : ItemOptionGroup = 1 : N

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
	private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();

	@Enumerated(EnumType.STRING)
	private Status status;

	@Builder
	public Item(Long partnerId, String itemName, Long itemPrice) {
		if (partnerId == null)
			throw new InvalidParamException();
		if (StringUtils.isEmpty(itemName))
			throw new InvalidParamException();
		if (itemPrice == null)
			throw new InvalidParamException();

		this.itemToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_ITEM);
		this.partnerId = partnerId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.status = Status.PREPARE;
	}

	public void changePrepare() {
		this.status = Status.PREPARE;
	}

	public void changeOnSales() {
		this.status = Status.ON_SALES;
	}

	public void endOfSales() {
		this.status = Status.END_OF_SALES;
	}

	@Getter
	@RequiredArgsConstructor
	public enum Status {
		PREPARE("판매준비중"),
		ON_SALES("판매중"),
		END_OF_SALES("판매종료");

		private final String description;
	}
}
