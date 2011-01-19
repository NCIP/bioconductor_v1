package org.bioconductor.packages.caGeneFilter;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Mon Mar 30 14:04:02 2009. 
	* It represents the S4 Class EntrezFilter in R package caGeneFilter. 
	*/


public class EntrezFilter extends Filter implements java.io.Serializable  {
	private String[] annotation;

	public EntrezFilter() {
		this.annotation = new String[]{};
	}

	public EntrezFilter(
		String[] annotation){

		this.annotation = annotation;
	}

	/**
	* Sets the annotation value for this EntrezFilter
	*
	* @param	annotation	
	*/
	public void setAnnotation(String[] annotation) {
		this.annotation = annotation;
	}

	/**
	* Gets the annotation value for this EntrezFilter
	*
	* @return	the value of annotation
	*	
	*/
	public String[] getAnnotation() {
		return annotation;
	}

	/**
	* Print this EntrezFilter to String
	*
	* @return	contents of EntrezFilter as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("annotation=" + java.util.Arrays.toString( annotation ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this EntrezFilter with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			EntrezFilter obj = (EntrezFilter)inputObject;
			Object inputAnnotation = obj.getAnnotation();
			if((annotation==null)||(inputAnnotation==null))
				res = res&&(annotation==inputAnnotation);
			else
				res = res&&java.util.Arrays.equals(annotation, (String[])inputAnnotation);
		}
		return res;
	}

}
