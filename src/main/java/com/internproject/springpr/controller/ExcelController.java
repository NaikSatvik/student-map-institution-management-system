package com.internproject.springpr.controller;

import java.util.List;
import com.internproject.springpr.domain.Res_SemOne;
import com.internproject.springpr.repository.Res_SemOneRepository;
import com.internproject.springpr.service.IExcelDataService;
import com.internproject.springpr.service.IFileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExcelController {
    @Autowired
    IFileUploaderService fileService;

    @Autowired
    IExcelDataService excelservice;

    @Autowired
    Res_SemOneRepository oneRepo;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message","You Have Successfully Uploaded "+file.getOriginalFilename()+"!!");
        try {
            Thread.sleep(600000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // return "redirect:/UploadGrades";
        return null;
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {
        List<Res_SemOne> excelDataAsList = excelservice.getExcelDataAsList();
        int noOfRecords = excelservice.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords",noOfRecords);
        return "UploadGrades";
    }
}