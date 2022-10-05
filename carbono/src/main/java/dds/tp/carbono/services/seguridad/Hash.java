package dds.tp.carbono.services.seguridad;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class Hash {
    public String setHashPassword(String password2) {
        String sha256hex = Hashing.sha256()
                            .hashString(password2, StandardCharsets.UTF_8)
                            .toString();
                            

        return sha256hex;
       
    }
}
