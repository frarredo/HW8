/*
 * CSE 12 Homework 8
 * Francisco Arredondo, Michelle Arteaga
 * A07614106, A11468765
 * A00, A00
 * May 23, 2014
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.text.DecimalFormat;



/**
 * @author Francisco Arredondo
 * @author Michelle Arteaga
 *
 */
public class Quantity 
{
	// instance variables
	private double value;
	private Map<String,Integer> units;
	
	/**
	 * zero-argument constructor that creates a default quantity of value 1 and
	 * no units.
	 */
	public Quantity()
	{
		value = 1;
		units = new HashMap<String, Integer>();
	}
	
	/**
	 * A constructor that takes a single Quantity argument, and creates a deep
	 * copy. By deep copy here we mean that the new Quantity will be a different
	 * object with its own instance variables, and that it will contain a copy
	 * of the Map object referenced by the argument Quantity.
	 * @param toCopy	the Quantity object to be copied.
	 */
	public Quantity(Quantity toCopy)
	{
		//TODO: May need to check this for correctness with a tutor.
		value = toCopy.value;
		units = toCopy.units; // Unsure if this is how the map object should be 
							  // copied. 
	}
	
	/**
	 * This constructor takes in three parameters a double (the numeric value), 
	 * a List<String> of the units in the numerator (i.e., with positive 
	 * exponents), and a List<String>of the units in the denominator 
	 * (i.e., the units with negative exponents).
	 * If either of the list arguments is null, this method should throw an 
	 * IllegalArgumentException.
	 * @param value		the numeric value
	 * @param numer		the units in the numerator
	 * @param denom		the units in the denominator
	 */
	public Quantity(double value, List<String> numer, List<String> denom ) 
			throws IllegalArgumentException
	{
		if (numer == null || denom == null)
			throw new IllegalArgumentException();
		
		this.value = value;
		
		// This code is designed to read from a list and add the values into the map
		for (int i = 0, count = 0; i < numer.size(); ++i)
		{
			if (units.containsKey(numer.get(i)))
				units.put(numer.get(i), ++count);
			else
			{
				count = 0;
				units.put(numer.get(i), ++count);
			}
				
		}
		
		// don't know how the map adt works yet.
		//TODO: need to set the values for the map
		
	}
	
	/**
	 * This method takes a single Quantity argument, multiplies this by the
	 * argument, and returns the result.
	 * This method should throw an IllegalArgumentException if its argument 
	 * is null.
	 * @param quantity		the quantity to multiply this with
	 * @return				the result 
	 */
	public Quantity mul(Quantity quantity) throws IllegalArgumentException
	{
		if (quantity == null)
			throw new IllegalArgumentException();
		
		double product = this.value * quantity.value;
		//TODO: figure out how to multiply units
		return null;
	}
	
	/**
	 * This method takes a single Quantity argument, multiplies this by the
	 * argument, and returns the result.
	 * This method should throw an IllegalArgumentException if its argument is 
	 * null or if the value in the Quantity argument is zero.
	 * @param quantity		the quantity to multiply this with
	 * @return				the result 
	 */
	public Quantity div(Quantity divisor)
	{
		if (divisor == null || divisor.value == 0)
			throw new IllegalArgumentException();
		
		double quotient = this.value/divisor.value;
		//TODO: figure out how to multiply units
		return null;
	}
	
	/**
	 * A method pow that takes a single int argument (positive, negative, or 
	 * zero!), raises this to the given power, and returns the result.
	 * @param quantity		the quantity to multiply this with
	 * @return				the result 
	 */
	public Quantity pow(int power)
	{
		//TODO: figure out how to handle units
		return null;
	}
	
	/**
	 * A method add that takes a single Quantity argument, adds this to it, and
	 * returns the result. 
	 * This method should throw an IllegalArgumentException if its argument is 
	 * null or if the two Quantity objects do not have the same units.
	 * @param quantity		the quantity to add to the calling quantity
	 * @return				the result in a Quantity form
	 */
	public Quantity add(Quantity quantity)
	{
		// check if the units do not match throw an IllegalArgumentException
		return null;
	}
	
	
	/**
	 * A method sub that takes a single Quantity argument, subtracts it from 
	 * this, and returns the result.
	 * This method should throw an IllegalArgumentException if its argument is 
	 * null or if the two Quantity objects do not have the same units.
	 * 
	 * @param quantity
	 * @return
	 */
	public Quantity sub(Quantity quantity)
	{
		// check if the units do not match throw an IllegalArgumentException
		return null;
	}
	
