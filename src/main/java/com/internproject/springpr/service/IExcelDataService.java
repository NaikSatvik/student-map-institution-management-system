package com.internproject.springpr.service;
import java.util.List;
import com.internproject.springpr.domain.Res_SemOne;

public interface IExcelDataService {
    List<Res_SemOne> getExcelDataAsList();
    int saveExcelData(List<Res_SemOne> resSemOne);   
}