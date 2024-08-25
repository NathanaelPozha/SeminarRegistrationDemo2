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
	
	private ParticipantDataRepository participantDataRepository;
	private ParticipantDataDTOMapper participantDataDTOMapper;
	
	@Autowired
	public ParticipantDataService(ParticipantDataRepository participantDataRepository, ParticipantDataDTOMapper participantDataDTOMapper) {
		this.participantDataRepository = participantDataRepository;
		this.participantDataDTOMapper = participantDataDTOMapper;
	}
	
	@Transactional
	public void updateParticipantData(ParticipantDataDTO participantDataDTO) {
		
		participantDataRepository.updateParticipantData(
	    		 participantDataDTO.getId(),
	    		 participantDataDTO.getNama(),
	    		 participantDataDTO.getNim(),
	    		 participantDataDTO.getEmail(),
	    		 participantDataDTO.getNomorTelepon(),
	    		 participantDataDTO.getIdLine(),
	    		 participantDataDTO.getJurusan(),
	    		 participantDataDTO.getFakultas(),
	    		 participantDataDTO.getAngkatan(),
	    		 participantDataDTO.getNomorKursi()
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
	
	public ParticipantDataDTO findOneById(long id){
		return participantDataRepository.findById(id)
				.map(participantDataDTOMapper)
				.orElseThrow(() -> new ParticipantDataExceptions());
	}
}
