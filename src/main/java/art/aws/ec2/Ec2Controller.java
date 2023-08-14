package art.aws.ec2;

import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class Ec2Controller {

    @GetMapping
    public ResponseEntity<?> getAll() {
        com.google.gson.JsonObject json = new JsonObject();
        json.addProperty("region", "eu-central-1");
        json.addProperty("avZone", "eu-central-1a");
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
