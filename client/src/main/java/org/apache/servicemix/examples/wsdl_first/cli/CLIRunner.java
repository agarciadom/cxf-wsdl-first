package org.apache.servicemix.examples.wsdl_first.cli;

import java.io.IOException;
import java.util.logging.LogManager;

import javax.xml.ws.Holder;

import org.apache.servicemix.samples.wsdl_first.Person;
import org.apache.servicemix.samples.wsdl_first.UnknownPersonFault;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CLIRunner {

	public static void main(String[] args) throws SecurityException, IOException {
		LogManager.getLogManager().readConfiguration(CLIRunner.class.getResourceAsStream("/logging.properties"));

		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		try {
			if (args.length != 1) {
				System.err.println("Usage: (personId)");
				System.exit(1);
			}
			run(ctx, args[0]);
		} catch (UnknownPersonFault e) {
			e.printStackTrace();
		} finally {
			ctx.close();
		}
	}

	private static void run(final ApplicationContext ctx, final String personId)
			throws UnknownPersonFault {
		final Person personService = ctx.getBean(Person.class);
		final Holder<String> hSSN = new Holder<String>();
		final Holder<String> hName = new Holder<String>();

		personService.getPerson(new Holder<String>(personId), hSSN, hName);
		System.out.println("SSN: " + hSSN.value);
		System.out.println("Name: " + hName.value);
	}
}
