package org.bioconductor.packages.helper.common;

import org.bioconductor.cagrid.statefulservices.SessionIdentifier;
import org.globus.wsrf.ResourceKey;
import org.bioconductor.packages.helper.common.HelperServiceContextResourceI;

public class ResourceStorage {
	
	private java.util.HashMap<String, ResourceKey> m_resourceKeyMap = new java.util.HashMap<String, ResourceKey>();
	private java.util.HashMap<String, String> m_resrcKeyHomeNameMap = new java.util.HashMap<String, String>();
	
	private static ResourceStorage m_resrcStorage = null;
	
	private ResourceStorage(){}
	
	public static ResourceStorage getResourceStorageInstance() 
	{
		if(m_resrcStorage == null) {
			m_resrcStorage = new ResourceStorage();
			
			return m_resrcStorage;
		}
		else {
			return m_resrcStorage;
		}
	}
	
	public void storeResourceInfo(String resrcKeyValue, ResourceKey resrcKey, String serviceHomename)
	{
		m_resourceKeyMap.put(resrcKeyValue, resrcKey);
		m_resrcKeyHomeNameMap.put(resrcKeyValue, serviceHomename);
	}
	
	public HelperServiceContextResourceI lookupResourceContext(SessionIdentifier sessionIdentifier) throws Exception 
	{
		String resrcKeyValue = sessionIdentifier.getIdentifier();
		try {			
			String resrcHomename = m_resrcKeyHomeNameMap.get(resrcKeyValue);
			if(resrcHomename == null) {
				System.out.println("ResourceStorage::lookupResourceContext - can't find homename for : " + resrcKeyValue);
				throw new Exception("ResourceStorage::lookupResourceContext can't find homename for " + resrcKeyValue);
			}
			ResourceKey resrcKey = m_resourceKeyMap.get(resrcKeyValue);
			if(resrcHomename == null) {
				System.out.println("ResourceStorage::lookupResourceContext - can't find resourcekey for : " + resrcKeyValue);
				throw new Exception("ResourceStorage::lookupResourceContext can't find resourcekey for " + resrcKeyValue);
			}
			
			 // look up:
			  javax.naming.Context initialContext = new javax.naming.InitialContext();
			  org.globus.wsrf.impl.ResourceHomeImpl cxtResrcHome = (org.globus.wsrf.impl.ResourceHomeImpl)initialContext.lookup(resrcHomename);
			  
			  org.globus.wsrf.Resource resource = cxtResrcHome.find(resrcKey);
			  if(resource == null) {
				  System.out.println("ResourceStorage::lookupResourceContext - finding context resource get null.");
				  throw new Exception("ResourceStorage::lookupResourceContext finding context resource get null.");
			  }
			  
			  // casting to whatever type resource its object refers to
			  HelperServiceContextResourceI contextResource = (HelperServiceContextResourceI)resource;
				  
			  // testing:
			  System.out.println("ResourceStorage::lookupResourceContext() - Who is this context? " + contextResource.identifyContextSelf());
			  
			  
			  return contextResource;
		}
		catch(org.globus.wsrf.NoSuchResourceException ew) {
			System.out.println("ResourceStorage::lookupResourceContext failed to find a resource");
			// clean the HashMap:
			m_resrcKeyHomeNameMap.remove(resrcKeyValue);
			m_resourceKeyMap.remove(resrcKeyValue);
			throw new Exception("ResourceStorage::lookupResourceContext NoSuchResourceException: " + ew.getMessage());
		}
		catch(ClassCastException ew) {
			System.out.println("ResourceStorage::lookupResourceContext ClassCastException: " + ew.getMessage());
			throw new Exception("ResourceStorage::lookupResourceContext ClassCastException: " + ew.getMessage());
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	                                 
}
