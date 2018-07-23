package pl.krzysiek.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ReaderXMLFilesService {

    public List<ArrayList<String>> readXMLFilesF(String xmlFile, String xmlID);
}
