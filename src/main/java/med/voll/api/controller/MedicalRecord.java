package med.voll.api.controller;

import med.voll.api.address.DataAddress;
import med.voll.api.medico.Speciality;

public record MedicalRecord(String name, String email, String crm, Speciality speciality, DataAddress address) {
}
