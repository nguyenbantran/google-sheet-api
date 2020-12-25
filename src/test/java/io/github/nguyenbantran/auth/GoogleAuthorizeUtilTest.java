package io.github.nguyenbantran.auth;

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

}
