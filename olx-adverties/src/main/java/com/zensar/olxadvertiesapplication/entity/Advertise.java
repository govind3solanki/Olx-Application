package com.zensar.olxadvertiesapplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertise")
public class Advertise {

	@Id
	private long Id;
	private String title;
	private int price;
	private String category;
	private String description;
	private String username;
	private String createdDate;
	private String modifiedDate;
	private String status;

}

