package com.ToeicPreBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a User in the system.
 */

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

	@NotBlank
    @Column(nullable = false)
    private String username;

	@NotBlank
    @Column(nullable = false)
    private String password;

	@NotBlank
	@Column(nullable = false)
	private String nikName;

    @Column(nullable = true)
    private String googleId;

	@Column(nullable = true)
	private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role role;  

    @Column(nullable = true)
    private Boolean isActive = true;

}