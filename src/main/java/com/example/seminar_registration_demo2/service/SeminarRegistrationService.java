package com.example.seminar_registration_demo2.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.seminar_registration_demo2.model.RegistrationData;
import com.example.seminar_registration_demo2.repository.RegistrationDataRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeminarRegistrationService {
	
	private final RegistrationDataRepository registrationDataRepository;
	
	@Autowired
	public SeminarRegistrationService(RegistrationDataRepository registrationDataRepository) {
		this.registrationDataRepository = registrationDataRepository;
	}
	
	public Iterable<RegistrationData> getAllRegistrationData(){
		return registrationDataRepository.findAll();
	}
	
	@Transactional
	public void updateRegistrationData(
			long id, 
			String nama, 
			long nim, 
			String email, 
			String nomor_telepon,
			String id_line,
			String jurusan,
			String fakultas,
			String angkatan,
			long nomor_kursi) {
		registrationDataRepository.updateRegistrationData(id, nama, nim, email, nomor_telepon, id_line, jurusan, fakultas, angkatan, nomor_kursi);
	}
}
