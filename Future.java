package Assigiment2.Student;

import Assigiment2.src.entity.Student;
import com.google.gson.Gson;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.jar.Attributes;
import java.util.jar.JarException;

public class Future {
    private static Object studentList;
    public static void writeXml() throws JAXBException {
        File file = new File("Student1.xml");
        //JAXB
        JAXBContext context = JAXBContext.newInstance(Student.class);
        //Tao marshaller object
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Tao cau truc xml theo dinh dang cua Entity
        Student student = new Student(1, "An", "an@gmail.com", new String[]{"Student", "Employee", "Leader"}, "012345678");
    }

    public void writeJson() throws SQLException, IOException {
        Writer writer =  new FileWriter("student1.json");
        new Gson().toJson(studentList,writer);
        writer.close();
        System.out.println("complete");
    }

    public void writeXMLvsDOM() throws ParserConfigurationException, TransformerException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document dom = builder.newDocument();//Tao ra doi tuong document

        //tao root element
        Element root = dom.createElement("user");
        dom.appendChild(root);
        //tao ra attribute(thuoc tinh) them vao root
        Attr attr = dom.createAttribute("id");
        attr.setValue("1");
        root.setAttributeNode(attr);
        //Tao ra cac element con cua root aka user(name,email,phone,address)
        Element name = dom.createElement("name");
        name.setTextContent("An");
        Element email = dom.createElement("email");
        email.setTextContent("an@gmail.com");
        Element mobile = dom.createElement("mobile");
        mobile.setTextContent("012345678");
        Element address = dom.createElement("address");
        address.setTextContent("Ha Noi");
        root.appendChild(name);
        root.appendChild(email);
        root.appendChild(mobile);
        root.appendChild(address);
//           Element roles = dom.createElement("roles");
//           root.appendChild(roles);
//           Element role1 = dom.createElement("role");
//           role1.setTextContent("Student");
//           Element role2 = dom.createElement("role");
//           role2.setTextContent("Employee");
//           Element role3 = dom.createElement("role");
//           role3.setTextContent("Leader");
//           roles.appendChild(role1);
//           roles.appendChild(role2);
//           roles.appendChild(role3);
        //DOM -> XML File
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(dom), new StreamResult(new File("student1.xml")));
    }
    public void readXMLvsDOM() throws ParserConfigurationException, IOException, SAXException {

        //1.Document
        DocumentBuilder builder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document dom = builder.parse(new File("student1.xml"));

        //Dinh dang cau truc xml
        dom.normalizeDocument();

        //Read xml
        Element root = dom.getDocumentElement();
        //print attribute
        System.out.println("ID: " + root.getAttribute("id"));

        //Elements
        System.out.println("Name: " + root.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Email: " + root.getElementsByTagName("email").item(0).getTextContent());
        System.out.println("Mobile: " + root.getElementsByTagName("mobile").item(0).getTextContent());
        System.out.println("Address: " + root.getElementsByTagName("address").item(0).getTextContent());
    }
}

