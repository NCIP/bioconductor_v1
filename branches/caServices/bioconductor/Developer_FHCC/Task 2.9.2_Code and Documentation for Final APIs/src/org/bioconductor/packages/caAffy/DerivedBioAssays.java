package org.bioconductor.packages.caAffy;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import org.bioconductor.packages.caAffy.util.MageMapper;
import org.bioconductor.packages.rservices.RJNumericMatrix;

	/**
	* This file was auto-generated by R function 
	* createJavaBean Wed Feb 28 09:49:05 2007. 
	* It represents the S4 Class DerivedBioAssays in R package caAffy. 
	*	A class representing a collection of
	*	derived expression values
	*/


public class DerivedBioAssays implements java.io.Serializable  {
	private gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] bioAssays;

	public DerivedBioAssays() {
	    this.bioAssays = new gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[0];
	}

	public DerivedBioAssays(gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] bioAssays) {
		this.bioAssays = bioAssays;
	}

	/**
	* Sets the bioAssays value for this DerivedBioAssays
	*
	* @param	bioAssays	
	*/
	public void setBioAssays(gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] bioAssays) {
		this.bioAssays = bioAssays;
	}

	/**
	* Get the bioAssays value for this DerivedBioAssays
	*
	* @return	the value of bioAssays
	*	
	*/
	public gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] getBioAssays() {
		return bioAssays;
	}

	/**
	* R interface to sets the bioAssays value for this DerivedBioAssays
	*
	* @param	rjNumericMatrix	
	*/
	public void rsetBioAssays(org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix) {
		MageMapper mapper = new MageMapper();
		BioAssay[] bioAssays = mapper.toBioAssay(rjNumericMatrix);
		DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i = 0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		this.bioAssays = dBADs;
	}

	/**
	* R interface to get the bioAssays value for this DerivedBioAssays
	*
	* @return	the value of bioAssays
	*	
	*/
	public org.bioconductor.packages.rservices.RJNumericMatrix rgetBioAssays() throws Exception {
		MageMapper mapper = new MageMapper();
		return mapper.toRJNumericMatrix(bioAssays);
	}


	/**
	* Print this DerivedBioAssays to String
	*
	* @return	contents of DerivedBioAssays as a String
	*/
	public String toString() {
		StringBuffer res=new StringBuffer("{");
		res.append("bioAssays=" + String.valueOf( bioAssays ));
		res.append("}");
		return res.toString();
	}

	/**
	* Compare this DerivedBioAssays with the input data.
	*
	* @param inputObject	the data to be compared with.
	* @return	true if the two have the same contents, false otherwise.
	*/
	public boolean equals(Object inputObject) {
		boolean res = getClass().equals(inputObject.getClass());
		if(res){
			DerivedBioAssays obj = (DerivedBioAssays)inputObject;
			DerivedBioAssay[] inputBioAssays = obj.getBioAssays();
			if((bioAssays==null)||(inputBioAssays==null))
				res = res&&(bioAssays==inputBioAssays);
			else {
				res = res && (bioAssays.length == inputBioAssays.length);
				if (res)
					for (int i=0; i<bioAssays.length; ++i)
						res = res&&bioAssays[i].equals(inputBioAssays[i]);
			}
		}
		return res;
	}

}