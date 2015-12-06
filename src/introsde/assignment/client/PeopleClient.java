package introsde.assignment.client;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import introsde.assignment.soap.HealthProfile;
import introsde.assignment.soap.Measure;
import introsde.assignment.soap.MeasureType;
import introsde.assignment.soap.PeopleService;
import introsde.assignment.soap.People;
import introsde.assignment.soap.Person;
 
/**
 * Class for people client implementation
 * @author Toomas
 *
 */
public class PeopleClient{

	// Init attributes
    private static People people = null;
    private int createdPersonId = 0;
    private Measure createdMeasure = null;
    private static PrintWriter logFile = null;

	public static void main(String[] args) throws Exception {
		// Init people service
		PeopleService service = new PeopleService();
        people = service.getPeopleImplPort();

        // Init new client
        PeopleClient c = new PeopleClient();

        // Set logfile
        logFile = new PrintWriter("client-server.log");
        
        // Set server info and print it
        String serverUrl = "http://introsde-assignment3.herokuapp.com/ws/people?wsdl";
        String serverInfo = "Requesting from server running in: " + serverUrl;
        System.out.println(serverInfo);
        logFile.println(serverInfo);

        // Call client methods
        c.callMethod1();
        c.callMethod2();
        c.callMethod3();
        c.callMethod4();
        c.callMethod5();
        c.callMethod6();
        c.callMethod7();
        c.callMethod8();
        c.callMethod9();
        c.callMethod10();
        
        // Close writing to logfile
        logFile.close();
    }

	/**
	 * Method 1
	 */
	public void callMethod1() {
        int methodNumber = 1;
        String methodName = "readPersonList";
        String parameters = "";
        String body = "";
        // Get list of persons
        List<Person> persons = people.readPersonList();
        // Loop through person list and stringify each person
        for (int i=0; i<persons.size(); i++) {
            body += stringifyPerson(persons.get(i));
        }
        printRequest(methodNumber, methodName, parameters, body);
    }

	/**
	 * Method 2
	 */
    public void callMethod2() {
        int methodNumber = 2;
        String methodName = "readPerson";
        String parameters = "1";
        // Read person 1
        Person p = people.readPerson(1);
        String body = stringifyPerson(p);
        printRequest(methodNumber, methodName, parameters, body);
    }
    
    /**
     * Method 3
     */
    public void callMethod3() {
        int methodNumber = 3;
        String methodName = "updatePerson";
        String parameters = "2";
        // Read person 2
        Person p = people.readPerson(2);
        // Create unique string and add that to person name to change it
        String uuid = UUID.randomUUID().toString();
        p.setFirstname("Charlie"+"-"+uuid);
        // Update person and get the updated person
        int personId = people.updatePerson(p);
        Person updPerson = people.readPerson(personId);
        String body = stringifyPerson(updPerson);
        printRequest(methodNumber, methodName, parameters, body);
    }
    
