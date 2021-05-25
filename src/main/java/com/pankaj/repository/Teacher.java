package com.pankaj.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

@Entity
@Table(name = "TEACHER")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
public class Teacher {

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	@Column(nullable = false, name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	/*
	 * @Column(name = "Name", nullable = true, length = 255) private String name;
	 * 
	 * @Column(name = "subject", nullable = true, length = 255) private String
	 * subject;
	 * 
	 * @Column(name = "DOB") private Date dob;
	 */
	@Version
	private Integer version;

}
