package org.bioconductor.packages.caAffy;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Thu Feb 22 09:34:58 2007. 
	* It represents the S4 Class QualityControlStatistics in R package caAffy. 
	*	This class encapsulates and structures
	*	selected results from QCStats-class, as invoked
	*	by object caQAReport in R package caAffy
	*/


public class QualityControlStatistics implements java.io.Serializable  {
	private double[] scalerfactors;
	private double[] target;
	private double[] percentrpresent;
	private double[] averagerbackground;
	private double[] minimumrbackground;
	private double[] maximumrbackground;
	private org.bioconductor.packages.rservices.RJNumericMatrix spikes;
	private org.bioconductor.packages.rservices.RJNumericMatrix qcrprobes;
	private String[] bioBCalls;

	public QualityControlStatistics() {
		this.scalerfactors = new double[]{};
		this.target = new double[]{};
		this.percentrpresent = new double[]{};
		this.averagerbackground = new double[]{};
		this.minimumrbackground = new double[]{};
		this.maximumrbackground = new double[]{};
		this.spikes = new org.bioconductor.packages.rservices.RJNumericMatrix();
		this.qcrprobes = new org.bioconductor.packages.rservices.RJNumericMatrix();
		this.bioBCalls = new String[]{};
	}

	public QualityControlStatistics(
		double[] scalerfactors,
		double[] target,
		double[] percentrpresent,
		double[] averagerbackground,
		double[] minimumrbackground,
		double[] maximumrbackground,
		org.bioconductor.packages.rservices.RJNumericMatrix spikes,
		org.bioconductor.packages.rservices.RJNumericMatrix qcrprobes,
		String[] bioBCalls){

		this.scalerfactors = scalerfactors;
		this.target = target;
		this.percentrpresent = percentrpresent;
		this.averagerbackground = averagerbackground;
		this.minimumrbackground = minimumrbackground;
		this.maximumrbackground = maximumrbackground;
		this.spikes = spikes;
		this.qcrprobes = qcrprobes;
		this.bioBCalls = bioBCalls;
	}

	/**
	* Sets the scalerfactors value for this QualityControlStatistics
	*
	* @param	scalerfactors	Object of class "numeric"
	*/
	public void setScalerfactors(double[] scalerfactors) {
		this.scalerfactors = scalerfactors;
	}

	/**
	* Gets the scalerfactors value for this QualityControlStatistics
	*
	* @return	the value of scalerfactors
	*	Object of class "numeric"
	*/
	public double[] getScalerfactors() {
		return scalerfactors;
	}

	/**
	* Sets the target value for this QualityControlStatistics
	*
	* @param	target	Object of class "numeric"
	*/
	public void setTarget(double[] target) {
		this.target = target;
	}

	/**
	* Gets the target value for this QualityControlStatistics
	*
	* @return	the value of target
	*	Object of class "numeric"
	*/
	public double[] getTarget() {
		return target;
	}

	/**
	* Sets the percentrpresent value for this QualityControlStatistics
	*
	* @param	percentrpresent	Object of class "numeric"
	*/
	public void setPercentrpresent(double[] percentrpresent) {
		this.percentrpresent = percentrpresent;
	}

	/**
	* Gets the percentrpresent value for this QualityControlStatistics
	*
	* @return	the value of percentrpresent
	*	Object of class "numeric"
	*/
	public double[] getPercentrpresent() {
		return percentrpresent;
	}

	/**
	* Sets the averagerbackground value for this QualityControlStatistics
	*
	* @param	averagerbackground	Object of class "numeric"
	*/
	public void setAveragerbackground(double[] averagerbackground) {
		this.averagerbackground = averagerbackground;
	}

	/**
	* Gets the averagerbackground value for this QualityControlStatistics
	*
	* @return	the value of averagerbackground
	*	Object of class "numeric"
	*/
	public double[] getAveragerbackground() {
		return averagerbackground;
	}

	/**
	* Sets the minimumrbackground value for this QualityControlStatistics
	*
	* @param	minimumrbackground	Object of class "numeric"
	*/
	public void setMinimumrbackground(double[] minimumrbackground) {
		this.minimumrbackground = minimumrbackground;
	}

	/**
	* Gets the minimumrbackground value for this QualityControlStatistics
	*
	* @return	the value of minimumrbackground
	*	Object of class "numeric"
	*/
	public double[] getMinimumrbackground() {
		return minimumrbackground;
	}

	/**
	* Sets the maximumrbackground value for this QualityControlStatistics
	*
	* @param	maximumrbackground	Object of class "numeric"
	*/
	public void setMaximumrbackground(double[] maximumrbackground) {
		this.maximumrbackground = maximumrbackground;
	}

	/**
	* Gets the maximumrbackground value for this QualityControlStatistics
	*
	* @return	the value of maximumrbackground
	*	Object of class "numeric"
	*/
	public double[] getMaximumrbackground() {
		return maximumrbackground;
	}

	/**
	* Sets the spikes value for this QualityControlStatistics
	*
	* @param	spikes	Object of class "numeric"
	*/
	public void setSpikes(org.bioconductor.packages.rservices.RJNumericMatrix spikes) {
		this.spikes = spikes;
	}

