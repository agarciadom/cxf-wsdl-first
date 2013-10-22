cxf-wsdl-first
==============

This is a simple example project that shows how to build a WSDL-first Web Service using Maven, CXF and Spring.

The project is divided into several Maven modules:

- The parent and aggregate module in the root directory indicates which version of CXF should be used and the Java version compliance for the compiled code.
- The API module (`api`) generates the remote interface and the types that will be used by the server and the client.
- The Implementation module (`impl`) provides an implementation of the service and generates a `.war` file which can be deployed into Tomcat.
- The Client (`client`) module provides a Spring-based command-line client for the service.

To try out the generated WS, first run these commands:

    mvn clean install
    cd impl
    mvn tomcat:run

You'll have a local instance of Tomcat running the `.war` on port 8080. Go to `http://localhost:8080/impl` and use the provided link to the WSDL file with your favourite WS client, such as [soapUI](http://www.soapui.org/) or the Eclipse [Web Services Explorer](http://help.eclipse.org/juno/index.jsp?topic=%2Forg.eclipse.jst.ws.consumption.ui.doc.user%2Ftasks%2Ftstrtexp.html) in the EE edition, for instance.

Alternatively, you can use the included command-line client from another console:

    cd client
    mvn exec:java -Dexec.arguments="personId"
