package insights;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

public class Insights_main {

	public static void main(String[] args) {
		// Demo content from Moby Dick by Hermann Melville (Chapter 1)
		
		Insights_lib slib = new Insights_lib();
		slib.word();
		slib.show();
	}

}