	/**
	* Gets the spikes value for this QualityControlStatistics
	*
	* @return	the value of spikes
	*	Object of class "numeric"
	*/
	public org.bioconductor.packages.rservices.RJNumericMatrix getSpikes() {
		return spikes;
	}

	/**
	* Sets the qcrprobes value for this QualityControlStatistics
	*
	* @param	qcrprobes	Object of class "numeric"
	*/
	public void setQcrprobes(org.bioconductor.packages.rservices.RJNumericMatrix qcrprobes) {
		this.qcrprobes = qcrprobes;
	}

	/**
	* Gets the qcrprobes value for this QualityControlStatistics
	*
	* @return	the value of qcrprobes
	*	Object of class "numeric"
	*/
	public org.bioconductor.packages.rservices.RJNumericMatrix getQcrprobes() {
		return qcrprobes;
	}

	/**
	* Sets the bioBCalls value for this QualityControlStatistics
	*
	* @param	bioBCalls	Object of class "numeric"
	*/
	public void setBioBCalls(String[] bioBCalls) {
		this.bioBCalls = bioBCalls;
	}

	/**
	* Gets the bioBCalls value for this QualityControlStatistics
	*
	* @return	the value of bioBCalls
	*	Object of class "numeric"
	*/
	public String[] getBioBCalls() {
		return bioBCalls;
	}

	/**
	* Print this QualityControlStatistics to String
	*
	* @return	contents of QualityControlStatistics as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("scalerfactors=" + java.util.Arrays.toString( scalerfactors ));
		res.append(", ");
		res.append("target=" + java.util.Arrays.toString( target ));
		res.append(", ");
		res.append("percentrpresent=" + java.util.Arrays.toString( percentrpresent ));
		res.append(", ");
		res.append("averagerbackground=" + java.util.Arrays.toString( averagerbackground ));
		res.append(", ");
		res.append("minimumrbackground=" + java.util.Arrays.toString( minimumrbackground ));
		res.append(", ");
		res.append("maximumrbackground=" + java.util.Arrays.toString( maximumrbackground ));
		res.append(", ");
		res.append("spikes=" + String.valueOf( spikes ));
		res.append(", ");
		res.append("qcrprobes=" + String.valueOf( qcrprobes ));
		res.append(", ");
		res.append("bioBCalls=" + java.util.Arrays.toString( bioBCalls ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this QualityControlStatistics with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			QualityControlStatistics obj = (QualityControlStatistics)inputObject;
			Object inputScalerfactors = obj.getScalerfactors();
			if((scalerfactors==null)||(inputScalerfactors==null))
				res = res&&(scalerfactors==inputScalerfactors);
			else
				res = res&&java.util.Arrays.equals(scalerfactors, (double[])inputScalerfactors);
			Object inputTarget = obj.getTarget();
			if((target==null)||(inputTarget==null))
				res = res&&(target==inputTarget);
			else
				res = res&&java.util.Arrays.equals(target, (double[])inputTarget);
			Object inputPercentrpresent = obj.getPercentrpresent();
			if((percentrpresent==null)||(inputPercentrpresent==null))
				res = res&&(percentrpresent==inputPercentrpresent);
			else
				res = res&&java.util.Arrays.equals(percentrpresent, (double[])inputPercentrpresent);
			Object inputAveragerbackground = obj.getAveragerbackground();
			if((averagerbackground==null)||(inputAveragerbackground==null))
				res = res&&(averagerbackground==inputAveragerbackground);
			else
				res = res&&java.util.Arrays.equals(averagerbackground, (double[])inputAveragerbackground);
			Object inputMinimumrbackground = obj.getMinimumrbackground();
			if((minimumrbackground==null)||(inputMinimumrbackground==null))
				res = res&&(minimumrbackground==inputMinimumrbackground);
			else
				res = res&&java.util.Arrays.equals(minimumrbackground, (double[])inputMinimumrbackground);
			Object inputMaximumrbackground = obj.getMaximumrbackground();
			if((maximumrbackground==null)||(inputMaximumrbackground==null))
				res = res&&(maximumrbackground==inputMaximumrbackground);
			else
				res = res&&java.util.Arrays.equals(maximumrbackground, (double[])inputMaximumrbackground);
			Object inputSpikes = obj.getSpikes();
			if((spikes==null)||(inputSpikes==null))
				res = res&&(spikes==inputSpikes);
			else
				res = res&&spikes.equals(inputSpikes);
			Object inputQcrprobes = obj.getQcrprobes();
			if((qcrprobes==null)||(inputQcrprobes==null))
				res = res&&(qcrprobes==inputQcrprobes);
			else
				res = res&&qcrprobes.equals(inputQcrprobes);
			Object inputBioBCalls = obj.getBioBCalls();
			if((bioBCalls==null)||(inputBioBCalls==null))
				res = res&&(bioBCalls==inputBioBCalls);
			else
				res = res&&java.util.Arrays.equals(bioBCalls, (String[])inputBioBCalls);
		}
		return res;
	}

}