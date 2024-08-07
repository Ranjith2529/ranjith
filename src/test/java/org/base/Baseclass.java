package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver dd;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		dd = new ChromeDriver();
	}
	
	public static void windowMaximize() {
		dd.manage().window().maximize();	
	}
	public static void launchUrl(String Url) {
		dd.get(Url);
	}
	public static String pageTitle() {
		String title = dd.getTitle();
		return title;
	}
	public static String pageUrl() {
		String Url = dd.getCurrentUrl();
		return Url;
	}
	public static void passText(String txt, WebElement ee) {
		ee.sendKeys(txt);	
	}
	public static void closeEntireBrowser() {
		dd.quit();
	}
	public static void clickButton(WebElement ele) {
		ele.click();
	}
	public static void screenShot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)dd;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Location + imgname.png");
		FileUtils.copyFile(image, f);
	}
	public static Actions a;
	
	public static void moveThecursor(WebElement targetWebElement) {
		a = new Actions(dd);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragDrop(WebElement dragwebElement, WebElement dropWebElement) {
		a = new Actions(dd);
		a.dragAndDrop(dragwebElement, dropWebElement);
	}
	public static JavascriptExecutor js;
	
	public static void scrollThepage(WebElement tarwebelement) {
		js = (JavascriptExecutor)dd;
		js.executeScript("arguments[0].scrollIntoView(true)",tarwebelement);
	}
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)dd;
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	public static void excelread(String sheetname,int rowNum, int cellNum) throws IOException {
		File f = new File("sheetname.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("datas");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value = "";
		if (cellType == 1) {
			String stringCellValue = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date value2 = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String format = s.format(value2);
		}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			String vo = String.valueOf(l);
		}
	}
	public static void createNewexcelfile(int rownum, int cellnum, String newdata) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\mavenproject\\excel\\tasksample1.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("datas");
		Row newrow = newsheet.createRow(rownum);
		Cell c = newrow.createCell(cellnum);
		c.setCellValue(newdata);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	public static void createcell(int rownum, int crecell, String newdata) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\mavenproject\\excel\\tasksample1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.getRow(rownum);
		Cell c = r.createCell(crecell);
		c.setCellValue(newdata);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	public static void createrow(int crerow, int crecell, String newdata) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\mavenproject\\excel\\tasksample1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.createRow(crerow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newdata);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	public static void updateDatatoparticularcell(int gettherow,int getthecell,String existingdata,String writenewdata) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\mavenproject\\excel\\tasksample1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.createSheet("datas");
		Row r = s.getRow(gettherow);
		Cell c = r.getCell(getthecell);
		String str = c.getStringCellValue();
		if (str.equals(existingdata)) {
			c.setCellValue(writenewdata);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
