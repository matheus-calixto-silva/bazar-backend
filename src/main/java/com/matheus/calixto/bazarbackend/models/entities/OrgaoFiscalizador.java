package com.matheus.calixto.bazarbackend.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "orgao_fiscalizador")
public class OrgaoFiscalizador {
  private int id;
  private String description;
  private String image;

  public OrgaoFiscalizador() {}

  public OrgaoFiscalizador(int id, String description, String image) {
    this.id = id;
    this.description = description;
    this.image = image;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  public int getId() {
      return id;
  }

  public int setId(int id) {
      return this.id = id;
  }

  public String getDescription() {
		return description;
	}

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
		return image;
	}

  public void setImage(String image) {
    this.image = image;
  }

}