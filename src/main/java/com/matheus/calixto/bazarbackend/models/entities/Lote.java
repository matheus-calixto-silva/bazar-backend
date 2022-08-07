package com.matheus.calixto.bazarbackend.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "lote")
public class Lote {
  private int id;
  private int orgaoDonatario;

  @Column(name = "orgao_fiscalizador")
  private int orgaoFiscalizador;
  private int produto;

  @Column(name = "dthr_cad_lote", nullable = false, updatable = false)
  @CreationTimestamp  
  private LocalDateTime dthrCadLote = LocalDateTime.now();

  public Lote() {}

  public Lote(int id, int orgaoDonatario, int orgaoFiscalizador, int produto, LocalDateTime dthrCadLote) {
    this.id = id;
    this.orgaoDonatario = orgaoDonatario;
    this.orgaoFiscalizador = orgaoFiscalizador;
    this.produto = produto;
    this.dthrCadLote = dthrCadLote;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  public int getId() {
    return id;
  }

  public int setId(int id) {
    return this.id = id;
  }

  public int getOrgaoDonatario() {
    return orgaoDonatario;
  }

  public void setOrgaoDonatario(int orgaoDonatario) {
    this.orgaoDonatario = orgaoDonatario;
  }

  public int getOrgaoFiscalizador() {
    return orgaoFiscalizador;
  }

  public void setOrgaoFiscalizador(int orgaoFiscalizador) {
    this.orgaoFiscalizador = orgaoFiscalizador;
  }

  public int getProduto() {
    return produto;
  }

  public void setProduto(int produto) {
   this.produto = produto;
  }

  public LocalDateTime getDthrCadLote() {
    return dthrCadLote;
  }

  public void setDthrCadLote(LocalDateTime dthrCadLote) {
    this.dthrCadLote = dthrCadLote;
  }
}