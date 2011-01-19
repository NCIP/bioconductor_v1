package org.bioconductor.packages.caLinearModel.service;

import java.rmi.RemoteException;

import org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResource;
import org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResourceHome;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaLinearModelImpl extends CaLinearModelImplBase {
	private static final String RED = "Cy5";
	private static final String GREEN = "Cy3";

	private org.bioconductor.rserviceJms.services.caLinearModel.caLinearModel m_caLinearModel = null;
	private java.util.HashMap m_resourceKeyMap = new java.util.HashMap<String, org.globus.wsrf.ResourceKey>();
	private java.util.HashMap m_serviceHomenameMap = new java.util.HashMap<String, String>();
	
	public CaLinearModelImpl() throws RemoteException {
		super();
		
		try {
			m_caLinearModel = new org.bioconductor.rserviceJms.services.caLinearModel.caLinearModel();
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
		
	}
	
  public org.bioconductor.cagrid.data.TopTableCollection fit(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.OneChannelModel oneChannelModel) throws RemoteException {
	  
	  try {
		  //type mapping: cagrid oneChannelModel will be splitted into two parts in R:
		  // one is R OneChannelModel, the other is R OneChannelSampleAnnotion:
		  
		  // define R types:
		  org.bioconductor.packages.caLinearModel.OneChannelModel rOneChannelModel = null;
		  org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoCollection = null;
		  
		  
		  // cagrid OneChannelModel to R OneChannelModel:
		   
		  if (oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.TTest) {
			  // R OneChannelModel mapping:
			  String[] strSampleAnnotationCollectionTestColumnName = new String[] {"TTestFactor"};
			  
			  org.bioconductor.cagrid.calinearmodel.TTest cagridTTest = (org.bioconductor.cagrid.calinearmodel.TTest)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.TTest();
			  ((org.bioconductor.packages.caLinearModel.TTest)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionTestColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridTTest.getNumberOfTopReporters()});

			  // R OneChannelSampleAnnotation mapping:
			  org.bioconductor.cagrid.calinearmodel.TTestAnnotation[] cagridTTestAnnoArr = cagridTTest.getTTestAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridTTestAnnoArr.length];
			  String[] strSampleChannels = new String[cagridTTestAnnoArr.length];
			  for(int i = 0; i < cagridTTestAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridTTestAnnoArr[i].getSampleName();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridTTestAnnoArr[i].getFactorLevel().getValue();
			  }
			  
			  // Construct RJDataFrame:
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionTestColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			
		  }
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.PairedTTest) {
			  String[] strSampleAnnotationCollectionTestColumnName = new String[] {"TTestFactor"};
			  String[] strSampleAnnotationCollectionPairingColumnName = new String[] {"PairIdentifier"};
			  
			  org.bioconductor.cagrid.calinearmodel.PairedTTest cagridPairTTest = (org.bioconductor.cagrid.calinearmodel.PairedTTest)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.PairedTTest();
			  ((org.bioconductor.packages.caLinearModel.PairedTTest)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionTestColumnName);
			  ((org.bioconductor.packages.caLinearModel.PairedTTest)rOneChannelModel).setSampleAnnotationCollectionPairingColumnName(strSampleAnnotationCollectionPairingColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridPairTTest.getNumberOfTopReporters()});
			  
			  org.bioconductor.cagrid.calinearmodel.PairedTTestAnnotation[] cagridPairedTTestAnnoArr = cagridPairTTest.getPairedTTestAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSampleChannels = new String[cagridPairedTTestAnnoArr.length];
			  String[] strSamplePairIdensCollection = new String[cagridPairedTTestAnnoArr.length];
			  for(int i = 0; i < cagridPairedTTestAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridPairedTTestAnnoArr[i].getSampleName();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridPairedTTestAnnoArr[i].getFactorLevel().getValue();
				  strSamplePairIdensCollection[i] = cagridPairedTTestAnnoArr[i].getPairIdentifier();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionTestColumnName[0], strSampleAnnotationCollectionPairingColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection, strSamplePairIdensCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			  
		  }
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.OneFactorANOVA) {
			  String[] strSampleAnnotationCollectionFactorColumnName = new String[] {"ANOVAFactor"};
			  
			  org.bioconductor.cagrid.calinearmodel.OneFactorANOVA cagridOneFactorANOVA = (org.bioconductor.cagrid.calinearmodel.OneFactorANOVA)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.OneFactorANOVA();
			  ((org.bioconductor.packages.caLinearModel.OneFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnotationCollectionFactorColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridOneFactorANOVA.getNumberOfTopReporters()});

			  org.bioconductor.cagrid.calinearmodel.OneFactorANOVAAnnotation[] cagridOneFactorANOVAAnnoArr = cagridOneFactorANOVA.getOneFactorANOVAAnnotation();
			  String[] strSampleAnnoCollection = new String[cagridOneFactorANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridOneFactorANOVAAnnoArr.length];
			  String[] strSampleChannels = new String[cagridOneFactorANOVAAnnoArr.length];
			  for(int i = 0; i < cagridOneFactorANOVAAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridOneFactorANOVAAnnoArr[i].getSampleName();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleAnnoCollection[i] = cagridOneFactorANOVAAnnoArr[i].getFactorLevel().getValue();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionFactorColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
		  }
/*	
 * 		  TwoFactorANOVA is deprecated....
 * 	  
		  else if(oneChannelModel instanceof org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA) {
			  // OneChannelModel mapping:
			  String[] strSampleAnnotationCollectionFactorOneColumnName = new String[] {"ANOVAFactorOne"};
			  String[] strSampleAnnotationCollectionFactorTwoColumnName = new String[] {"ANOVAFactorTwo"};
			  
			  org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA cagridTwoFactorANOVA = (org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA)oneChannelModel;
			  rOneChannelModel = new org.bioconductor.packages.caLinearModel.TwoFactorANOVA();
			  ((org.bioconductor.packages.caLinearModel.TwoFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionFactorOneColumnName(strSampleAnnotationCollectionFactorOneColumnName);
			  ((org.bioconductor.packages.caLinearModel.TwoFactorANOVA)rOneChannelModel).setSampleAnnotationCollectionFactorTwoColumnName(strSampleAnnotationCollectionFactorTwoColumnName);
			  rOneChannelModel.setNumberOfTopReporters(new int[]{cagridTwoFactorANOVA.getNumberOfTopReporters()});
			  
			  // OneChannelSampleAnnotation mapping:
			  org.bioconductor.cagrid.calinearmodel.TwoFactorANOVAAnnotation[] cagridTwoFactorANOVAAnnoArr = cagridTwoFactorANOVA.getTwoFactorANOVAAnnotation();
			  String[] strSampleFactorOneAnnoCollection = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleFactorTwoAnnoCollection = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridTwoFactorANOVAAnnoArr.length];
			  String[] strSampleChannels = new String[cagridTwoFactorANOVAAnnoArr.length];			  
			  for(int i = 0; i < cagridTwoFactorANOVAAnnoArr.length; i++) {
				  strSampleIdens[i] = cagridTwoFactorANOVAAnnoArr[i].getSampleName();
				  strSampleChannels[i] = "ChannelOne";
				  strSampleFactorOneAnnoCollection[i] = cagridTwoFactorANOVAAnnoArr[i].getFactorOneLevel().getValue();
				  strSampleFactorTwoAnnoCollection[i] = cagridTwoFactorANOVAAnnoArr[i].getFactorTwoLevel().getValue();
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnotationCollectionFactorOneColumnName[0], strSampleAnnotationCollectionFactorTwoColumnName[0] });
			  rjDataFrame.setRowNames(strSampleIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strSampleChannels, strSampleFactorOneAnnoCollection, strSampleFactorTwoAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
		  }
*/		  
		  else {
			  throw new RemoteException("CaLinearModelImpl::fit - Undefined OneChannelModel " + oneChannelModel.getClass().getName());
		  }
		  
		  // cagrid SingleChannelExpressionDataCollection to R OneChannelExpressionData:
		  org.bioconductor.packages.caCommonClasses.OneChannelExpressionData oneChanExpData = this.cagridSingleChanExpDataToROneChanExpData(singleChannelExpressionDataCollection);
		  
		  org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection = m_caLinearModel.fit(rOneChannelModel, oneChanExpData, rSampleAnnoCollection);
		  
		  return this.rTopTableCollectionToCagridTopTableCollection(rTopTableCollection);
		  
		  
	  }
	  catch(java.lang.NullPointerException ew) {
		  ew.printStackTrace();
		  throw new RemoteException("CaLinearModel::fit() - NullPointerException: " + ew);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  public org.bioconductor.cagrid.data.TopTableCollection twoChannelFit(org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.TwoChannelModel twoChannelModel) throws RemoteException {
	  // type mapping: cagrid ToChannelModel will be splitted into 2 parts:
	  // one is R TwoChannelModel, the other is TwoChannelSampleAnnotation:
	  org.bioconductor.packages.caLinearModel.TwoChannelModel rTwoChannelModel = null;
	  org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoCollection = null;
	  
	  try {
		  if(twoChannelModel instanceof org.bioconductor.cagrid.calinearmodel.DyeSwapTTest) {
			  
			  // R TwoChannelModel mapping:
			  rTwoChannelModel = new org.bioconductor.packages.caLinearModel.DyeSwapTTest();
			  rTwoChannelModel.setNumberOfTopReporters(new int[]{twoChannelModel.getNumberOfTopReporters()});			
			  /* R deprecates referenceChannelIdentifier
			  String strColorChannelReferenceLevel = this.forceToRedOrGreen(twoChannelModel.getReferenceChannelIdentifier()); 
			  if(strColorChannelReferenceLevel.equals("Unknown")) throw new RemoteException("CaLinearModelImpl::twoChannelFit() - Unknown reference channel identifier: " + twoChannelModel.getReferenceChannelIdentifier() + ". Accepted only: Cy5, Cy3, Red or Green (case-insensitive)");			  
			  rTwoChannelModel.setChannelReferenceLevel(new String[]{strColorChannelReferenceLevel});
			  */
			  
			  // downcast cagrid TwoChannelModel to a specific type of cagrid DyeSwapTTest 
			  org.bioconductor.cagrid.calinearmodel.DyeSwapTTest cagridDyeSwapTTest = (org.bioconductor.cagrid.calinearmodel.DyeSwapTTest)twoChannelModel;
			  
			  // R TwoChannelModel:
			  String[] strSampleAnnoCollTestColName = new String[]{"DyeSwapTTestFactor"};
			  String[] strTestRefLevel = new String[]{cagridDyeSwapTTest.getReferenceLevel().getValue()};
			  
			  ((org.bioconductor.packages.caLinearModel.DyeSwapTTest)rTwoChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnoCollTestColName);
			  ((org.bioconductor.packages.caLinearModel.DyeSwapTTest)rTwoChannelModel).setTestReferenceLevel(strTestRefLevel);
			  
			  
			  // R TwoChannelSampleAnnotation:			 
			  org.bioconductor.cagrid.calinearmodel.DyeSwapTTestAnnotation[] cagridDyeSwapTTestAnnoArr = cagridDyeSwapTTest.getDyeSwapTTestAnnotation();
			  
			  
			  String[] strSampleFactorLevelAnnoCollection = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strChannelIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strSampleIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  String[] strRownameIdens = new String[cagridDyeSwapTTestAnnoArr.length];
			  
			  for(int i = 0; i < cagridDyeSwapTTestAnnoArr.length; i++) {
				  strChannelIdens[i] = this.forceToRedOrGreen(cagridDyeSwapTTestAnnoArr[i].getChannelIdentifier());
				  strSampleIdens[i] = cagridDyeSwapTTestAnnoArr[i].getSampleName();				  
				  strSampleFactorLevelAnnoCollection[i] = cagridDyeSwapTTestAnnoArr[i].getFactorLevel().getValue();	
				  strRownameIdens[i] = strSampleIdens[i] + "." + strChannelIdens[i];
			  }
			  			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnoCollTestColName[0]});
			  rjDataFrame.setRowNames(strRownameIdens);
			  rjDataFrame.setData(new Object[] { strSampleIdens, strChannelIdens, strSampleFactorLevelAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			  
		  }
		  else if(twoChannelModel instanceof org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA) {
			// R TwoChannelModel mapping:
			  rTwoChannelModel = new org.bioconductor.packages.caLinearModel.CommonReferenceANOVA();
			  rTwoChannelModel.setNumberOfTopReporters(new int[]{twoChannelModel.getNumberOfTopReporters()});
			  /* R deprecated referenceChannelIdentifier
			  String strColorChannelReferenceLevel = this.forceToRedOrGreen(twoChannelModel.getReferenceChannelIdentifier());
			  if(strColorChannelReferenceLevel.equals("Unknown")) throw new RemoteException("Unknown reference channel identifier: " + twoChannelModel.getReferenceChannelIdentifier());
			  rTwoChannelModel.setChannelReferenceLevel(new String[]{strColorChannelReferenceLevel});
			  */
			  
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA commonRefANOVA = (org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA)twoChannelModel;
			  
			  String[] strSampleAnnoCollTestColName = new String[]{"CommonReferenceANOVAFactor"};
			  String[] strTestRefLevel = commonRefANOVA.getReferenceLevel() != null ? new String[]{commonRefANOVA.getReferenceLevel().getValue()} : new String[0];
			  
			  ((org.bioconductor.packages.caLinearModel.CommonReferenceANOVA)rTwoChannelModel).setSampleAnnotationCollectionTestColumnName(strSampleAnnoCollTestColName);
			  ((org.bioconductor.packages.caLinearModel.CommonReferenceANOVA)rTwoChannelModel).setTestReferenceLevel(strTestRefLevel);
			  
			  // R TwoChannelSampleAnnotation:
			  // downcast cagrid TwoChannelModel to a specific type of cagrid CommonReferenceANOVA
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA cagridCommonRefANOVA = (org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA)twoChannelModel;
			  org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVAAnnotation[] cagridCommonRefANOVAAnnoArr = cagridCommonRefANOVA.getCommonReferenceANOVAAnnotation();
			  
			  String[] strSampleFactorLevelAnnoCollection = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strChannelIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strSampleIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  String[] strRownameIdens = new String[cagridCommonRefANOVAAnnoArr.length];
			  for(int i = 0; i < cagridCommonRefANOVAAnnoArr.length; i++) {
				  strChannelIdens[i] = this.forceToRedOrGreen(cagridCommonRefANOVAAnnoArr[i].getChannelIdentifier());
				  strSampleIdens[i] = cagridCommonRefANOVAAnnoArr[i].getSampleName();				  
				  strSampleFactorLevelAnnoCollection[i] = cagridCommonRefANOVAAnnoArr[i].getFactorLevel().getValue();			
				  strRownameIdens[i] = strSampleIdens[i] + "." + strChannelIdens[i];
			  }
			  
			  org.bioconductor.packages.rservices.RJDataFrame rjDataFrame = new org.bioconductor.packages.rservices.RJDataFrame();
			  rjDataFrame.setColNames(new String[] { "array", "channel", strSampleAnnoCollTestColName[0]});
			  rjDataFrame.setRowNames(strRownameIdens);  
			  rjDataFrame.setData(new Object[] { strSampleIdens, strChannelIdens, strSampleFactorLevelAnnoCollection});
			  rSampleAnnoCollection = new org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection(rjDataFrame);
			  
		  }
		  else {
			  throw new RemoteException("CaLinearModelImpl::twoChannelFit - Undefined TwoChannelModel " + twoChannelModel.getClass().getName());
		  }
		  
		  // TwoChannelExpressionData mappping:
		  org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData twoChanExpData = this.cagridTwoChanExpDataToRTwoChanExpData(twoChannelExpressionDataCollection);
		  
		  org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection = m_caLinearModel.twoChannelFit(rTwoChannelModel, twoChanExpData, rSampleAnnoCollection);
		  
		  return this.rTopTableCollectionToCagridTopTableCollection(rTopTableCollection);
		  
	  }
	  catch(java.lang.NullPointerException ew) {
		  ew.printStackTrace();
		  throw new RemoteException("CaLinearModel::twoChannelFit() - NullPointerException: " + ew);
	  }
	  catch(Exception ew) {		  
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
   
  private String forceToRedOrGreen(String redOrGreen) 
  {
	  if(redOrGreen.equals("Cy5") || redOrGreen.toUpperCase().equals("RED")) return RED;
	  if(redOrGreen.equals("Cy3") || redOrGreen.toUpperCase().equals("GREEN")) return GREEN;
	  
	  return "Unknown";
  }
  
  
  private org.bioconductor.packages.caCommonClasses.OneChannelExpressionData cagridSingleChanExpDataToROneChanExpData(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChanExpData) throws Exception  
  {
	  try { 
	  	org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(singleChanExpData.getExpressionDataCollection(), singleChanExpData.getReporterNames());
	  	org.bioconductor.packages.caCommonClasses.ExpressionMatrix expMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(rjNumericMatrix, new String[]{"ChannelOne"});
	  	return new org.bioconductor.packages.caCommonClasses.OneChannelExpressionData(expMatrix); 
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  
  }
  
  private org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData cagridTwoChanExpDataToRTwoChanExpData(org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChanExpData) throws Exception 
  {
	  try {
		  org.bioconductor.cagrid.data.ExpressionData[] channelOneExpData = twoChanExpData.getRedExpressionDataCollection();
		  org.bioconductor.packages.rservices.RJNumericMatrix chanOneRJNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(channelOneExpData, twoChanExpData.getReporterNames());
		  org.bioconductor.packages.caCommonClasses.ExpressionMatrix channelOneExpMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(chanOneRJNumericMatrix, new String[]{RED});
		  
		  org.bioconductor.cagrid.data.ExpressionData[] channelTwoExpData = twoChanExpData.getGreenExpressionDataCollection();
		  org.bioconductor.packages.rservices.RJNumericMatrix channelTwoRJNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(channelTwoExpData, twoChanExpData.getReporterNames());
		  org.bioconductor.packages.caCommonClasses.ExpressionMatrix channelTwoExpMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(channelTwoRJNumericMatrix, new String[]{GREEN});
		 
		  return new org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData(channelOneExpMatrix, channelTwoExpMatrix);
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  private org.bioconductor.packages.rservices.RJNumericMatrix convertCaGridExpDataToRJNumericMatrix(
                                                                 final org.bioconductor.cagrid.data.ExpressionData[] expressDataArr, final String[] reporterNamesArr) throws Exception
  {
	  try {
		  int numOfSampleCols  = expressDataArr.length;
		  if(numOfSampleCols == 0) {  // nothing to do
			  return null;
		  }

		  int sampleColSize = expressDataArr[0].getReporterValues().getValues().length;
		  // columns length should be equal, data maybe missing, so:
		  if(sampleColSize == 0) {  // nothing to do
			  return null;
		  }

		  org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = new org.bioconductor.packages.rservices.RJNumericMatrix();
		  rjNumericMatrix.setDim(new int[]{sampleColSize, numOfSampleCols});
		  // data represented in a flatten-array way:
		  double[] values = new double[sampleColSize  * numOfSampleCols];
		  String[] colSampleNames = new String[numOfSampleCols];
		  for(int col = 0; col < numOfSampleCols; col++) {
			  double[] dataArr = expressDataArr[col].getReporterValues().getValues();
			  System.arraycopy(dataArr, 0, values, col * sampleColSize, sampleColSize);
			  colSampleNames[col] = expressDataArr[col].getSampleName();
		  }
		  rjNumericMatrix.setValue(values);

		  Object[] dimNames = new Object[]{reporterNamesArr, colSampleNames};
		  rjNumericMatrix.setDimnames(dimNames);

		  return rjNumericMatrix;
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  
  private org.bioconductor.cagrid.data.TopTableCollection rTopTableCollectionToCagridTopTableCollection(org.bioconductor.packages.caCommonClasses.TopTableCollection rTopTableCollection) 
  {
	  Object[] rTopTableObjArr = rTopTableCollection.getTopTableCollection();
	  
	  org.bioconductor.cagrid.data.TopTable[] cagridTopTable = new org.bioconductor.cagrid.data.TopTable[rTopTableObjArr.length];
	  for(int i = 0; i < rTopTableObjArr.length; i++) {
		  cagridTopTable[i] = new org.bioconductor.cagrid.data.TopTable();
		  
		  org.bioconductor.packages.caCommonClasses.TopTable rTopTable = (org.bioconductor.packages.caCommonClasses.TopTable)rTopTableObjArr[i];
		  cagridTopTable[i].setContrastSpecification(rTopTable.getContrastSpecification()[0]);
		  
		  // other array fields of R TopTable will have the same length:
		  int topTableEntryNum = rTopTable.getLogFoldChange().length;
		  org.bioconductor.cagrid.data.TopTableEntry[] cagridTopTableEntry = new org.bioconductor.cagrid.data.TopTableEntry[topTableEntryNum];
		  for(int tt = 0; tt < topTableEntryNum; tt++) {
			  cagridTopTableEntry[tt] = new org.bioconductor.cagrid.data.TopTableEntry();
			  cagridTopTableEntry[tt].setAdjustedPValue(rTopTable.getAdjustedPValue()[tt]);
			  cagridTopTableEntry[tt].setLogFoldChange(rTopTable.getLogFoldChange()[tt]);
			  cagridTopTableEntry[tt].setLogOddsScore(rTopTable.getLogOddsScore()[tt]);
			  cagridTopTableEntry[tt].setPValue(rTopTable.getPValue()[tt]);
			  cagridTopTableEntry[tt].setReporterName(rTopTable.getReporterName()[tt]);
			  cagridTopTableEntry[tt].setTCoefficient(rTopTable.getTCoefficient()[tt]);
		  }
		  
		  cagridTopTable[i].setTopTableEntry(cagridTopTableEntry);
	  }
	  
	  return new org.bioconductor.cagrid.data.TopTableCollection(rTopTableCollection.getModelSpecification()[0], cagridTopTable);
	  
  }

 

  public java.lang.String getRpackageSessionInfo() throws RemoteException {
	  try {
		  org.bioconductor.rserviceJms.services.RWebServices.RWebServices caRWS = 
			                               new org.bioconductor.rserviceJms.services.RWebServices.RWebServices();
		  
		  String[] sessionInfos = caRWS.getRSessionInfo(new boolean[]{false});
		  
		  String sessionInfo = "";
		  for(String info : sessionInfos) {			  
			  sessionInfo += info + "\n";
		  }
		  return  sessionInfo;
		  
	  }
	  catch (Exception ex) {
		  throw new RemoteException(ex.getMessage());
	  }
  }

  private CaLinearModelContextResource lookupContextResource(String strResrcKeyValue) throws Exception {
	  try {
		  org.globus.wsrf.ResourceKey resrcKey = (org.globus.wsrf.ResourceKey)m_resourceKeyMap.get(strResrcKeyValue);
		  String caLM_homename = (String)m_serviceHomenameMap.get(strResrcKeyValue);
		  
		  // lookup:
		  javax.naming.InitialContext initCxt = new javax.naming.InitialContext();
		  CaLinearModelContextResourceHome caLMCxtResrcHome = (CaLinearModelContextResourceHome)initCxt.lookup(caLM_homename);
		  
		  return (CaLinearModelContextResource)caLMCxtResrcHome.find(resrcKey);
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  public void invokeFit(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.calinearmodel.OneChannelModel oneChannelModel) throws RemoteException {
	  String strResrcKeyValue = sessionIdentifier.getIdentifier();
	  try {
		  CaLinearModelContextResource caLMCxtResrc = this.lookupContextResource(strResrcKeyValue);
		  if(caLMCxtResrc == null) throw new RemoteException("CaLinearModelImpl::invokeFit() - looking up CaLinearModelContextResource return null.");
		  
		  // for new invoking, reset TopTableCollection in context resource to null for tracking if a new result of TopTableCollection returned:
		  caLMCxtResrc.setTopTableCollection(null);
		  org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleCED = caLMCxtResrc.getSingleCED();
		  if(singleCED == null) throw new Exception("CaLinearModelImple::invokeFit() - getting SingleChannelExpressionDataCollection from context resource return null.");
		  
		  org.bioconductor.cagrid.data.TopTableCollection retTopTableCollection = this.fit(singleCED, oneChannelModel);
		  
		  // setting this new return TopTableCollection back to context resource for client to grab it:
		  caLMCxtResrc.setTopTableCollection(retTopTableCollection);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  public org.bioconductor.cagrid.statefulservices.SessionIdentifier createCaLinearModelSession() throws RemoteException {
	  try {
		  org.apache.axis.MessageContext msgCxt = org.apache.axis.MessageContext.getCurrentContext();
		  String servicePath = msgCxt.getTargetService();
		  String caLM_homename = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caLinearModelContextHome";
		  // do lookup CaLinearModelContextResourceHome:
		  javax.naming.InitialContext initCxt = new javax.naming.InitialContext();
		  CaLinearModelContextResourceHome caLMCxtResrcHome = (CaLinearModelContextResourceHome)initCxt.lookup(caLM_homename);
		  org.globus.wsrf.ResourceKey resrcKey = caLMCxtResrcHome.createResource();
		  String strResrcKeyValue = resrcKey.getValue().toString();
		  m_resourceKeyMap.put(strResrcKeyValue, resrcKey);
		  m_serviceHomenameMap.put(strResrcKeyValue, caLM_homename);
		  
		  // calling ResouceStorage of HelperService to store this resource if using HelperService associated with this service:
		  org.bioconductor.packages.helper.common.ResourceStorage resrcStorage = org.bioconductor.packages.helper.common.ResourceStorage.getResourceStorageInstance();
		  resrcStorage.storeResourceInfo(strResrcKeyValue, resrcKey, caLM_homename);
		  
		  org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier = 
			         new org.bioconductor.cagrid.statefulservices.SessionIdentifier();
		  sessionIdentifier.setIdentifier(strResrcKeyValue);
		  sessionIdentifier.setServiceUrl((String)msgCxt.getProperty(org.apache.axis.MessageContext.TRANS_URL));
		  
		  return sessionIdentifier;
	  }
	  catch(Exception ew) {
		  throw new RemoteException("CaLinearModelImpl::createCaLinearModelSession(): " + ew.getMessage());
	  }
  }

  private org.bioconductor.packages.caLinearModel.context.stubs.types.CaLinearModelContextReference createCaLinearModelContextReference() throws RemoteException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caLinearModelContextHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResourceHome) initialContext.lookup(homeName);
			resourceKey = home.createResource();
			
			//  Grab the newly created resource
			org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResource thisResource = (org.bioconductor.packages.caLinearModel.context.service.globus.resource.CaLinearModelContextResource)home.find(resourceKey);
			
			//  This is where the creator of this resource type can set whatever needs
			//  to be set on the resource so that it can function appropriatly  for instance
			//  if you want the resouce to only have the query string then there is where you would
			//  give it the query string.
			
			
			// sample of setting creator only security.  This will only allow the caller that created
			// this resource to be able to use it.
			//thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			
			

			String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
			transportURL += "CaLinearModelContext";
			epr = org.globus.wsrf.utils.AddressingUtils.createEndpointReference(transportURL,resourceKey);
		} catch (Exception e) {
			throw new RemoteException("Error looking up CaLinearModelContext home:" + e.getMessage(), e);
		}

		//return the typed EPR
		org.bioconductor.packages.caLinearModel.context.stubs.types.CaLinearModelContextReference ref = new org.bioconductor.packages.caLinearModel.context.stubs.types.CaLinearModelContextReference();
		ref.setEndpointReference(epr);

		return ref;
  }

  public void invokeTwoChannelFit(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.calinearmodel.TwoChannelModel twoChannelModel) throws RemoteException {
	  String strResrcKeyValue = sessionIdentifier.getIdentifier();
	  try {
		  CaLinearModelContextResource caLMCxtResrc = this.lookupContextResource(strResrcKeyValue);
		  
		  if(caLMCxtResrc == null) throw new RemoteException("CaLinearModelImpl::invokeTwoChannelFit() - looking up CaLinearModelContextResource return null.");
		  
		  // for new invoking, reset TopTableCollection in context resource to null for tracking if a new result of TopTableCollection returned:
		  caLMCxtResrc.setTopTableCollection(null);
		  org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoCED = caLMCxtResrc.getTwoCED();
		  if(twoCED == null) throw new Exception("CaLinearModelImple::invokeTwoChannelFit() - getting TwoChannelExpressionDataCollection from context resource return null.");
		  
		  org.bioconductor.cagrid.data.TopTableCollection retTopTableCollection = this.twoChannelFit(twoCED, twoChannelModel);
		  
		  // setting this new return TopTableCollection back to context resource for client to grab it:
		  caLMCxtResrc.setTopTableCollection(retTopTableCollection);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  String strResrcKey = sessionIdentifier.getIdentifier();
	  try {
		  CaLinearModelContextResource caLMCxtResrc = this.lookupContextResource(strResrcKey);
		  
		  return caLMCxtResrc.getStatus();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

}