    /**
     * Method 4
     */
    public void callMethod4() {
        int methodNumber = 4;
        String methodName = "createPerson";
        String parameters = "";
        // Create new person
        Person p = new Person();
        p.setFirstname("Testeri");
        p.setLastname("Testaa");
        p.setBirthdate("1990-05-10");
        
        // Create new healthprofile
        HealthProfile hp = new HealthProfile();
        
        // Create new measures
        Measure m1 = new Measure();
        m1.setMeasure("weight");
        m1.setValue(85.0);
        m1.setValueType("double");
        
        Measure m2 = new Measure();
        m2.setMeasure("height");
        m2.setValue(190.0);
        m2.setValueType("double");
        
        // Make list from created measures
        List<Measure> measures = new ArrayList<Measure>();
        measures.add(m1);
        measures.add(m2);
        
        // Add measure list to healthprofile
        hp.getMeasures().add(m1);
        hp.getMeasures().add(m2);
        // Set healthprofile to person
        p.setHealthProfile(hp);
        
        // Send create person request
        Person person = people.createPerson(p);
        // Save the created person id
        createdPersonId = person.getIdPerson();
        
        String body = stringifyPerson(person);
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 5
     */
    public void callMethod5() {
        int methodNumber = 5;
        String methodName = "deletePerson";
        String parameters = createdPersonId + "";
        // Delete previously created person
        boolean deleted = people.deletePerson(createdPersonId);
        String body = "";
        // Create body response based on if person was deleted or not
        if (deleted) {
            body = "Person deleted" + " \n";
        } else {
            body = "Person not deleted" + " \n";
        }
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 6
     */
    public void callMethod6() {
        int methodNumber = 6;
        String methodName = "readPersonHistory";
        String parameters = "1, weight";
        // Get person 1 weight measure history
        List<Measure> measures = people.readPersonHistory(1, "weight");
        String body = "";
        // Loop through measure list and stringify all measures
        for (int i=0; i<measures.size(); i++) {
            body += stringifyMeasure(measures.get(i));
        }
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 7
     */
    public void callMethod7() {
        int methodNumber = 7;
        String methodName = "readMeasureTypes";
        String parameters = "";
        // Read all measureTypes
        List<MeasureType> measureTypes = people.readMeasureTypes();
        String body = "Measure types:" + " \n";
        // Loop though measure types and save measure names to body response
        for (int i=0; i<measureTypes.size(); i++) {
            body += measureTypes.get(i).getMeasureName() + " \n";
        }
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 8
     */
    public void callMethod8() {
        int methodNumber = 8;
        String methodName = "readPersonMeasure";
        String parameters = "3, height, 8";
        // Read person 3's height measure from measure id 8
        Measure measure = people.readPersonMeasure(3, "height", 8);
        String body = stringifyMeasure(measure);
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 9
     */
    public void callMethod9() {
        int methodNumber = 9;
        String methodName = "savePersonMeasure";
        String parameters = "3, Measure createdMeasure";

        // Create new measure
        Measure m = new Measure();
        m.setMeasure("weight");
        m.setValue(85.0);
        m.setValueType("double");
        
        // Save new person measure and save it to attribute
        createdMeasure = people.savePersonMeasure(3, m);
        String body = stringifyMeasure(createdMeasure);
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Method 10
     */
    public void callMethod10() {
        int methodNumber = 10;
        String methodName = "updatePersonMeasure";
        String parameters = "3, Measure createdMeasure";

        // Update the value of previously created measure
        createdMeasure.setValue(90.0);
        int measureId = people.updatePersonMeasure(3, createdMeasure);
        String body = stringifyMeasure(createdMeasure);
        printRequest(methodNumber, methodName, parameters, body);
    }

    /**
     * Stringify person object
     * @param p		Person to stringify
     * @return 		result string
     */
    public String stringifyPerson(Person p) {
        String result = "";
        result += "Person id: " + p.getIdPerson() + " \n";
        result += "Firstname: " + p.getFirstname() + " \n";
        result += "Lastname: " + p.getLastname() + " \n";
        result += "Birthdate: " + p.getBirthdate() + " \n";
        if (p.getHealthProfile() != null) {
            result += stringifyHealthProfile(p.getHealthProfile()) + " \n";
        }
        return result;
    }
    
    /**
     * Stringify HelthProfile object
     * @param hp	HealthProfile to stringify
     * @return		result string
     */
    public String stringifyHealthProfile(HealthProfile hp) {
        String result = "";
        result += "Healthprofile:" + "\n";
        for (int i=0; i<hp.getMeasures().size(); i++) {
            result += stringifyMeasure(hp.getMeasures().get(i));
        }
        return result;
    }
    
    /**
     * Stringify Measure object
     * @param m		Measure to stringify	
     * @return		result string
     */
    public String stringifyMeasure(Measure m) {
        String result = "";
        result += "Mid : " + m.getMid() + " \n";
        result += "Created: " + m.getCreated() + " \n";
        result += "MeasureType: " + m.getMeasure() + " \n";
        result += "Value: " + m.getValue() + " \n";
        result += "ValueType: " + m.getValueType() + " \n";
        return result;
    }
    
    /**
     * Stringify MeasureType object
     * @param mt	MeasureType to stringify
     * @return		result string
     */
    public String stringifyMeasureType(MeasureType mt) {
        String result = mt.getMeasureName();
        return result;
    }
    
    /**
     * Print request to command line and logfile
     * @param number		request number
     * @param name			request name
     * @param parameters	request parameters
     * @param body			request body
     */
    public void printRequest(int number, String name, String parameters, String body) {
        System.out.println("Request #" + number + ": " + name + "(" + parameters + ")");
        System.out.println("=> Body: ");
        System.out.println(body);
        // Print same info to log file
        logFile.println("");
        logFile.println("Request #" + number + ": " + name + "(" + parameters + ")");
        logFile.println("=> Body: ");
        logFile.println(body);
    } 
}
