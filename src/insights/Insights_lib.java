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
	
	text = "政府は、外国人労働者の受け入れ拡大に備え、厚生年金の加入者が扶養する配偶者について、年金の受給資格を得る政府は、外国人労働者の受け入れ拡大に備え、厚生年金の加入者が扶養する配偶者について、年金の受給資格を得る政府は、外国人労働者の受け入れ拡大に備え、厚生年金の加入者が扶養する配偶者について、年金の受給資格を得るには国内の居住を要件とする方向で検討に入った。２０１９年度中にも、国民年金法を改正する方針だ。" + 
			"　日本の年金制度では、厚生年金に加入する会社員らが扶養する配偶者は、国民年金の「第３号被保険者」と呼ばれ、保険料を支払う必要はなく、年金を受け取ることができる。現在は、配偶者に居住地要件がないため、外国人労働者の配偶者が海外に住んでいても、将来的に日本の年金を受け取ることができる。　政府は医療について、健康保険が適用される扶養家族を原則国内に居住する人に限る方針を固めており、年金も同様に、国内に住む配偶者を対象とする必要があると判断した。";
	
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
				
				System.out.println("Openness(知的好奇心)属性 = "+openness);
		        System.out.println("Adventurousness(大胆性) = "+adventurousness+", Artistic interests(芸術的関心度) = "+artistic+", Emotionality(情動性) = "+emotionality+", Imagination(想像力) = "+imagination+", Intellect(思考力) = "+intellect+", Authority-challenging(現状打破) = "+challenging+"");
		        System.out.println("Conscientiousness(誠実性)属性 = "+conscientiousness+"");
		        System.out.println("Achievement striving(達成努力) = "+striving+", Cautiousness(注意深さ) = "+cautiousness+", Dutifulness(忠実さ) = "+dutifulness+", Orderliness(秩序性) = "+orderliness+", Self-discipline(自制力) = "+discipline+", Self-efficacy(自己効力感) = "+efficacy+"");
		        System.out.println("Extraversion(外向性)属性 = "+extraversion+"");
		        System.out.println("Activity level(活発度) = "+activity+", Assertiveness(自己主張) = "+assertiveness+", Cheerfulness(明朗性) = "+cheerfulness+", Excitement-seeking(刺激希求性) = "+seeking+", Outgoing(友好性) = "+outgoing+", Gregariousness(社交性) = "+gregariousness+"");
		        System.out.println("Agreeableness(協調性)属性 = "+agreeableness+"");
		        System.out.println("Altruism(利他主義) = "+altruism+", Cooperation(協働性) = "+cooperation+", Modesty(謙虚さ) = "+modesty+", Uncompromising(強硬さ) = "+uncompromising+", Sympathy(共感度) = "+sympathy+", Trust(信用度) = "+trust+"");
		        System.out.println("Neuroticism(感情起伏)属性 = "+neuroticism+"");
		System.out.println("Fiery(激情的) = "+fiery+", Prone to worry(心配性) = "+worry+", Melancholy(悲観的) = "+melancholy+", Immoderation(利己的) = "+immoderation+", Self-consciousness(自意識過剰) = "+consciousness+", Susceptible to stress(低ストレス耐性) = "+susceptible+"");
		//		mysql.updateImage();
	}
	
}
