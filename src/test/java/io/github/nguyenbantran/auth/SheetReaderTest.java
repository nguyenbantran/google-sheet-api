package io.github.nguyenbantran.auth;

import com.google.api.services.sheets.v4.Sheets;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nguyenbantran
 */
public class SheetReaderTest {

    /**
     * Contain 'DuLieuMau' sample
     */
    private String spreadSheetId = "1JsNpasjMOJRsBbjWVUgHNDotK_eEr1WNGJFG8QehhJE";

    /**
     * Just example spreadsheet
     */
    private String getSpreadSheetIdSample = "12KnkOF5c4hLCQVkyb-hX_AlGX2jfboOjF0rJAcvj1Qo";

    private static Sheets sheets;
    private SheetReader sheetReader;

    @BeforeClass
    public static void beforeClass() throws Exception {
        sheets = GoogleAuthorizeUtil.getSheetsService();
    }

    @Before
    public void setUp() {
        sheetReader = SheetReader.builder()
                .sheets(sheets)
                .spreadSheetId(getSpreadSheetIdSample)
                .build();
    }

    @Test
    public void readAllSheet() throws Exception {
        sheetReader.readAllSheet();
    }

    @Test
    @Ignore
    public void readAllDuLieuMau() throws Exception {
        sheetReader.readAllDuLieuMau();
    }

    @Test
    public void test() throws Exception {
        sheetReader.readAllDetailOfSheet();
    }

}
