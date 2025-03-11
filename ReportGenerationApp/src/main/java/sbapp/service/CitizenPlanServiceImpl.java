package sbapp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import sbapp.binding.CitizenCriteria;
import sbapp.binding.CitizenPlan;
import sbapp.repository.ICitizenPlanRepo;
import sbapp.util.EmailUtils;

@Service
public class CitizenPlanServiceImpl implements ICitizenPlanService {

	@Autowired
	private ICitizenPlanRepo repo;

	@Autowired
	private EmailUtils email;
	
	@Override
	public List<CitizenPlan> getCitizenInfo(CitizenCriteria criteria) {

		CitizenPlan citizen = new CitizenPlan();
		
		if(!criteria.getPlanName().equals("--select--")) {
			citizen.setPlanName(criteria.getPlanName());
		}
		if(!criteria.getPlanStatus().equals("--select--")) {
			citizen.setPlanStatus(criteria.getPlanStatus());
		}
		if(!criteria.getGender().equals("--select--")) {
			citizen.setGender(criteria.getGender());
		}
		if(criteria.getStartDate() != null ) {
			citizen.setStartDate(criteria.getStartDate());
		}
		if(criteria.getEndDate() != null ) {
			citizen.setEndDate(criteria.getEndDate());
		}
		
		System.out.println(citizen);
		Example<CitizenPlan> of = Example.of(citizen);
		List<CitizenPlan> records = repo.findAll(of);
		return records;
	}

	@Override
	public void generateExcel(HttpServletResponse res) throws Exception {
		
		List<CitizenPlan> records = repo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Citizens Data");
		HSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Email Id");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("Mobile Number");
		headerRow.createCell(5).setCellValue("Plane Name");
		headerRow.createCell(6).setCellValue("Plan Status");
		headerRow.createCell(7).setCellValue("SSN Number");
		headerRow.createCell(8).setCellValue("Start Date");
		headerRow.createCell(9).setCellValue("End Date");
		
		int rowIndex = 1;
		for(CitizenPlan record:records) {
			HSSFRow bodyRow = sheet.createRow(rowIndex);
			bodyRow.createCell(0).setCellValue(record.getId());
			bodyRow.createCell(1).setCellValue(record.getName());
			bodyRow.createCell(2).setCellValue(record.getEmail());
			bodyRow.createCell(3).setCellValue(record.getGender());
			bodyRow.createCell(4).setCellValue(record.getMobileNumber());
			bodyRow.createCell(5).setCellValue(record.getPlanName());
			bodyRow.createCell(6).setCellValue(record.getPlanStatus());
			bodyRow.createCell(7).setCellValue(record.getSsnNumber());
			bodyRow.createCell(8).setCellValue(record.getStartDate());
			bodyRow.createCell(9).setCellValue(record.getEndDate());
			
			rowIndex++;
		}
		
		
		File file = new File("report.xls");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		email.sendMail(file);
		
		ServletOutputStream opStream = res.getOutputStream();
		workbook.write(opStream);
		workbook.close();
		opStream.close();
		fos.close();
	}

	@Override
	public void generatePdf(HttpServletResponse res)throws Exception {
		List<CitizenPlan> records = repo.findAll();
		
		File file = new File("report.pdf");
		FileOutputStream fos = new FileOutputStream(file);
		
		ServletOutputStream opStream = res.getOutputStream();
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, opStream); //download
		PdfWriter.getInstance(doc, fos); //mail
		doc.open();
		 // Creating font
	    // Setting font style and size
	    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    fontTiltle.setSize(20);
	    // Creating paragraph
	    Paragraph para = new Paragraph("Citizens Plan Informartion", fontTiltle);
	    // Aligning the paragraph in the document
	    para.setAlignment(Paragraph.ALIGN_CENTER);
	    doc.add(para);
		
	    PdfPTable table = new PdfPTable(6);
	 // Setting width of the table, its columns and spacing
	    table.setWidthPercentage(100f);
	    table.setWidths(new int[] {3,5,2,3,2,3});
	    table.setSpacingBefore(5);
	    // Create Table Cells for the table header
	    PdfPCell cell = new PdfPCell();
	    // Setting the background color and padding of the table cell
	    cell.setBackgroundColor(CMYKColor.BLUE);
	    cell.setPadding(5);
	    // Creating font
	    // Setting font style and size
	    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    font.setColor(CMYKColor.WHITE);
	    // Adding headings in the created table cell or  header
	    // Adding Cell to table
	    cell.setPhrase(new Phrase("Name", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Email id", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Gender", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Mobile No", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Plan Name", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Plan Status", font));
	    table.addCell(cell);
	    
	    for(CitizenPlan record : records) {
	    	table.addCell(record.getName());
	    	table.addCell(record.getEmail());
	    	table.addCell(record.getGender());
	    	table.addCell(String.valueOf(record.getMobileNumber()));
	    	table.addCell(record.getPlanName());
	    	table.addCell(record.getPlanStatus());
	    }
	    doc.add(table);
	    doc.close();
	    opStream.close();
	    fos.close();
	    email.sendMail(file);
	}

}
