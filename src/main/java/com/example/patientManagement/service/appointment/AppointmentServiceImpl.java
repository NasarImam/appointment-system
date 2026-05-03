package com.example.patientManagement.service.appointment;
import com.example.patientManagement.modals.Appointment;
import com.example.patientManagement.modals.AppointmentStatus;
import com.example.patientManagement.modals.Doctor;
import com.example.patientManagement.modals.Patient;
import com.example.patientManagement.repository.AppointmentRepository;
import com.example.patientManagement.repository.DoctorRepository;
import com.example.patientManagement.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.patientManagement.modals.AppointmentStatus.COMPLETED;
import static com.example.patientManagement.modals.AppointmentStatus.SCHEDULED;
@Service

public class AppointmentServiceImpl implements AppointmentService{

   private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    public AppointmentServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository){
        this.patientRepository=patientRepository;
        this.doctorRepository=doctorRepository;
        this.appointmentRepository=appointmentRepository;
    }

    //Inside bookAppointment() — what do you check before saving? List the checks in order
    @Transactional
    @Override
    public Appointment bookAppointment(Long patientId, Long doctorId, LocalDateTime appointmentTime) {

        // check whether patient is available or not in the system and it will return optional<> which contain patient object
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("patient is not present"));

        if(appointmentTime.isBefore(LocalDateTime.now())){
            throw new RuntimeException("appointment time must be in future");
        }

        // check doctor is available or not in the system
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()-> new RuntimeException("doctor not found"));

        //Check if any appointment exists with: doctor_id + appointment_time
        boolean slotAvailable= appointmentRepository.existsByDoctor_IdAndAppointmentTime(doctorId,appointmentTime);
        if(slotAvailable){
            throw new RuntimeException("slot not available");
        }

        //create appointment object to book a appointment
        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .appointmentTime(appointmentTime)
                .appointmentStatus(SCHEDULED)
                .build();


        return appointmentRepository.save(appointment);
    }

    //Inside cancelAppointment() — what status must the appointment be in before you allow cancellation? What do you throw if it's not?
    @Override
    @Transactional
    public Appointment cancelAppointment(Long appointmentId) {

       // find and appointment first with appointment id
        //Fteching
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()-> new RuntimeException("appointment not found"));


        //validating
        if(!appointment.getAppointmentStatus().equals(SCHEDULED)){
            throw new RuntimeException("appointment can not be cancelled");
        }
        //updating
        appointment.setAppointmentStatus(AppointmentStatus.CANCELLED);


        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public Appointment completeAppointment(Long appointmentId) {

        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()-> new RuntimeException("appointment not found"));

        if(!appointment.getAppointmentStatus().equals(SCHEDULED)){

            throw new RuntimeException("appointment can not be completed");

        }
        appointment.setAppointmentStatus(COMPLETED);



        return appointmentRepository.save(appointment);

    }

    @Override
    public List<Appointment> getAllAppointmentByPatient(Long patientId) {

        return appointmentRepository.findAllByPatient_Id(patientId);
    }

    @Override
    public List<Appointment> getAllAppointmentByDoctor(Long doctorId) {
        return appointmentRepository.findAllByDoctor_Id(doctorId);
    }
}
