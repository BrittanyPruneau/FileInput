package labFileInput;

/**
 * Defines a lake by its name, depth, and its support for boating.
 * 
 * @author Starter Code
 *
 */
public class Lake
{
	private final String name;
	private final int depth;
	private final boolean hasMarina;

	/**
	 * Initializes a newly created Lake with the information provided by the user.
	 * 
	 * @param name      Name of the lake.
	 * @param depth     Depth of the lake in meters.
	 * @param hasMarina True if the lake has a marina.
	 */
	public Lake(String name, int depth, boolean hasMarina)
	{
		this.name = name;
		this.depth = depth;
		this.hasMarina = hasMarina;
	}

	/*
	 * Gets the name of the lake. 
	 */
	public String getName()
	{
		return name;
	}

	/*
	 * Gets the depth of the lake. 
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/*
	 * Lets the user know what type of support holds the boat. 
	 */
	public boolean hasMarina()
	{
		return hasMarina;
	}

	@Override
	public String toString()
	{
		return name + " (" + depth + ") " + (hasMarina ? "*" : "");
	}
}