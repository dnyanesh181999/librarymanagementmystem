package com.starlink.librarymanagementmystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	@NotEmpty(message = "Name not be empty")
	private String adminName;
	@NotEmpty(message = "Password not be empty")
	private String adminPassword;
	@NotEmpty(message = "Enter the admin  conatct")
	private String adminContact;
	@Email(message = "Enter valid email address")
	private String adminEmail;
}
