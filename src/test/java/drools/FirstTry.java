package drools;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import util.KnowledgeSessionHelper;

@SuppressWarnings("restriction")
public class FirstTry {

	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void before() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Test
	public void testFirstOne() {
		sessionStateful = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		sessionStateful.fireAllRules();
	}
	
	
}
