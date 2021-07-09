package locators;

public class CSSSelectors {

	public static void main(String[] args) {

		/* Find CSS Selector using Single Attribute */

		/*
		 * Syntax - tagname[attribute='value'] Example - input[id='user_login']
		 */

		/* Find CSS using Multiple attributes */

		/*
		 * Syntax- tagname[attribute1='value1'][attribute2='value2']
		 */

		/* Find CSS using id and Class name */

		/*
		 * Syntax using ID - tagname#id
		 * 
		 * Syntax using Classname - tagname.classname
		 */

		/* Find CSS using contains */

		/*
		 * Syntax- tagname[attribute*='value']
		 */

		/* Find CSS using Start-with */

		/*
		 * Syntax- tagname[attribute^='value']
		 */

		/* Find CSS using ends-with */

		/*
		 * Syntax- tagname[attribute$='value']
		 */

		/* Find CSS using first-of-type */

		/*To find specific first element
		 * Syntax- tagname:first-of-type
		 * e.g - ul>li:first-of-type
		 */
		
		/* Find CSS using last-of-type */

		/*To find specific last element
		 * Syntax- tagname:last-of-type
		 * e.g - ul>li:last-of-type
		 */
		
		/* Find CSS using nth-of-type() */

		/* To find specific index element
		 * Syntax- tagname:nth-of-type(any number)
		 * e.g - ul>li:nth-of-type(1)
		 */
		
		/* Find CSS using nth-of-type(n) */

		/* To find all the elements i.e driver.findElements()
		 * Syntax- tagname:nth-of-type(any number)
		 * e.g - ul>li:nth-of-type(n)
		 */
		
		/* Find sibling of the eleement */

		/* To find sibling of the element
		 * Syntax- parenttag + siblingtag
		 * e.g - ul+ul
		 */

		/* Note */
		/*
		 * TIP 1 - PIPELINE Using '|' operator
		 * 
		 * Eg //input[@id='txtUsername']|[//input[@name='txtUsername']]
		 */

		/*
		 * TIP 2 - Using () Index
		 * 
		 * Eg (//*[text()[@id='Click Here'])[1]
		 */
	}

}
