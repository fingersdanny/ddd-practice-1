package com.practice.order.domain.item;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.domain.AbstractEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_option_groups")
public class ItemOptionGroup extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	// 연결 테이블 없이 생성 되게끔 도와줌
	@JoinColumn(name = "item_id")
	private Item item;
	private Integer ordering;
	private String itemOptionGroupName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = CascadeType.PERSIST)
	private List<ItemOption> itemOptionList = Lists.newArrayList();

	@Builder
	public ItemOptionGroup(Item item, Integer ordering, String itemOptionGroupName) {
		if (item == null) throw new InvalidParamException("ItemOptionGroup.item");
		if (ordering == null) throw new InvalidParamException("ItemOptionGroup.ordering");
		if (StringUtils.isBlank(itemOptionGroupName))
			throw new InvalidParamException("ItemOptionGroup.itemOptionGroupName");

		this.item = item;
		this.ordering = ordering;
		this.itemOptionGroupName = itemOptionGroupName;
	}

	public ItemOptionGroup addItemOption(ItemOption itemOption) {
		this.itemOptionList.add(itemOption);
		return this;
	}
}
