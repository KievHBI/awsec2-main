package art.aws.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.util.EC2MetadataUtils;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info-server")
public class AwsController {

    @GetMapping
    public ResponseEntity<?> getAll() {

        if (SDKGlobalConfiguration.isEc2MetadataDisabled()) {
            throw new AmazonClientException("AWS_EC2_METADATA_DISABLED is set to true, not loading region from EC2 Instance "
                                            + "Metadata service");
        }

        JsonObject json = new JsonObject();
        json.addProperty("region", EC2MetadataUtils.getEC2InstanceRegion());
        json.addProperty("avZone", EC2MetadataUtils.getAvailabilityZone());
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
