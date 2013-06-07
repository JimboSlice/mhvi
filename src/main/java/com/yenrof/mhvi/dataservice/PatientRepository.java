package com.yenrof.mhvi.dataservice;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.yenrof.mhvi.model.*;


@ApplicationScoped
public class PatientRepository { 

    @Inject
    private EntityManager em;
    
    @Inject
    private Logger log;


    public Patient findById(Long id) {
        return em.find(Patient.class, id);
    }

    public Patient findBySsn(String ssn) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
        Root<Patient> Patient = criteria.from(Patient.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(Patient).where(cb.equal(Patient.get(Patient_.name), ssn));
        criteria.select(Patient).where(cb.equal(Patient.get("ssn"), ssn));
        return em.createQuery(criteria).getSingleResult(); 
    }

    public List<Patient> findAllOrderedByName() {
        /* CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
        Root<Patient> Patient = criteria.from(Patient.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(Patient).orderBy(cb.asc(Patient.get(Patient_.name)));
        criteria.select(Patient).orderBy(cb.asc(Patient.get("lastName")));
        return em.createQuery(criteria).getResultList(); */
        CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
    	Root <Patient> from = cq.from(Patient.class);
    	cq.orderBy(cb.asc(from.get("lastName")));
    	TypedQuery<Patient> query = em.createQuery(cq);
    	return query.getResultList();
    }
    
    public void register(Patient patient) throws Exception {
        log.info("Registering " + patient.getFirstName() + " " + patient.getLastName());
        Date date = new Date();
        patient.setCreateDate(date);
        patient.setLastUpdateDate(date);
        ContactEmail contactEmail = patient.getContactEmail();
        if (contactEmail!=null ){
        	patient.addContactEmail(contactEmail);
        	contactEmail.setCreateDate(date);
        	contactEmail.setLastUpdateDate(date);
        	em.persist(contactEmail);	
        }
        ContactPhone contactPhone = patient.getContactPhone();
        if (contactPhone!=null ){
        	patient.addContactPhone(contactPhone);
        	contactPhone.setCreateDate(date);
        	contactPhone.setLastUpdateDate(date);
        	em.persist(contactPhone);	
        }
        Address address = patient.getAddress();
        if (address!=null ){
        	patient.addAddress(address);
        	address.setCreateDate(date);
        	address.setLastUpdateDate(date);
        	em.persist(address);	
        }
        MedicalHistory medicalHistory = patient.getMedicalHistory();
        if (medicalHistory!=null ){
        	patient.setMedicalHistory(medicalHistory);
        	medicalHistory.setCreateDate(date);
        	medicalHistory.setLastUpdateDate(date);
        	em.persist(medicalHistory);	
        }
        PreviousEvaluation previousEvaluation = patient.getPreviousEvaluation();
        if (previousEvaluation!=null ){
        	patient.setPreviousEvaluation(previousEvaluation);
        	previousEvaluation.setCreateDate(date);
        	previousEvaluation.setLastUpdateDate(date);
        	em.persist(previousEvaluation);	
        }
        PreviousTreatment previousTreatment = patient.getPreviousTreatment();
        if (previousEvaluation!=null ){
        	patient.setPreviousTreatment(previousTreatment);
        	previousTreatment.setCreateDate(date);
        	previousTreatment.setLastUpdateDate(date);
        	em.persist(previousTreatment);	
        }
        em.persist(patient);  
    }
}
