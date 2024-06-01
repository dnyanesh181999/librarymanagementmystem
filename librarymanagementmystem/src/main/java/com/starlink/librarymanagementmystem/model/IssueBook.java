package com.starlink.librarymanagementmystem.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueBook {
	
	private Integer bookId;
	private String bookName;
	private String bookAuthorName;
	private String bookType;
	private String bookDepartment;
	private Date bookIssueDate;
	private Date bookReturnDate;
	private Double penaltyfees;
}
