package deserialisedPOJO;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames= true)
public class ListUsersPOJO {	
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<DataPOJO> data;
	private SupportPOJO support;
}
