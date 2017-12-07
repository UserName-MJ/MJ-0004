package cn.test.email.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.AddQuestionMapper;
import cn.test.email.model.TQuestion;
import cn.test.email.service.SaveQuestionService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
@Service
public class SaveQuestionServiceImpl implements SaveQuestionService {

	@Autowired
	private AddQuestionMapper addQuestionMapper;
	@Override
	public void jxExcle(String path) throws BiffException, IOException {
		
		 InputStream is = new FileInputStream(path);  
	        // 2、声明工作簿对象  
	        Workbook rwb = Workbook.getWorkbook(is);  
	        // 3、获得工作簿的个数,对应于一个excel中的工作表个数  
	        rwb.getNumberOfSheets();  
	        Sheet oFirstSheet = rwb.getSheet(0);// 使用索引形式获取第一个工作表，也可以使用rwb.getSheet(sheetName);其中sheetName表示的是工作表的名称  
//	        System.out.println("工作表名称：" + oFirstSheet.getName()); 
	        TQuestion exam=new TQuestion();
	        int rows = oFirstSheet.getRows();//获取工作表中的总行数  
	        int columns = oFirstSheet.getColumns();//获取工作表中的总列数  
	        Cell oCell= null;
	       
	        for (int i = 0; i < rows; i++) {  
	        	List arr=new ArrayList();
	            for (int j = 0; j < columns; j++) {  
	                oCell= oFirstSheet.getCell(j,i);//需要注意的是这里的getCell方法的参数，第一个是指定第几列，第二个参数才是指定第几行  
	                arr.add(oCell.getContents());
	            }
	            String ti="";
	            exam.setTitle(arr.get(0).toString());
	            
	            String[] sourceStrArray = arr.get(1).toString().split("；");//分割出来的字符数组
	            for (int t = 0; t < sourceStrArray.length; t++) {
	            	if(t==sourceStrArray.length-1){
	            		ti+=sourceStrArray[t];
	            	}else{
	            		ti+=sourceStrArray[t]+",";
	            	}
	            }
	            exam.set_option(ti);
	            exam.setAnswer(arr.get(2).toString());
	            exam.setRank(1);
	            exam.setType(Integer.parseInt((String) arr.get(3)));
	            exam.setCreated(new Date());
	            addQuestionMapper.addExam(exam); 
	        }  
		}
	

}
