package automation;

import automation.utils.TestData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import paginas.PaginaLoginBase;

import java.lang.reflect.Method;
import java.sql.SQLException;

public abstract class ProjectBase extends AbstractTest {
	protected TestData currentData;
	protected int tentativas = 0;
	protected static final int MAXIMOTENTATIVAS = 4;

	@BeforeClass
	public void setUpClass(String sys) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		super.setUpClass(sys);
		
	}

	@BeforeMethod
	public void setUpMethod(ITestContext testContext, Method method, Object[] data) throws Exception {
		super.setUpMethod(testContext, method, data);

		try{
			getPaginas().get(PaginaLoginBase.class).openLogin(baseUrl);
		}catch(Exception ex){
			System.out.println(ex);

		}
	}

	
	public void setUpMethod() throws Exception {
		super.setUpMethod();
		getPaginas().get(PaginaLoginBase.class).openLogin(baseUrl);
	}

	protected void assertEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

}


