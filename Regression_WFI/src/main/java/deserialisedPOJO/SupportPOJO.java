package deserialisedPOJO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames= true)
public class SupportPOJO {
	
	private String url;
	private String text;

}
