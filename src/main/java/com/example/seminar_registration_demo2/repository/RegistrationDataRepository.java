package com.example.seminar_registration_demo2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import com.example.seminar_registration_demo2.model.RegistrationData;

public interface RegistrationDataRepository
	extends CrudRepository<RegistrationData, Long> {
	
	@Modifying
	@Query("UPDATE RegistrationData SET nama = :nama, nim = :nim, email = :email, nomor_telepon = :nomor_telepon, id_line = :id_line, jurusan = :jurusan, fakultas = :fakultas, angkatan = :angkatan, nomor_kursi = :nomor_kursi WHERE id = :id")
	void updateRegistrationData(
			@Param("id") long id, 
			@Param("nama") String nama, 
			@Param("nim") long nim, 
			@Param("email") String email, 
			@Param("nomor_telepon") String nomor_telepon,
			@Param("id_line") String id_line,
			@Param("jurusan") String jurusan,
			@Param("fakultas") String fakultas,
			@Param("angkatan") String angkatan,
			@Param("nomor_kursi") long nomor_kursi);
}
