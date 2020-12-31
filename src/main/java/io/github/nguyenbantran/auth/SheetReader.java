package io.github.nguyenbantran.auth;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Sheet;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author nguyenbantran
 */
@Slf4j
@Builder
public class SheetReader {
    
    private Sheets sheets;
    private String spreadSheetId;

    public void readAllSheet() throws IOException {
        var metadata = sheets.spreadsheets().get(spreadSheetId).execute();
        metadata.get("sheets");
        for (Sheet sheet : metadata.getSheets()) {
            var sheetProperties = sheet.getProperties();
            log.info("spread {}: sheet index {} with name '{}' and sheet_id {}", spreadSheetId,
                    sheetProperties.getIndex(), sheetProperties.getTitle(), sheetProperties.getSheetId());
        }
    }

    public void readAllDuLieuMau() throws Exception {
        var x = sheets.spreadsheets().values().get(spreadSheetId,"DulieuMau")
                .setMajorDimension("COLUMNS")
                .execute();
        System.out.println(x);
    }

    public void readAllDetailOfSheet() throws IOException {
        var x = sheets.spreadsheets().values().get(spreadSheetId, "Sheet2!A1:A1").execute();
        System.out.println(x);
    }

}
