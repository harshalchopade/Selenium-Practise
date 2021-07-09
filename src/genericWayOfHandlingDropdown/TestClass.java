package genericWayOfHandlingDropdown;

public class TestClass {
	
	public enum Dropdown
	{
		INDEX
		{
			@Override
			public String toString()
			{
				return "index";
			}
		},
		VALUE
		{
			@Override
			public String toString()
			{
				return "value";
			}
		},
		VISIBLE_TEXT
		{
			@Override
			public String toString()
			{
				return "visibletext";
			}
		}
		
		
	}

}
