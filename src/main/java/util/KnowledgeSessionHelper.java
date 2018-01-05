package util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {
	
	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		return kieContainer;
	}
	
	public static StatelessKieSession getStatelessKieSession(KieContainer kieContainer, String sessionName) {
		return kieContainer.newStatelessKieSession(sessionName);
	}
	
	public static KieSession getStatefullKnowledgeSession(KieContainer container, String sessionName) {
		return container.newKieSession(sessionName);
	}

}
