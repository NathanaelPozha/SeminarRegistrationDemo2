package com.example.seminar_registration_demo2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.seminar_registration_demo2.model.ParticipantData;

public interface ParticipantDataRepository
	extends JpaRepository<ParticipantData, Long> {
	
	@Modifying
	@Query("UPDATE ParticipantData SET nama = :nama, nim = :nim, email = :email, nomor_telepon = :nomor_telepon, id_line = :id_line, jurusan = :jurusan, fakultas = :fakultas, angkatan = :angkatan, nomor_kursi = :nomor_kursi WHERE id = :id")
	void updateParticipantData(
			long id, 
			String nama, 
			long nim, 
			String email, 
			String nomor_telepon, 
			String id_line, 
			String jurusan, 
			String fakultas, 
			String angkatan, 
			long nomor_kursi);
}
