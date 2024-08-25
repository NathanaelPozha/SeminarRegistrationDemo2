package com.example.seminar_registration_demo2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.example.seminar_registration_demo2.model.ParticipantData;
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataDTO;
import com.example.seminar_registration_demo2.registrationdatadtomapper.ParticipantDataDTOMapper;
import com.example.seminar_registration_demo2.exceptions.ParticipantDataExceptions;
import com.example.seminar_registration_demo2.repository.ParticipantDataRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class ParticipantDataService {
	
	@Autowired
	private ParticipantDataRepository participantDataRepository;

	@Autowired
	private ParticipantDataDTOMapper participantDataDTOMapper;
	
	@Transactional
	public void updateParticipantData(
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
		
		participantDataRepository.updateParticipantData(
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
	
	public Page<ParticipantDataDTO> findDataWithPagination(int offset, int pagesize){
		Page<ParticipantData> registrationDataPage = participantDataRepository.findAll(PageRequest.of(offset, pagesize));
		List<ParticipantDataDTO> content = registrationDataPage.stream()
				.map(participantDataDTOMapper).collect(Collectors.toList());
		
		Page<ParticipantDataDTO> participantDataDTOPage = new PageImpl<>(
	            content,
	            PageRequest.of(offset, pagesize),
	            registrationDataPage.getTotalElements()
	    );

	    return participantDataDTOPage;
	}
	
	public ParticipantData findOneById(long id){
		return participantDataRepository.findById(id)
				.orElseThrow(() -> new ParticipantDataExceptions());
	}
}
