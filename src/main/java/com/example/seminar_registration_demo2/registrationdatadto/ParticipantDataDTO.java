package com.example.seminar_registration_demo2.registrationdatadto;

public record ParticipantDataDTO (
	long id,
	String nama,
	long nim,
	String email,
	String nomor_telepon,
	String id_line,
	String jurusan,
	String fakultas,
	String angkatan,
	long nomor_kursi
) {
	
	public long getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public long getNim() {
		return nim;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNomorTelepon() {
		return nomor_telepon;
	}
	
	public String getIdLine() {
		return id_line;
	}
	
	public String getJurusan() {
		return jurusan;
	}
	
	public String getFakultas() {
		return fakultas;
	}
	
	public String getAngkatan() {
		return angkatan;
	}
	
	public long getNomorKursi() {
		return nomor_kursi;
	}
	
}
