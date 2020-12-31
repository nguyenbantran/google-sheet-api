package io.github.nguyenbantran.auth;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import lombok.Builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nguyenbantran
 */

@Builder
public class SheetWriter {

    private Sheets sheets;
    private String spreadSheetId;

    public void writeBatchUpdate() throws IOException {

        List<Request> requests = new ArrayList<>();
        requests.add(buildDataValidationFromList());
        requests.add(buildDataValidationFromRange());

        BatchUpdateSpreadsheetRequest requestBody = new BatchUpdateSpreadsheetRequest();
        requestBody.setRequests(requests);


        Sheets.Spreadsheets.BatchUpdate request =
                sheets.spreadsheets().batchUpdate(spreadSheetId, requestBody);

        System.out.println(requestBody.toPrettyString());

        BatchUpdateSpreadsheetResponse response = request.execute();

        System.out.println(response);
    }

    private Request buildDataValidationFromList() {

        List<ConditionValue> values = new LinkedList<>();
        values.add(new ConditionValue().setUserEnteredValue("ABC"));
        values.add(new ConditionValue().setUserEnteredValue("EDF"));
        BooleanCondition booleanCondition = new BooleanCondition().setType("ONE_OF_LIST").setValues(values);

        DataValidationRule dataValidationRule = new DataValidationRule();
        dataValidationRule.setStrict(true);
        dataValidationRule.setShowCustomUi(true);
        dataValidationRule.setCondition(booleanCondition);

        var gridRange = new GridRange()
                .setSheetId(541049816)
                .setStartColumnIndex(2)
                .setEndColumnIndex(3)
                .setStartRowIndex(2)
                .setEndRowIndex(3);

        SetDataValidationRequest setData = new SetDataValidationRequest().setRange(gridRange);
        setData.setRule(dataValidationRule);


        Request request = new Request().setSetDataValidation(setData);


        return request;
    }

    private Request buildDataValidationFromRange() {

        List<ConditionValue> values = new LinkedList<>();
        values.add(new ConditionValue().setUserEnteredValue("=Sheet3!A:A"));
        BooleanCondition booleanCondition = new BooleanCondition().setType("ONE_OF_RANGE").setValues(values);

        DataValidationRule dataValidationRule = new DataValidationRule();
        dataValidationRule.setStrict(true);
        dataValidationRule.setShowCustomUi(true);
        dataValidationRule.setCondition(booleanCondition);

        var gridRange = new GridRange()
                .setSheetId(541049816)
                .setStartColumnIndex(4)
                .setEndColumnIndex(5)
                .setStartRowIndex(4)
                .setEndRowIndex(5);

        SetDataValidationRequest setData = new SetDataValidationRequest().setRange(gridRange);
        setData.setRule(dataValidationRule);


        Request request = new Request().setSetDataValidation(setData);


        return request;
    }
}
