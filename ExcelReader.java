package com.deepakchandwani.hazelcast;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "D:\\HazelCast\\boot-hazelcast\\sample-xlsx-file.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));



        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // 3. Or you can use a Java 8 forEach with lambda
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });



        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        Workbook workbookW = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheetw = workbookW.createSheet("Generated");

        Iterator<Row> rowIterator = sheet.rowIterator();
        int rowid=0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Row cRow = sheetw.createRow(rowid++);
            cRow.setHeightInPoints(row.getHeightInPoints());
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            DataFormatter dataFormatter = new DataFormatter();
             int cellId=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Cell cCell= cRow.createCell(cellId++);
                 String cellValue = dataFormatter.formatCellValue(cell);
                //cCell.setCellValue(cell.getRichStringCellValue());

                switch (cell.getCellTypeEnum()) {
                    case BOOLEAN:
                        cCell.setCellValue(cell.getBooleanCellValue());
                        break;
                    case STRING:
                        cCell.setCellValue(cell.getRichStringCellValue());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            cCell.setCellValue(cell.getDateCellValue());
                        } else {
                            cCell.setCellValue(cell.getNumericCellValue());
                        }
                        break;
                    case FORMULA:
                        cCell.setCellValue(cell.getCellFormula());
                        break;
                    case BLANK:
                        cCell.setCellValue("");
                        break;
                    default:
                        cCell.setCellValue("");
                }

                copyCell(cell, cCell);

                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        Row rowCopyColumnSize = sheet.getRow(0);
        int start = rowCopyColumnSize.getFirstCellNum();
        int last = sheet.getRow(0).getLastCellNum();

        Row rowCopyColumnSizeT = sheet.getRow(0);

        for (int i =start; i<last; i++){
            int columnWidth = workbook.getSheetAt(0).getColumnWidth(i);
            workbookW.getSheetAt(0).autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
        workbookW.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    public static int poiWidthToPixels(final double widthUnits) {
        if (widthUnits <= 256) {
            return (int) Math.round((widthUnits / 28));
        } else {
            return (int) (Math.round(widthUnits * 9 / 256));
        }
    }

    private static HashMap<Integer, CellStyle> styleMap = new HashMap<Integer, CellStyle>();
    public static  void copyCell(Cell oldCell, Cell newCell){
        int styleHashCode = oldCell.getCellStyle().hashCode();
        CellStyle newCellStyle = styleMap.get(styleHashCode);
        if(newCellStyle == null){
            newCellStyle = newCell.getSheet().getWorkbook().createCellStyle();
            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
            styleMap.put(styleHashCode, newCellStyle);
        }
        newCell.setCellStyle(newCellStyle);
    }
}
