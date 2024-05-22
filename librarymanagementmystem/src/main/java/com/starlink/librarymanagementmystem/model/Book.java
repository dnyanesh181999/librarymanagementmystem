package com.starlink.librarymanagementmystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	@NotEmpty(message = "Book Name required")
	private String bookName;
	@NotEmpty(message = "Book AuthorName required")
	private String bookAuthorName;
	@NotEmpty(message = "BookType Required")
	private String bookType;
	@NotEmpty(message = "Book department Required")
	private String bookDepartment;
	
	private Long bookAvalabilityNumber;
}
