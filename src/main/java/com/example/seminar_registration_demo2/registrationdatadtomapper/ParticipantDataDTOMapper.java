package com.example.seminar_registration_demo2.registrationdatadtomapper;

import org.springframework.stereotype.Component;
import java.util.function.Function;
import com.example.seminar_registration_demo2.model.ParticipantData;
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataDTO;

@Component
public class ParticipantDataDTOMapper implements Function<ParticipantData, ParticipantDataDTO> {
	@Override
	public ParticipantDataDTO apply(ParticipantData registrationdata) {
		return new ParticipantDataDTO(
				registrationdata.getId(),
				registrationdata.getNama(),
				registrationdata.getNim(),
				registrationdata.getEmail(),
				registrationdata.getNomorTelepon(),
				registrationdata.getIdLine(),
				registrationdata.getJurusan(),
				registrationdata.getFakultas(),
				registrationdata.getAngkatan(),
				registrationdata.getNomorKursi()
				);
			}
	}
