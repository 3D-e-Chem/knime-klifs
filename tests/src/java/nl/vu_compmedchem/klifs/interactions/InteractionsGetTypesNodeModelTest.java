package nl.vu_compmedchem.klifs.interactions;

import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.util.LockFailedException;
import org.knime.testing.core.TestrunConfiguration;

import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;

public class InteractionsGetTypesNodeModelTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	private TestFlowRunner runner;
	
	@Before
	public void setUp() {
	    TestrunConfiguration runConfiguration = new TestrunConfiguration();
	    runner = new TestFlowRunner(collector, runConfiguration);
	}
	
	@Test
	public void test_simple() throws IOException, InvalidSettingsException, CanceledExecutionException,
	        UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
	    new Thread(new Runnable() {
	    	public void run() {
		    	SwingUtilities.invokeLater(new Runnable() {
	      			public void run() {
	      				File workflowDir = new File("src/knime/KLIFS-testflows");
	      				try {
			    			runner.runTestWorkflow(workflowDir);
			    		} catch (Exception e){
			    			System.out.println(e.toString());
			    		}
			    	}
			    });
		    }
	    }).start();
	}
}
