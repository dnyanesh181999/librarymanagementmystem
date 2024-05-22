package com.starlink.librarymanagementmystem.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String studentName;
	private String studentEmail;
	private String studentContact;
	private String studentUserName;
	private String studentPassword;
	private Double totalPenaltyFees;
	@OneToMany(cascade = CascadeType.ALL)
	private List<IssueBook>issuebooks;

	@OneToOne(cascade = CascadeType.ALL)
	private Address studentAddress;
}
