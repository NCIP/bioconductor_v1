package org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource;

import org.bioconductor.packages.caGeneSetAnalysis.context.common.CaGeneSetAnalysisContextConstants;
import org.bioconductor.packages.caGeneSetAnalysis.context.stubs.CaGeneSetAnalysisContextResourceProperties;

import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.ResourceHomeImpl;
import org.globus.wsrf.impl.SimpleResourceKey;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.MessageContext;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.utils.AddressingUtils;
import org.apache.axis.components.uuid.UUIDGen;
import org.apache.axis.components.uuid.UUIDGenFactory;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements the resource home for the resource type represented
 * by this service.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneSetAnalysisContextResourceHome extends ResourceHomeImpl {
        private static final UUIDGen UUIDGEN = UUIDGenFactory.getUUIDGen();


	/**
 	* Creates a new Resource, adds it to the list of resources managed by this resource home,
 	* and returns the key to the resource.
 	*/
	public ResourceKey createResource() throws Exception {
		// Create a resource and initialize it
		CaGeneSetAnalysisContextResource resource = (CaGeneSetAnalysisContextResource) createNewInstance();
		// Create the resource properties bean so that the resource can use it to hold the  resource property values
		CaGeneSetAnalysisContextResourceProperties props = new CaGeneSetAnalysisContextResourceProperties();
        
        // Get a unique id for the resource
        Object id = UUIDGEN.nextUUID();
        
        // Create the resource key set it on the resource
		// this key is used for index service registration
		ResourceKey key = new SimpleResourceKey(getKeyTypeName(), id);
		resource.setResourceKey(key);
		
        resource.initialize(props, CaGeneSetAnalysisContextConstants.RESOURCE_PROPERTY_SET, id);

		// Add the resource to the list of resources in this home
		add(key, resource);
		return key;
	}
	
	/**
 	* Take a resource key managed by this resource, locates the resource, and created a typed EPR for the resource.
 	*/
	public org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference getResourceReference(ResourceKey key) throws Exception {
		MessageContext ctx = MessageContext.getCurrentContext();
		String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
		transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
		transportURL += "CaGeneSetAnalysisContext";
		EndpointReferenceType epr = AddressingUtils.createEndpointReference(transportURL,key);
		org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference ref = new org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference();
		ref.setEndpointReference(epr);
		return ref;
	}

	/**
 	* Given the key of a resource managed by this resource home, a type resource will be returned.
 	*/	
	public CaGeneSetAnalysisContextResource getResource(ResourceKey key) throws ResourceException {
		CaGeneSetAnalysisContextResource thisResource = (CaGeneSetAnalysisContextResource)find(key);
		return thisResource;
	}
	
    /**
     * Get the resouce that is being addressed in this current context
     */
    public CaGeneSetAnalysisContextResource getAddressedResource() throws Exception {
        CaGeneSetAnalysisContextResource thisResource;
        thisResource = (CaGeneSetAnalysisContextResource) ResourceContext.getResourceContext().getResource();
        return thisResource;
    }

	
}