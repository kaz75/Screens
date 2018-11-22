package insights;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.language_translator.v3.util.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Trait;
import com.ibm.watson.developer_cloud.service.security.IamOptions;



public class Insights_lib {
	PersonalityInsights service;
	ProfileOptions options = null;
	Profile profile;
	Profile result = null;
	String text;
			
	public Insights_lib() {
		service = new PersonalityInsights("2016-10-19");
		IamOptions iamOptions = new IamOptions.Builder()
				  .apiKey("siUwikdYLVDXN4mqDpyDF06I3pffrmx91lImIpSGQHgr")
				  .build();
		service.setIamCredentials(iamOptions);
	 }
	
	public void word()  {
		/*text = "Call me Ishmael. Some years ago-never mind how long precisely-having "
			    + "little or no money in my purse, and nothing particular to interest me on shore, "
			    + "I thought I would sail about a little and see the watery part of the world. "
			    + "It is a way I have of driving off the spleen and regulating the circulation. "
			    + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
			    + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
			    + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
			    + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
			    + "principle to prevent me from deliberately stepping into the street, and methodically "
			    + "knocking peoples hats off-then, I account it high time to get to sea as soon as I can. "
			    + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
			    + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
			    + "If they but knew it, almost all men in their degree, some time or other, cherish "
			    + "very nearly the same feelings towards the ocean with me. There now is your insular "
			    + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
			    + "it with her surf. Right and left, the streets take you waterward.";
	}*/
	
	text = "���{�́A�O���l�J���҂̎󂯓���g��ɔ����A�����N���̉����҂��}�{����z��҂ɂ��āA�N���̎󋋎��i�𓾂鐭�{�́A�O���l�J���҂̎󂯓���g��ɔ����A�����N���̉����҂��}�{����z��҂ɂ��āA�N���̎󋋎��i�𓾂鐭�{�́A�O���l�J���҂̎󂯓���g��ɔ����A�����N���̉����҂��}�{����z��҂ɂ��āA�N���̎󋋎��i�𓾂�ɂ͍����̋��Z��v���Ƃ�������Ō����ɓ������B�Q�O�P�X�N�x���ɂ��A�����N���@������������j���B" + 
			"�@���{�̔N�����x�ł́A�����N���ɉ��������Ј��炪�}�{����z��҂́A�����N���́u��R����ی��ҁv�ƌĂ΂�A�ی������x�����K�v�͂Ȃ��A�N�����󂯎�邱�Ƃ��ł���B���݂́A�z��҂ɋ��Z�n�v�����Ȃ����߁A�O���l�J���҂̔z��҂��C�O�ɏZ��ł��Ă��A�����I�ɓ��{�̔N�����󂯎�邱�Ƃ��ł���B�@���{�͈�Âɂ��āA���N�ی����K�p�����}�{�Ƒ������������ɋ��Z����l�Ɍ�����j���ł߂Ă���A�N�������l�ɁA�����ɏZ�ޔz��҂�ΏۂƂ���K�v������Ɣ��f�����B";
	
	options = new ProfileOptions.Builder()
			.contentLanguage(Language.JAPANESE)
			.acceptLanguage(Language.JAPANESE)
			.text(text)
            .build();
	
	}
	
