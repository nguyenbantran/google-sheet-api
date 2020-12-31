package io.github.nguyenbantran.auth;

import com.google.api.services.sheets.v4.Sheets;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nguyenbantran
 */
public class SheetWriterTest {

    /**
     * Just example spreadsheet
     */
    private String getSpreadSheetIdSample = "12KnkOF5c4hLCQVkyb-hX_AlGX2jfboOjF0rJAcvj1Qo";

    private static Sheets sheets;
    private SheetWriter sheetWriter;

    @BeforeClass
    public static void beforeClass() throws Exception {
        sheets = GoogleAuthorizeUtil.getSheetsService();
    }

    @Before
    public void setUp() {
        sheetWriter = SheetWriter.builder()
                .sheets(sheets)
                .spreadSheetId(getSpreadSheetIdSample)
                .build();
    }

    @Test
    public void writeBatchUpdate_ShouldUpdateValidation() throws Exception {
        sheetWriter.writeBatchUpdate();
    }
}
