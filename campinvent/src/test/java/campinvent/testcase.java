package campinvent;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class testcase {

//	@Test
//	//normal App query
//	public void apptest1 () {
//
//		assertEquals("the app is blocked!",CampQuery.query("12345", "com.xwqeq.qweqw" , "playstore","","", 5));
//
//
//	}
//	@Test
//	// App query when input weight is less than this inventory weight
//	public void apptest2 () {
//
//		assertEquals("12345",CampQuery.query("12345", "com.xwqeq.qweqw" , "playstore","","", 1));
//
//
//	}
//	@Test
//	//App query when the input app info is not complete
//	public void apptest3 () {
//
//		assertEquals("the input infomation is invalid",CampQuery.query("12345", "" , "playstore","","", 5));
//
//
//	}
//	@Test
//	//App query when the input appname and appPlatform can not match.
//	public void apptest4 () {
//
//		assertEquals("there is no such inventoryID!",CampQuery.query("12345", "com.sdjalk.cascsa" , "playstore","","", 5));
//
//
//	}
//	@Test
//	// App query when the input campID is invalid
//	public void apptest5 () {
//
//		assertEquals("there is no such campaginID!",CampQuery.query("123hu", "com.xwqeq.qweqw" , "playstore","","", 10));
//
//
//	}
//	@Test
//	// App query when the input app info is invalid
//	public void apptest6 () {
//
//		assertEquals("there is no such inventoryID!",CampQuery.query("12345", "xcvd" , "p234","","", 10));
//
//
//	}
//
//	@Test
//	// App query when the input app info is valid and weight is less than the number, but campID is invalid
//	public void apptest7 () {
//
//		assertEquals("campID is invalid!",CampQuery.query("zxcsd", "com.xwqeq.qweqw" , "playstore","","", 0));
//
//
//	}
//
//	@Test
//	// Normal domain query
//	public void domaintest1 () {
//
//		assertEquals("12349",CampQuery.query("12349", "" , "","sdjas.ascas.com","ascas.com", 1));
//
//
//	}
//	@Test
//	// If weight is bigger, campID still out due to it's false blocked info.
//	public void domaintest2 () {
//
//		assertEquals("12349",CampQuery.query("12349", "" , "","sdjas.ascas.com","ascas.com", 4));
//
//
//	}
//	@Test
//	// even the campID is blocked, the weight is smaller, so regardless of the rule, output the campID
//	public void domaintest3 () {
//
//		assertEquals("12350",CampQuery.query("12350", "" , "","afdas.cqasc.com","cqasc.com", 1));
//
//
//	}
//	@Test
//	//The weight is bigger, query the block value. If it's true, output the domain is blocked.
//	public void domaintest4 () {
//
//		assertEquals("the domain is blocked!",CampQuery.query("12350", "" , "","afdas.cqasc.com","cqasc.com", 3));
//
//
//	}
//	@Test
//	//The campID cannot be mapped with the inventoryID
//	public void domaintest5 () {
//
//		assertEquals("campaginID is invalid!",CampQuery.query("12345", "" , "","afdas.cqasc.com","cqasc.com", 3));
//
//
//	}
//	@Test
//	//the input domain info are invalid
//	public void domaintest6 () {
//
//		assertEquals("there is no such inventoryID!",CampQuery.query("12345", "" , "","sdfs","sdfsd", 3));
//
//
//	}
//	@Test
//	//the input campID are invalid
//	public void domaintest7 () {
//
//		assertEquals("campaginID is invalid!",CampQuery.query("1jio", "" , "","afdas.cqasc.com","cqasc.com", 3));
//
//
//	}
//
//
//
//	@Test
//	//input both app and domain info
//	public void appdomaintest1 () {
//
//		assertEquals("the input infomation is invalid",CampQuery.query("12350", "sdscsd" , "sdfsf","afdas.cqasc.com","cqasc.com", 3));
//
//
//	}
//	@Test
//	// input all nothing
//	public void appdomaintest2 () {
//
//		assertEquals("the input infomation is invalid",CampQuery.query("", "" , "","","", 3));
//
//
//	}
	
	
}
