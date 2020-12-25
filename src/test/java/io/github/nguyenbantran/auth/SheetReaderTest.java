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

    private String spreadSheetId = "1JsNpasjMOJRsBbjWVUgHNDotK_eEr1WNGJFG8QehhJE";

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
                .spreadSheetId(spreadSheetId)
                .build();
    }

    @Test
    public void readAllSheet() throws Exception {
        sheetReader.readAllSheet();
    }

    @Test
    @Ignore
    public void test() throws Exception {
        sheetReader.readAllDuLieuMau();
    }

}
