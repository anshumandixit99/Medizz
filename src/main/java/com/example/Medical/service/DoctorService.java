package com.example.Medical.service;

import com.example.Medical.DTO.DoctorSearchDTO;
import com.example.Medical.DTO.DoctorSignupDTO;
import com.example.Medical.Specification.DoctorSpecification;
import com.example.Medical.entity.Doctor;
import com.example.Medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> searchDoctors(DoctorSearchDTO request){

        Specification<Doctor> spec = Specification.where(DoctorSpecification.hasSpecialization(request.getSpecialization()))
                .and(DoctorSpecification.hasLocation(request.getCity(), request.getLocality()))
                .and(DoctorSpecification.hasAvailability(request.getAvailableOption(), request.getChosenDate()))
                .and(DoctorSpecification.hasExperience(request.getMinExperience()))
                .and(DoctorSpecification.hasFeeRange(request.getMinFee(), request.getMaxFee()))
                .and(DoctorSpecification.hasRating(request.getMinRating()))
                .and(DoctorSpecification.hasGender(request.getGender()))
                .and(DoctorSpecification.treatsSymptoms(request.getSymptoms()))
                .and(DoctorSpecification.worksAtClinic(request.getClinicName()))
                .and(DoctorSpecification.isAvailable(request.getAvailable()))
                .and(DoctorSpecification.hasConsultationType(request.getConsultationType()));
        return doctorRepository.findAll(spec);
    }

    public Doctor signupDoctor(DoctorSignupDTO doctorSignupDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorSignupDTO.getName());
        doctor.setSpecialization(doctorSignupDTO.getSpecialization());
        doctor.setCity(doctorSignupDTO.getCity());
        doctor.setLocality(doctorSignupDTO.getLocality());
        doctor.setExperience(doctorSignupDTO.getExperience());
        doctor.setFee(doctorSignupDTO.getFee());
        doctor.setRating(doctorSignupDTO.getRating());
        doctor.setGender(doctorSignupDTO.getGender());
        doctor.setSymptoms(doctorSignupDTO.getSymptoms());
        doctor.setClinicName(doctorSignupDTO.getClinicName());
        doctor.setAvailable(doctorSignupDTO.getAvailable());
        doctor.setConsultationType(doctorSignupDTO.getConsultationType());
        doctor.setAvailabilityTime(doctorSignupDTO.getAvailabilityTime());

        return doctorRepository.save(doctor);
    }
}
