package com.example.seminar_registration_demo2.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "participant_data")
public class ParticipantData{
	
	@Id
	private long id;
	
	private String nama;
	private long nim;
	private String email;
	private String nomor_telepon;
	private String id_line;
	private String jurusan;
	private String fakultas;
	private String angkatan;
	private long nomor_kursi;
	
	public ParticipantData() {
		
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setNama (String nama) {
		this.nama = nama;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNim (long nim) {
		this.nim = nim;
	}
	
	public long getNim() {
		return nim;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNomorTelepon (String nomor_telepon) {
		this.nomor_telepon = nomor_telepon;
	}
	
	public String getNomorTelepon() {
		return nomor_telepon;
	}
	
	public void setIdLine(String id_line) {
		this.id_line = id_line;
	}
	
	public String getIdLine() {
		return id_line;
	}
	
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	
	public String getJurusan() {
		return jurusan;
	}
	
	public void setFakultas(String fakultas) {
		this.fakultas = fakultas;
	}
	
	public String getFakultas() {
		return fakultas;
	}
	
	public void setAngkatan(String angkatan) {
		this.angkatan = angkatan;
	}
	
	public String getAngkatan() {
		return angkatan;
	}
	
	public void setNomorKursi(long nomor_kursi) {
		this.nomor_kursi = nomor_kursi;
	}
	
	public long getNomorKursi() {
		return nomor_kursi;
	}
	
}
