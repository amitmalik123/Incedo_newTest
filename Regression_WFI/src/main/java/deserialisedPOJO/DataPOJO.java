package deserialisedPOJO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames= true)
public class DataPOJO {
	
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;

}
