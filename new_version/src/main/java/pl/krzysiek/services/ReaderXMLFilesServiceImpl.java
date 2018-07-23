package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("ReaderXMLFiles")
@Transactional
public class ReaderXMLFilesServiceImpl implements ReaderXMLFilesService {

    private ReaderXMLFilesService readerXMLFilesService;

    @Override
    public List<ArrayList<String>> readXMLFilesF(String xmlPath, String xmlID) {

        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();


        try {

            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(xmlID);

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                ArrayList<String> pozycja = new ArrayList<String>();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;


                    if (eElement.getElementsByTagName("name").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("description").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("description").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("category").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("category").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("subcategory").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("subcategory").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("amount_protins").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("amount_protins").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("amount_carbs").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("amount_carbs").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("amount_fats").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("amount_fats").item(0).getTextContent());
                    }

                    list.add(pozycja);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

}
