package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//this is the child class becuase it is being  used by other classes.

@Entity
@Table(name="AM_PHONENUMBERS_DETAILS")
@Setter
@Getter
public class PhoneNumber implements Serializable {
@Id
@GeneratedValue
private Integer regNo;
private Long phoneNumber;
@Column(length=20)
private String numberType;
@Column(length=20)
private String provider;
//taking property forFK column of any db table is optional.
public PhoneNumber() {
	System.out.println("PhoneNumber-0 param constructor");
}
@Override
public String toString() {
	return "PhoneNumber [regNo=" + regNo + ", phoneNumber=" + phoneNumber + ", numberType=" + numberType + ", provider="
			+ provider + "]";
	//@ToString we can take but if any special property is there.That one also it involves.
}


}
