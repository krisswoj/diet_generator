//package pl.krzysiek.Controllers;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.mock.web.MockMultipartFile;
//import pl.krzysiek.storage.StorageFileNotFoundException;
//import pl.krzysiek.storage.StorageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Controller
//public class FileUploadController {
//
//    private final StorageService storageService;
//
//    @Autowired
//    public FileUploadController(StorageService storageService) {
//        this.storageService = storageService;
//    }
//
//    @GetMapping("/")
//    public String listUploadedFiles(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll().map(
//                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                        "serveFile", path.getFileName().toString()).build().toString())
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }
//
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//
//    @PostMapping("/")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) throws IOException {
//
//        System.out.println("Nazwa pliku oryginal: " + file.getOriginalFilename());
////        MultipartFile multipartFile = new  MockMultipartFile(FilenameUtils.getBaseName(oldMultipartFile.getOriginalFilename()).concat(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())) + "." + FilenameUtils.getExtension(oldMultipartFile.getOriginalFilename()), oldMultipartFile.getInputStream());
//
////        String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
////
////        file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
////
////
//////        System.out.println("Nazwa pliku po modyfikacji: " + multipartFile.getOriginalFilename());
//
//
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "redirect:/";
//    }
//
//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
//
//}
