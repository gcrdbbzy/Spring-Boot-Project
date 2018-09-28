package campinvent.uitl;

import campinvent.Dao.DataDao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileUtils {

    public static Set<DataDao> loadExcel() {
        Set<DataDao> dataDaos = new HashSet<>();

        Path path = Paths.get("src/main/resources/Data.xlsx");

        InputStream input = null;
        if (Files.exists(path)) {
            try {
                input = Files.newInputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (input != null) {
            try {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
                XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
                XSSFRow row;
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    row = (XSSFRow) rows.next();
                    try {
                        DataDao dataDao = new DataDao((int) row.getCell(0).getNumericCellValue(),
                                (int) row.getCell(2).getNumericCellValue(),
                                row.getCell(1).getBooleanCellValue(),
                                row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null,
                                row.getCell(4) != null ? AppPlatform.valueOf(row.getCell(4).getStringCellValue()) : null,
                                row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null,
                                row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null);
                        dataDaos.add(dataDao);
                    } catch (Exception e) {
                        System.out.println("Invalid Data!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataDaos;
    }
}
