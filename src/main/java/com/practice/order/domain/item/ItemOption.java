package com.practice.order.domain.item;

import org.apache.commons.lang3.StringUtils;

import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.domain.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_options")
public class ItemOption extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "item_option_group_id")
	private ItemOptionGroup itemOptionGroup;
	private Integer ordering;
	private String itemOptionName;
	private Long itemOptionPrice;

	@Builder
	public ItemOption(
		ItemOptionGroup itemOptionGroup,
		Integer ordering,
		String itemOptionName,
		Long itemOptionPrice
	) {
		if (itemOptionGroup == null) throw new InvalidParamException("ItemOption.itemOptionGroup");
		if (ordering == null) throw new InvalidParamException("ItemOption.ordering");
		if (StringUtils.isBlank(itemOptionName)) throw new InvalidParamException("ItemOption.itemOptionName");
		if (itemOptionPrice == null) throw new InvalidParamException("ItemOption.itemOptionPrice");

		this.itemOptionGroup = itemOptionGroup;
		this.ordering = ordering;
		this.itemOptionName = itemOptionName;
		this.itemOptionPrice = itemOptionPrice;
	}
}
