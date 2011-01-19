package org.bioconductor.packages.caGeneFilter;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Mon Mar 30 14:04:02 2009. 
	* It represents the S4 Class MissingValueFilter in R package caGeneFilter. 
	*/


public class MissingValueFilter extends Filter implements java.io.Serializable  {
	private double[] missingValue;
	private int[] minimumElementNumber;

	public MissingValueFilter() {
		this.missingValue = new double[]{};
		this.minimumElementNumber = new int[]{};
	}

	public MissingValueFilter(
		double[] missingValue,
		int[] minimumElementNumber){

		this.missingValue = missingValue;
		this.minimumElementNumber = minimumElementNumber;
	}

	/**
	* Sets the missingValue value for this MissingValueFilter
	*
	* @param	missingValue	
	*/
	public void setMissingValue(double[] missingValue) {
		this.missingValue = missingValue;
	}

	/**
	* Gets the missingValue value for this MissingValueFilter
	*
	* @return	the value of missingValue
	*	
	*/
	public double[] getMissingValue() {
		return missingValue;
	}

	/**
	* Sets the minimumElementNumber value for this MissingValueFilter
	*
	* @param	minimumElementNumber
	*/
	public void setMinimumElementNumber(int[] minimumElementNumber) {
		this.minimumElementNumber = minimumElementNumber;
	}

	/**
	* Gets the minimumElementNumber value for this MissingValueFilter
	*
	* @return	the value of minimumElementNumber
	*	
	*/
	public int[] getMinimumElementNumber() {
		return minimumElementNumber;
	}

	/**
	* Print this MissingValueFilter to String
	*
	* @return	contents of MissingValueFilter as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("missingValue=" + java.util.Arrays.toString( missingValue ));
		res.append(", ");
		res.append("minimumElementNumber=" + java.util.Arrays.toString( minimumElementNumber ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this MissingValueFilter with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			MissingValueFilter obj = (MissingValueFilter)inputObject;
			Object inputMissingValue = obj.getMissingValue();
			if((missingValue==null)||(inputMissingValue==null))
				res = res&&(missingValue==inputMissingValue);
			else
				res = res&&java.util.Arrays.equals(missingValue, (double[])inputMissingValue);
			Object inputMinimumElementNumber = obj.getMinimumElementNumber();
			if((minimumElementNumber==null)||(inputMinimumElementNumber==null))
				res = res&&(minimumElementNumber==inputMinimumElementNumber);
			else
				res = res&&java.util.Arrays.equals(minimumElementNumber, (int[])inputMinimumElementNumber);
		}
		return res;
	}

}
