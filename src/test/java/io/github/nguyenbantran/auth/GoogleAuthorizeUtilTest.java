package io.github.nguyenbantran.auth;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nguyenbantran
 */
@Slf4j
public class GoogleAuthorizeUtilTest {

    @Test
    public void authorize_ShouldWorkOk() throws Exception {
        var credential =  GoogleAuthorizeUtil.authorize();

        assertNotNull(credential);
        log.info("refresh token {}", credential.getRefreshToken());
    }

    @Test
    public void test() throws Exception {
        var driveService = GoogleAuthorizeUtil.getDriveService();
        System.out.println(driveService);

        insertPermission(driveService, RangeConstant.SPREADSHEET_ID);


    }

    private void showAllFiles(Drive driveService) throws Exception {
        var fileList = driveService.files().list()
                .execute();

        for (var file : fileList.getFiles()) {
            log.info("{} - {}", file.getName(), file.getId());
        }
    }

    private Permission insertPermission(Drive service, String fileId) throws Exception{
        Permission newPermission = new Permission();
        newPermission.setType("anyone");
        newPermission.setRole("reader");
        return service.permissions().create(fileId, newPermission).execute();
    }

}
