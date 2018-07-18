package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredients;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service("food_ingredients")
@Transactional
public class FoodIngredientsServiceImpl implements FoodIngredientsService {

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;

    @Override
    public List<FoodIngredients> listAll() {
        List<FoodIngredients> counts = new ArrayList<>();
        foodIngredientsRepository.findAll().forEach(counts::add);
        return counts;
    }

    @Override
    public FoodIngredients addNew(FoodIngredients foodIngredients) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        foodIngredients.setCreatedDate(date);
        return foodIngredientsRepository.save(foodIngredients);
    }

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

                    if (eElement.getElementsByTagName("id").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("id").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("name").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("price").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("price").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("default_components").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("default_components").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("optional_components").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("optional_components").item(0).getTextContent());
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