	/**
	 * A method negate that takes no arguments and returns a new Quantity which 
	 * is the negation of this Quantity.
	 * @return		the negation of the calling quantity
	 */
	public Quantity negate()
	{
		return null;
	}
	
	
	/**
	 * A method toString()that returns the quantity as a String.
	 * @return		A string representation of a Quantity object
	 */
	@Override
	public String toString()
	{
		// XXX You will need to fix these lines to match your fields! 
		double valueOfTheQuantity = this.value; 
		Map<String,Integer> mapOfTheQuantity = this.units;
		// Ensure we get the units in order 
		TreeSet<String> orderedUnits = new TreeSet<String>(mapOfTheQuantity.keySet());
		StringBuffer unitsString = new StringBuffer();
		for (String key : orderedUnits) 
		{
			int expt = mapOfTheQuantity.get(key); unitsString.append(" " + key);
			if (expt != 1)
				unitsString.append("^" + expt);
		}
		// Used to convert doubles to a string with a 
		// fixed maximum number of decimal places.
		DecimalFormat df = new DecimalFormat("0.0####");
		// Put it all together and return. 
		return df.format(valueOfTheQuantity) + unitsString.toString();
	}
	
	
	/**
	 * A boolean method equals that takes any single Object, and returns true 
	 * if and only if that object is a Quantity whose units are exactly the same
	 * as the calling object and whose value is the same when rounded to five 
	 * places after the decimal point. E.g. the values 0.111112 and 0.111113 
	 * are considered equals while 0.111112 and 0.111118 are not.
	 * @param quantity		the specified object to be compared with
	 * @return				true if the quantities are equal, else return false
	 */
	@Override
	public boolean equals(Object quantity)
	{
		if (!(quantity instanceof Quantity))
			return false;
		// compare the calling quantity to the specified quantity using their string representations
		
		return false;
	}
	
	/**
	 * A method hashCode() that returns an integer, such that equal Quantities 
	 * always return the same integer.
	 */
	public int hashCode()
	{
		return this.toString().hashCode();
	}
	
	
	/**
	 * <p>A static method normalizedUnit that takes a String 
	 * (the name of a unit) and a Map<String,Quantity>(a units database). It 
	 * should create a brand-new normalized Quantity equivalent to 1 of the 
	 * given unit.</p>
	 * 
	 * <p>For example, if db is the database defined above, then 
	 * Quantity.normalizedUnit("km",db)should return the quantity 1000 meter; 
	 * Quantity.normalizedUnit("hour",db)should return the quantity 3600second; 
	 * and Quantity.normalizedUnit("kph",db)would return the quantity 0.27777...
	 * meters per second.</p>
	 * @param unitName			name of unit to be normalized
	 * @param unitsDataBase		the database to units to be searched
	 * @return					the normalized quantity
	 */
	public static Quantity normalizedUnit(String unitName, Map<String,Quantity> unitDataBase)
	{
		return null;
		
	}
	
	/**
	 * <p>A (non-static) method normalize that takes in a database in the same 
	 * format as above and returns a copy of this but in normalized form 
	 * (with all defined units expanded out into primitive units).</p>
	 * <p>For example, normalizing the quantity 60 kph, given the above 
	 * database, should produce the quantity 16.6666... meters per second.</p>
	 * @param unitDataBase		the specified database of units
	 * @return					the calling quantity as a new normalized quantity
	 */
	public Quantity normalize(Map<String,Quantity>unitDataBase)
	{
		return null;
	}
	
	
	//////////////////////// Private Helper Methods //////////////////////////
	
	/**
	 * 
	 * @param numerator
	 * @param denominator
	 */
	private void unitsListToMap(List<String> numerator, List<String> denominator)
	{
		
	}
	
	
	
	
	
	
	
	
	

}
