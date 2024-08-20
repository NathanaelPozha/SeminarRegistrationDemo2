package com.example.seminar_registration_demo2.registrationdatadtomapper;

import org.springframework.stereotype.Component;
import java.util.function.Function;
import com.example.seminar_registration_demo2.model.RegistrationData;
import com.example.seminar_registration_demo2.registrationdatadto.RegistrationDataDTO;

@Component
public class RegistrationDataDTOMapper implements Function<RegistrationData, RegistrationDataDTO> {
	@Override
	public RegistrationDataDTO apply(RegistrationData registrationdata) {
		return new RegistrationDataDTO(
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
