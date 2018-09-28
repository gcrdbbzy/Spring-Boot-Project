package campinvent.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryProcessorTest {

    @Test
    public void query1() {
        assertEquals("Unblocked", QueryProcessor.query(12345, "com.xwqeq.qweqw", "playstore", "", "", 1));
    }

    @Test
    public void query2() {
        assertEquals("Blocked", QueryProcessor.query(12345, "com.xwqeq.qweqw", "PLAYSTORE", "", "", 1));
    }
    
    @Test
	//App query when the input app info is not complete
	public void apptest3 () {

		assertEquals("(AppName and AppPlatform) or (DomainName and TopLevelDomain) must be all present!",QueryProcessor.query(12345, "" , "playstore","","", 5));


	}
	@Test
	//App query when the input appname and appPlatform can not match.
	public void apptest4 () {

		assertEquals("there is no such inventoryID!",QueryProcessor.query(12345, "com.sdjalk.cascsa" , "playstore","","", 5));


	}
	
	@Test
	// App query when the input app info is invalid
	public void apptest6 () {

		assertEquals("there is no such inventoryID!",QueryProcessor.query(12345, "xcvd" , "p234","","", 10));


	}

	
	@Test
	// Normal domain query
	public void domaintest1 () {

		assertEquals("Unblocked",QueryProcessor.query(12349, "" , "","sdjas.ascas.com","ascas.com", 1));


	}
	@Test
	// If weight is bigger, campID still out due to it's false blocked info.
	public void domaintest2 () {

		assertEquals("Blocked: weight not matched!",QueryProcessor.query(12349, "" , "","sdjas.ascas.com","ascas.com", 4));


	}
	@Test
	// even the campID is blocked, the weight is smaller, so regardless of the rule, output the campID
	public void domaintest3 () {

		assertEquals("Blocked",QueryProcessor.query(12350, "" , "","afdas.cqasc.com","cqasc.com", 1));


	}
	@Test
	//The weight is bigger, query the block value. If it's true, output the domain is blocked.
	public void domaintest4 () {

		assertEquals("the domain is blocked!",QueryProcessor.query(12350, "" , "","afdas.cqasc.com","cqasc.com", 3));


	}
	@Test
	//The campID cannot be mapped with the inventoryID
	public void domaintest5 () {

		assertEquals("campaginID is invalid!",QueryProcessor.query(12345, "" , "","afdas.cqasc.com","cqasc.com", 3));


	}
	@Test
	//the input domain info are invalid
	public void domaintest6 () {

		assertEquals("there is no such inventoryID!",QueryProcessor.query(12345, "" , "","sdfs","sdfsd", 3));


	}
	


	@Test
	//input both app and domain info
	public void appdomaintest1 () {

		assertEquals("the input infomation is invalid",QueryProcessor.query(12350, "sdscsd" , "sdfsf","afdas.cqasc.com","cqasc.com", 3));


	}
	@Test
	 //input all nothing
	public void appdomaintest2 () {

		assertEquals("the input infomation is invalid",QueryProcessor.query(1, "" , "","","", 3));


	}
	
    
    
}