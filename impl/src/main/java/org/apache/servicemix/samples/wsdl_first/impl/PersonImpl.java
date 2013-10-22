package org.apache.servicemix.samples.wsdl_first.impl;

import java.util.logging.Logger;

import org.apache.servicemix.samples.wsdl_first.Person;
import org.apache.servicemix.samples.wsdl_first.UnknownPersonFault;

/**
 * This is an example.
 */
@javax.jws.WebService(serviceName = "PersonService", portName = "soap", targetNamespace = "http://servicemix.apache.org/samples/wsdl-first", endpointInterface = "org.apache.servicemix.samples.wsdl_first.Person")
public class PersonImpl implements Person {
	private static final Logger LOG = Logger.getLogger(PersonImpl.class.getName());

	public void getPerson(javax.xml.ws.Holder<java.lang.String> personId,
			javax.xml.ws.Holder<java.lang.String> ssn,
			javax.xml.ws.Holder<java.lang.String> name)
			throws UnknownPersonFault {
		LOG.info("Executing operation getPerson");
		System.out.println(personId.value);
		try {
			ssn.value = "foo";
			name.value = "yay";
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		// throw new UnknownPersonFault("UnknownPersonFault...");
	}

}
