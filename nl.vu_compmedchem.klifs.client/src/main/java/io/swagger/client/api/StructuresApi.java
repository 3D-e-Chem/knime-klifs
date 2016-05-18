package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.Error;
import java.io.File;
import io.swagger.client.model.StructureDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-18T09:34:14.459Z")
public class StructuresApi {
  private ApiClient apiClient;

  public StructuresApi() {
    this(Configuration.getDefaultApiClient());
  }

  public StructuresApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get full complex
   * The Get Kinase Complex endpoint returns the full structure (including solvent, cofactors, ligands, etc.) in MOL2 format\n
   * @param structureID ID(s) of the structure(s) that is/are requested. (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File structureGetComplexGet(Integer structureID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'structureID' is set
    if (structureID == null) {
      throw new ApiException(400, "Missing the required parameter 'structureID' when calling structureGetComplexGet");
    }
    
    // create path and map variables
    String localVarPath = "/structure_get_complex".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "structure_ID", structureID));
    

    

    

    final String[] localVarAccepts = {
      "chemical/x-mol2"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get ligand from structure
   * The Get kinase ligand endpoint returns the orthosteric ligand of a specific structure in MOL2 format\n
   * @param structureID ID(s) of the structure(s) that is/are requested. (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File structureGetLigandGet(Integer structureID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'structureID' is set
    if (structureID == null) {
      throw new ApiException(400, "Missing the required parameter 'structureID' when calling structureGetLigandGet");
    }
    
    // create path and map variables
    String localVarPath = "/structure_get_ligand".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "structure_ID", structureID));
    

    

    

    final String[] localVarAccepts = {
      "chemical/x-mol2"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get pocket from structure
   * The Get kinase pocket endpoint returns only the KLIFS pocket of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format\n
   * @param structureID ID(s) of the structure(s) that is/are requested. (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File structureGetPocketGet(Integer structureID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'structureID' is set
    if (structureID == null) {
      throw new ApiException(400, "Missing the required parameter 'structureID' when calling structureGetPocketGet");
    }
    
    // create path and map variables
    String localVarPath = "/structure_get_pocket".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "structure_ID", structureID));
    

    

    

    final String[] localVarAccepts = {
      "chemical/x-mol2"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get protein from structure
   * The Get kinase protein endpoint returns the full protein of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format\n
   * @param structureID ID(s) of the structure(s) that is/are requested. (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File structureGetProteinGet(Integer structureID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'structureID' is set
    if (structureID == null) {
      throw new ApiException(400, "Missing the required parameter 'structureID' when calling structureGetProteinGet");
    }
    
    // create path and map variables
    String localVarPath = "/structure_get_protein".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "structure_ID", structureID));
    

    

    

    final String[] localVarAccepts = {
      "chemical/x-mol2"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get all structures based on a kinase ID
   * The Structures list endpoint returns a list of available kinase structures in KLIFS based on a specific kinase ID (e.g. kinase ID 392, which is the ID for ABL1).\n
   * @param kinaseID ID(s) of the kinase(s) for which all structures are requested. (required)
   * @return List<StructureDetails>
   * @throws ApiException if fails to make API call
   */
  public List<StructureDetails> structuresListGet(List<Integer> kinaseID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'kinaseID' is set
    if (kinaseID == null) {
      throw new ApiException(400, "Missing the required parameter 'kinaseID' when calling structuresListGet");
    }
    
    // create path and map variables
    String localVarPath = "/structures_list".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "kinase_ID", kinaseID));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<StructureDetails>> localVarReturnType = new GenericType<List<StructureDetails>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get all structures based on a set of PDB-codes
   * The Structures PDB list endpoint returns a list of available kinase structures in KLIFS based on a set of 4-letter PDB-codes.\n
   * @param pdbCodes PDB-codes for which all structures are requested. (required)
   * @return List<StructureDetails>
   * @throws ApiException if fails to make API call
   */
  public List<StructureDetails> structuresPdbListGet(List<String> pdbCodes) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pdbCodes' is set
    if (pdbCodes == null) {
      throw new ApiException(400, "Missing the required parameter 'pdbCodes' when calling structuresPdbListGet");
    }
    
    // create path and map variables
    String localVarPath = "/structures_pdb_list".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "pdb-codes", pdbCodes));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<StructureDetails>> localVarReturnType = new GenericType<List<StructureDetails>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
}
