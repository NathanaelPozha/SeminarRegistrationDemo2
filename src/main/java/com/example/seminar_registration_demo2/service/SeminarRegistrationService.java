package com.example.seminar_registration_demo2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.example.seminar_registration_demo2.model.RegistrationData;
import com.example.seminar_registration_demo2.registrationdatadto.RegistrationDataDTO;
import com.example.seminar_registration_demo2.registrationdatadtomapper.RegistrationDataDTOMapper;
import com.example.seminar_registration_demo2.exceptions.SeminarRegistrationExceptions;
import com.example.seminar_registration_demo2.repository.RegistrationDataRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class SeminarRegistrationService {
	
	@Autowired
	private RegistrationDataRepository registrationDataRepository;

	@Autowired
	private RegistrationDataDTOMapper registrationDataDTOMapper;
	
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
		registrationDataRepository.findById(id)
	            .orElseThrow(() -> new SeminarRegistrationExceptions());
		
		registrationDataRepository.updateRegistrationData(
	    		 id,
	    		 nama,
	    		 nim,
	    		 email,
	    		 nomor_telepon,
	    		 id_line,
	    		 jurusan,fakultas,
	    		 angkatan,
	    		 nomor_kursi
	    		 );
	}
	
	public Page<RegistrationDataDTO> findDataWithPagination(int offset, int pagesize){
		Page<RegistrationData> registrationDataPage = registrationDataRepository.findAll(PageRequest.of(offset, pagesize));
		List<RegistrationDataDTO> content = registrationDataPage.stream()
				.map(registrationDataDTOMapper).collect(Collectors.toList());
		
		Page<RegistrationDataDTO> registrationDataDTOPage = new PageImpl<>(
	            content,
	            PageRequest.of(offset, pagesize),
	            registrationDataPage.getTotalElements()
	    );

	    return registrationDataDTOPage;
	}
	
	public RegistrationData findOneById(long id){
		return registrationDataRepository.findById(id)
				.orElseThrow(() -> new SeminarRegistrationExceptions());
	}
}
