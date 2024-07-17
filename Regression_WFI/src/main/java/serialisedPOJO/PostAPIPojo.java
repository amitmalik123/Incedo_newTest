package serialisedPOJO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostAPIPojo {
	
	private String name;
	private String job;
	private String id;
	private String createdAt;
}
