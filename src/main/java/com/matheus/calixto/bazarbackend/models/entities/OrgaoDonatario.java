package com.matheus.calixto.bazarbackend.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "orgao_donatario")
public class OrgaoDonatario {
  private int id;
  private String name;
  private String address;
  private String phone;
  private String openingHour;
  private String description;
  private String image;

  public OrgaoDonatario() {}

  public OrgaoDonatario(
    int id, 
    String name, 
    String address, 
    String phone,
    String openingHour,
    String description,
    String image) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.openingHour = openingHour;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getOpeningHour() {
    return openingHour;
  }

  public void setOpeningHour(String openingHour) {
    this.openingHour = openingHour;
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