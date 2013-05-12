package com.yenrof.mhvi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
//import org.jboss.resteasy.client.ClientResponse;
//import org.jboss.resteasy.util.GenericType;



import com.yenrof.mhvi.dataservice.PatientRepository;
import com.yenrof.mhvi.rest.PatientService;
import com.yenrof.mhvi.service.PatientRegistration;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;




import com.yenrof.mhvi.model.*;
import com.yenrof.mhvi.util.Resources;

/**
 * Uses Arquilian to test the JAX-RS processing class for patient registration.
 */
@RunWith(Arquillian.class)
public class PatientRegistrationTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addClasses(Patient.class, Address.class, ContactEmail.class, ContactPhone.class, PatientService.class, PatientRepository.class, 
                		TestosteroneDeficiency.class, PreviousEvaluation.class, MedicalHistory.class, Medication.class, MedicationSurgeryHistory.class, SexualHistory.class, SixMonthHistory.class, Surgery.class, 
                		PreviousTreatment.class, RiskFactor.class, PatientRegistration.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("arquillian-ds.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    PatientService PatientRegistration;

    @Inject
    Logger log;
    
    @PersistenceContext
    EntityManager em;
    
  @Inject
    UserTransaction utx;
    
    @Before
    public void prepareTest() throws Exception {
    	   utx.begin();
           em.joinTransaction();
           System.out.println("Dumping old records...");
           em.createQuery("delete from Patient").executeUpdate();
           utx.commit();
           utx.begin();
           em.joinTransaction();
    }
    
    @After
    public void commitTransaction() throws Exception {
           utx.commit();
    }

    @Test 
    @InSequence(1)
 //   @POST 
 //   @Path("mens/rest/patients") 
 //   @Produces(MediaType.APPLICATION_JSON)
 //   @Consumes(MediaType.APPLICATION_JSON)
    public void testRegister() throws Exception {
    	log.info(" New Patient registration beginning..........[testRegister]");
        Patient Patient = createPatientInstance("Jane", "Doe", "L", "212555123");
        Response response = PatientRegistration.createPatient(Patient);
    	log.info("[testRegister] result code " + response.getStatus());
        assertEquals("Unexpected response status", 200, response.getStatus());
        log.info(" New Patient was persisted and returned status " + response.getStatus());
    }

    @SuppressWarnings("unchecked")
    @Test 
    @InSequence(2)
     public void testInvalidRegister() throws Exception {
       	log.info(" New Patient registration beginning..........[testInvalidRegister]");
        Patient Patient = createPatientInstance("", "", "","");
        Response response = PatientRegistration.createPatient(Patient);

        assertEquals("Unexpected response status", 400, response.getStatus());
        assertNotNull("response.getEntity() should not null", response.getEntity());
        assertEquals("Unexpected response.getEntity(). It contains " + response.getEntity(), 3,
                ((Map<String, String>) response.getEntity()).size());
        log.info("Invalid Patient register attempt passed with return code " + response.getStatus());
    }

    @SuppressWarnings("unchecked")
    @Test
    @InSequence(3)
   public void testDuplicateSSN() throws Exception {
    	log.info(" New Patient registration beginning..........[testDuplicateSSN]");
        
        // Register an initial user
        Patient Patient = createPatientInstance("Jane", "Doe", "K", "212551234");
        Response response = PatientRegistration.createPatient(Patient);
        log.info("[testDuplicateSSN] result code " + response.getStatus());
        assertEquals("Unexpected response status", 200, response.getStatus());
        log.info(" New Patient was persisted and returned status " + response.getStatus());
     
        // Register a different user with the same ssn
        Patient anotherPatient = createPatientInstance("John", "Doe", "F", "212551234");
        response = PatientRegistration.createPatient(anotherPatient);

        assertEquals("Unexpected response status", 409, response.getStatus());
        assertNotNull("response.getEntity() should not null", response.getEntity());
        assertEquals("Unexpected response.getEntity(). It contains" + response.getEntity(), 1,
                ((Map<String, String>) response.getEntity()).size());
        log.info("Duplicate Patient register attempt passed with return code " + response.getStatus());
    }
    
    @Test 
    @InSequence(4)
    public void shouldBeAbleToListAllPatients() {
    	log.info(" New Patient registration beginning..........[shouldBeAbleToListAllPatients]");
        // Register an initial user
        Patient Patient = createPatientInstance("Jane", "Doe", "K", "212551234");
        Response response = PatientRegistration.createPatient(Patient);
        assertEquals("Expected response status", 200, response.getStatus());
        log.info(" New Patient was persisted and returned status " + response.getStatus());
        
        // Register an 2nd user
        Patient = createPatientInstance("John", "Doe", "K", "112551234");
        response = PatientRegistration.createPatient(Patient);
        assertEquals("Expected response status", 200, response.getStatus());
        log.info(" 2nd Patient was persisted and returned status " + response.getStatus());
        
        List<Patient> patients = PatientRegistration.listAllPatients();
        assertEquals(2, patients.size());
        log.info( "2 patients were successfully retrieved and returned status " + response.getStatus());
     }
    
    @Test 
    @InSequence(5)
    public void shouldBeAbleToListAPatient() {
        // Register an initial user
        Patient patient = createPatientInstance("Jane", "Doe", "K", "212551234");
        Response response = PatientRegistration.createPatient(patient);
        assertEquals("Expected response status", 200, response.getStatus());
        log.info(" New Patient was persisted and returned status " + response.getStatus());
        
        List<Patient> patients = PatientRegistration.listAllPatients();
        assertEquals(1, patients.size());
        log.info( "1 patient was successfully retrieved and returned status " + response.getStatus());
        
        patient = (Patient) patients.get(0);
 
        
        patient = PatientRegistration.lookupPatientById(patient.getId());
        assertEquals("Expected response status", 200, response.getStatus());
        log.info( "Patient was successfully retrieved and returned status " + response.getStatus());
    }
    @Test 
    @InSequence(6)
    public void testRegister2() throws Exception {
    	log.info(" New Patient registration beginning..........[testRegister2]");
        Patient patient = createPatientInstance("Jane", "Doe", "L", "212555123");
        MedicalHistory medicalHistory = new MedicalHistory();
        MedicationSurgeryHistory medicationSurgeryHistory = new MedicationSurgeryHistory();
        SexualHistory sexualHistory = new SexualHistory();
    	log.info(" New Patient registration beginning..........[add Address info]");
    	 
        Address address = new Address();
        address.setAddress1("addressOne");
        address.setAddress2("addressTwo");
        address.setCity("city");
        address.setState("GA");
        address.setZip1("30058");
        address.setZip2("9999");
        ContactPhone contactPhone = new ContactPhone();
        contactPhone.setType("H");
        contactPhone.setInfo("7709995555");
        ContactPhone contactPhone1 = new ContactPhone();
        contactPhone1.setType("M");
        contactPhone1.setInfo("4049995555");
        ContactEmail contactEmail = new ContactEmail();
        contactEmail.setType("H");
        contactEmail.setInfo("jforn@gmail.com");
              
        patient.addContactPhone(contactPhone);
        patient.addContactPhone(contactPhone1); 
        patient.addContactEmail(contactEmail);
        patient.addAddress(address);
  
     	log.info("[testRegister2 bon/boff===================>>>] " );
     	      
        medicalHistory.setAnxiety(true);
        sexualHistory.setDepression(false);
        medicationSurgeryHistory.setFamilyCancer(true);
        
        patient.setMedicalHistory(medicalHistory);
        patient.setMedicationSurgeryHistory(medicationSurgeryHistory);
        patient.setSexualHistory(sexualHistory);
        
        patient.setRace("AA");
        
       	log.info("[testRegister2 Address===================>>>] " + patient.getAddress().toString());
 
        Response response = PatientRegistration.createPatient(patient);
    	log.info("[testRegister2] result code " + response.getStatus());
        assertEquals("Unexpected response status", 200, response.getStatus());
        log.info(" New Patient was persisted and returned status " + response.getStatus());    }
    
    private Patient createPatientInstance(String firstName, String lastName, String middleName, String ssn) {
        com.yenrof.mhvi.model.Patient Patient = new Patient();
        Patient.setFirstName(firstName);
        Patient.setLastName(lastName);
        Patient.setMiddleName(middleName);
        Patient.setSsn(ssn);
        
        return Patient;
    }
}
