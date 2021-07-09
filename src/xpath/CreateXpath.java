package xpath;

class CreateXpath {
	
	public static String createXpath(String xpath, Object...args) 
	{
		for(int i=0; i<args.length; i++)
		{
			xpath = xpath.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpath;
	}
	
	public static void main(String[] args) {
		String x1 = createXpath("//input[@id='{0}']", "test");
		System.out.println(x1);
		
		String x2 = createXpath("//input[@id='{0}' and @name='{1}']", "test", "test1");
		System.out.println(x2);
	}

}
