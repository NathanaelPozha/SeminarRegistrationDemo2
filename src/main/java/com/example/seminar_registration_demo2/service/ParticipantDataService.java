package com.example.seminar_registration_demo2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.example.seminar_registration_demo2.model.ParticipantData;
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataDTO;
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataResponse;
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
	
	public ParticipantDataDTO findOneById(long id){
		return participantDataRepository.findById(id)
				.map(participantDataDTOMapper)
				.orElseThrow(() -> new ParticipantDataExceptions());
	}
	
	public ParticipantDataResponse getAllParticipant(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<ParticipantData> participantsData = participantDataRepository.findAll(pageable);
		
		List<ParticipantData> listOfParticipantData = participantsData.getContent();
		List<ParticipantDataDTO> content = listOfParticipantData.stream()
	            .map(participantDataDTOMapper)
	            .collect(Collectors.toList());
		
		ParticipantDataResponse participantDataResponse = new ParticipantDataResponse();
		participantDataResponse.setParticipantContent(content);
		participantDataResponse.setPageNo(participantsData.getNumber());
		participantDataResponse.setPageSize(participantsData.getSize());
		participantDataResponse.setTotalElements(participantsData.getTotalElements());
		participantDataResponse.setTotalPages(participantsData.getTotalPages());
		participantDataResponse.setLastPage(participantsData.isLast());
		
		return participantDataResponse;
	}
}
