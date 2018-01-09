package drools;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import util.KnowledgeSessionHelper;
import util.OutputDisplay;

@SuppressWarnings("restriction")
public class TestLesson1 {

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
		Account a = new Account();
		OutputDisplay out = new OutputDisplay();
		sessionStateful.setGlobal("out", out);
		a.setAccountNumber(123123l);
		sessionStateful.insert(a);
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testRuleOneFactWithGlobalAndCallback() {
		sessionStateful = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		
		sessionStateful.addEventListener(new RuleRuntimeEventListener() {
			
			@Override
			public void objectInserted(ObjectInsertedEvent e) {
				System.out.println("Object inserted: \n"
						+ e.getObject());
			}
			
			@Override
			public void objectUpdated(ObjectUpdatedEvent e) {
				System.out.println("Object updated: \n"
						+ e.getObject());
			}
			
			@Override
			public void objectDeleted(ObjectDeletedEvent e) {
				System.out.println("Object deleted: \n"
						+ e.getOldObject());
			}
		});
		
		Account a = new Account();
		a.setAccountNumber(123123l);
		FactHandle handle = sessionStateful.insert(a);
		a.setBalance(15);
		sessionStateful.update(handle, a);
		sessionStateful.delete(handle);
		sessionStateful.fireAllRules();
		
		System.out.println("So you saw something...");
	}
	
	
	@Test
	public void testFirstOneTwoFireAllRules() {
		sessionStateful = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay out = new OutputDisplay();
		sessionStateful.setGlobal("out", out);
		Account a = new Account();
		sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
		
		//The rule gets called only 1 time because we didn't tell drools that the rule is updated. 
		
	}
	
	@Test
	public void testFirstOneTwoFireAllRulesWithUpdateBetween() {
		sessionStateful = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay out = new OutputDisplay();
		sessionStateful.setGlobal("out", out);
		Account a = new Account();
		FactHandle handle = sessionStateful.insert(a);
		sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		sessionStateful.update(handle, a);  //fake update
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
		
		//The rule gets called twice!
		
	}
	
	
	@Test
	public void testRuleOneFactThatInsertsObject() {
		sessionStateful = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		
		OutputDisplay out = new OutputDisplay();
		sessionStateful.setGlobal("out", out);
		
		sessionStateful.addEventListener(new RuleRuntimeEventListener() {
			
			@Override
			public void objectInserted(ObjectInsertedEvent e) {
				System.out.println("Object inserted: \n"
						+ e.getObject());
			}
			
			@Override
			public void objectUpdated(ObjectUpdatedEvent e) {
				System.out.println("Object updated: \n"
						+ e.getObject());
			}
			
			@Override
			public void objectDeleted(ObjectDeletedEvent e) {
				System.out.println("Object deleted: \n"
						+ e.getOldObject());
			}
		});
		
		CashFlow c = new CashFlow();
		
		FactHandle handle = sessionStateful.insert(c);
		sessionStateful.fireAllRules();
	}
	
	
	
	
	
	
	
	
	
}
