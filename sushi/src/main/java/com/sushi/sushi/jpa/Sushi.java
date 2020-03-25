package com.sushi.sushi.jpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUSHI")

public class Sushi {

  private @Id @GeneratedValue Long id;
  private String type;
  private Date expirationDate;
    
}