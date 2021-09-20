package locators;

public class DynamicXPath {

	public static void main(String[] args) {

		/*Using single attribute*/

		/*Syntax*/
		
		//tagname[@attribute-name='value1']
		
		//Example
		 
		//a[@href='http://www.google.com']
		//input[@id='name']
		//input[@name='username']
		//img[@alt='sometext']
		
		
		/*Using multiple attribute*/
		
		/*Syntax*/
		//tagname[@attribute1='value1'][@attribute2='value2']
		
		//Example
			
	    //a[@id='id1'][@name='namevalue1']		 
	   //img[@src=''][@href='']
		
		/*Using contains method*/
		
		/*Syntax*/
		//tagname[contains(@attribute,'value1')]
		 
		//Example

		//input[contains(@id,'')] 
		//input[contains(@name,'')]
		//a[contains(@href,'')]
		//img[contains(@src,'')]
		//div[contains(@id,'')]
		
		
		/*Using starts-with method*/
		
		/*Syntax*/
		//tagname[starts-with(@attribute-name,'')]
				 
		//Example
		//id[starts-with(@id,'')]
		//a[starts-with(@href='')]
		//img[starts-with(@src='')]
		//div[starts-with(@id='')]
		//input[starts-with(@id='')]
		//button[starts-with(@id,'')]
		
		/*Note
		 * In xpath // stands for search for the specific element through out the page.if present in the starting of xpath
		 * If xpath start with //* means it we are not specifying the specific element (tag) 
		   we are searching all the elements on the page whichever attribute we are going to provide. 
		   
		 * '.[DOT]' will be used to to match a node such as element, attribute or text node or an atomic value such
		   as string, number, boolean.
		   
		 * And '.' notation represents the current node in the DOM.
		 
		 * Using text() we can get text only upto the first inner element, <div> "text" </div>
		   But if text is after the first inner element i.e text2 , text3 then we must use the current node to search 
		   the string and not text()
		  
		   <div> "text" 
		   
		   <em> "text2" </em>
		   
		   "text3"
		   
		   </div>
		   
		 * E.g //div[contains(text(),'But After')] VS //div[contains(.,'But After')] */
		
		//If we want to check whether element we are identifying contains specifics tags or use below syntax
		
		// e.g 1. tr[4]//td[(text())]
		//e.g 2. tr[4]//td[(@id)]
		//Here we directly mentioned the text(), @id inside td tag, so it will return only those td
		//which are having text or id attribute present.
		
		
		//Also when we need to check specific tag, text etc is not present in webelement use not();
		//e.g //tr[4]//td[not(text())]
		
		//tr[4]//td[not(@id)]
		
		//Also we can use contains() inside not() 
		// a[not(contains(@id, 'xx'))
	}
}
