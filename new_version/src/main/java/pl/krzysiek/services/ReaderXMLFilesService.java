package pl.krzysiek.services;

import java.util.ArrayList;
import java.util.List;

public interface ReaderXMLFilesService {

    public List<ArrayList<String>> readXMLFilesF(String xmlPath, String xmlID);
}
