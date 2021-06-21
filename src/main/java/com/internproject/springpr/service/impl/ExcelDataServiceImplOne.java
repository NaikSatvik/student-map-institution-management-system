package com.internproject.springpr.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.internproject.springpr.domain.Res_SemOne;
import com.internproject.springpr.repository.Res_SemOneRepository;
import com.internproject.springpr.service.IExcelDataService;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExcelDataServiceImplOne implements IExcelDataService {

    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;

    @Autowired
    Res_SemOneRepository repo;

    Workbook workbook;

    
    public List<Res_SemOne> getExcelDataAsList() {
        List<String> list = new ArrayList<String>();
        DataFormatter dateFormatter = new DataFormatter();

        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("---WorkBook has "+workbook.getNumberOfSheets()+"Sheets----");

        Sheet sheet = workbook.getSheetAt(0);
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("-----Sheet has "+noOfColumns+" columns------");

        for(Row row : sheet) {
            for(Cell cell : row) {
                String cellValue = dateFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }

        List<Res_SemOne> semOneList = createList(list, noOfColumns);
        try {
            workbook.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return semOneList;
    }

    private List<Res_SemOne> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Res_SemOne> semOneList = new ArrayList<Res_SemOne>();
        int i = noOfColumns;
        do {
            Res_SemOne res = new Res_SemOne();
            res.setName(excelData.get(i));
            res.setEmailid(excelData.get(i + 1));
            res.setBranch(excelData.get(i + 2));
            res.setYear(excelData.get(i + 3));
            res.setSemester(excelData.get(i + 4));
            res.setEnroll(excelData.get(i + 5));
            res.setIp(excelData.get(i + 6));
            res.setEsfpi(excelData.get(i + 7));
            res.setDe(excelData.get(i + 8));
            res.setBe(excelData.get(i + 9));
            res.setCalculus(excelData.get(i + 10));
            res.setSgpa(excelData.get(i + 11));
            semOneList.add(res);
            i = i + (noOfColumns);
        } while(i < excelData.size());
        return semOneList;
    }

    @Override
    public int saveExcelData(List<Res_SemOne> resSemOne) {
        resSemOne = repo.saveAll(resSemOne);
        return resSemOne.size();
    }
}