	public void show() {
		profile = service.profile(options).execute();
		//System.out.println(profile);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(String.valueOf(profile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
		
	
		
		
		
		        MySQL mysql = new MySQL();
		        double openness = node.get("personality").get(0).get("percentile").doubleValue();
				double conscientiousness = node.get("personality").get(1).get("percentile").doubleValue();
				double extraversion = node.get("personality").get(2).get("percentile").doubleValue();
				double agreeableness = node.get("personality").get(3).get("percentile").doubleValue();
				double neuroticism = -1;
				double adventurousness = node.get("personality").get(0).get("children").get(0).get("percentile").doubleValue();
				double artistic = node.get("personality").get(0).get("children").get(1).get("percentile").doubleValue();
				double emotionality = node.get("personality").get(0).get("children").get(2).get("percentile").doubleValue();
				double imagination = node.get("personality").get(0).get("children").get(3).get("percentile").doubleValue();
				double intellect = node.get("personality").get(0).get("children").get(4).get("percentile").doubleValue();
				double challenging = node.get("personality").get(0).get("children").get(5).get("percentile").doubleValue();
				double striving = node.get("personality").get(1).get("children").get(0).get("percentile").doubleValue();
				double cautiousness = node.get("personality").get(1).get("children").get(1).get("percentile").doubleValue();
				double dutifulness = node.get("personality").get(1).get("children").get(2).get("percentile").doubleValue();
				double orderliness = node.get("personality").get(1).get("children").get(3).get("percentile").doubleValue();
				double discipline = node.get("personality").get(1).get("children").get(4).get("percentile").doubleValue();
				double efficacy = node.get("personality").get(1).get("children").get(5).get("percentile").doubleValue();
				double activity = node.get("personality").get(2).get("children").get(0).get("percentile").doubleValue();
				double assertiveness = node.get("personality").get(2).get("children").get(1).get("percentile").doubleValue();
				double cheerfulness = node.get("personality").get(2).get("children").get(2).get("percentile").doubleValue();
				double seeking = node.get("personality").get(2).get("children").get(3).get("percentile").doubleValue();
				double outgoing = node.get("personality").get(2).get("children").get(4).get("percentile").doubleValue();
				double gregariousness = node.get("personality").get(2).get("children").get(5).get("percentile").doubleValue();
				double altruism = node.get("personality").get(3).get("children").get(0).get("percentile").doubleValue();
				double cooperation = node.get("personality").get(3).get("children").get(1).get("percentile").doubleValue();
				double modesty = node.get("personality").get(3).get("children").get(2).get("percentile").doubleValue();
				double uncompromising = node.get("personality").get(3).get("children").get(3).get("percentile").doubleValue();
				double sympathy = node.get("personality").get(3).get("children").get(4).get("percentile").doubleValue();
				double trust = node.get("personality").get(3).get("children").get(5).get("percentile").doubleValue();
				double fiery = node.get("personality").get(4).get("children").get(0).get("percentile").doubleValue();
				double worry = node.get("personality").get(4).get("children").get(1).get("percentile").doubleValue();
				double melancholy = node.get("personality").get(4).get("children").get(2).get("percentile").doubleValue();
				double immoderation = node.get("personality").get(4).get("children").get(3).get("percentile").doubleValue();
				double consciousness = node.get("personality").get(4).get("children").get(4).get("percentile").doubleValue();
		        double susceptible = node.get("personality").get(4).get("children").get(5).get("percentile").doubleValue();
		
		        mysql.updateImage(openness, conscientiousness, extraversion, agreeableness, neuroticism, adventurousness, artistic, emotionality, imagination, intellect, challenging, striving, cautiousness, dutifulness, orderliness, discipline, efficacy, activity, assertiveness, cheerfulness, seeking, outgoing, gregariousness, altruism, cooperation, modesty, uncompromising, sympathy, trust, fiery, worry, melancholy, immoderation, consciousness, susceptible, text);
				
				System.out.println("Openness(�m�I�D��S)���� = "+openness);
		        System.out.println("Adventurousness(��_��) = "+adventurousness+", Artistic interests(�|�p�I�֐S�x) = "+artistic+", Emotionality(���) = "+emotionality+", Imagination(�z����) = "+imagination+", Intellect(�v�l��) = "+intellect+", Authority-challenging(����Ŕj) = "+challenging+"");
		        System.out.println("Conscientiousness(������)���� = "+conscientiousness+"");
		        System.out.println("Achievement striving(�B���w��) = "+striving+", Cautiousness(���Ӑ[��) = "+cautiousness+", Dutifulness(������) = "+dutifulness+", Orderliness(������) = "+orderliness+", Self-discipline(������) = "+discipline+", Self-efficacy(���Ȍ��͊�) = "+efficacy+"");
		        System.out.println("Extraversion(�O����)���� = "+extraversion+"");
		        System.out.println("Activity level(�����x) = "+activity+", Assertiveness(���Ȏ咣) = "+assertiveness+", Cheerfulness(���N��) = "+cheerfulness+", Excitement-seeking(�h���󋁐�) = "+seeking+", Outgoing(�F�D��) = "+outgoing+", Gregariousness(�Ќ�) = "+gregariousness+"");
		        System.out.println("Agreeableness(������)���� = "+agreeableness+"");
		        System.out.println("Altruism(������`) = "+altruism+", Cooperation(������) = "+cooperation+", Modesty(������) = "+modesty+", Uncompromising(���d��) = "+uncompromising+", Sympathy(�����x) = "+sympathy+", Trust(�M�p�x) = "+trust+"");
		        System.out.println("Neuroticism(����N��)���� = "+neuroticism+"");
		System.out.println("Fiery(����I) = "+fiery+", Prone to worry(�S�z��) = "+worry+", Melancholy(�ߊϓI) = "+melancholy+", Immoderation(���ȓI) = "+immoderation+", Self-consciousness(���ӎ��ߏ�) = "+consciousness+", Susceptible to stress(��X�g���X�ϐ�) = "+susceptible+"");
		//		mysql.updateImage();
	}
	
}
