package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.Error;
import io.swagger.client.model.LigandDetails;
import io.swagger.client.model.StructureDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-18T09:34:14.459Z")
public class LigandsApi {
  private ApiClient apiClient;

  public LigandsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public LigandsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get all co-crystallized ligands optionally restricted to a set of kinase IDs
   * The Ligands List endpoint returns a list of co-crystallized ligands in KLIFS optiontally restricted to a set of specific kinase IDs.\n
   * @param kinaseID ID(s) of the kinase(s) for which all structures are requested. (optional)
   * @return List<LigandDetails>
   * @throws ApiException if fails to make API call
   */
  public List<LigandDetails> ligandsListGet(List<Integer> kinaseID) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/ligands_list".replaceAll("\\{format\\}","json");

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

    
    GenericType<List<LigandDetails>> localVarReturnType = new GenericType<List<LigandDetails>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get all structures in complex with one of the provided ligand IDs
   * The Ligands Get Structures endpoint returns a list of monomers of crystal structures in KLIFS in complex with provided ligand IDs.\n
   * @param ligandID ID(s) of the ligand(s) for which all structures are requested. (required)
   * @return List<StructureDetails>
   * @throws ApiException if fails to make API call
   */
  public List<StructureDetails> ligandsListStructuresGet(List<Integer> ligandID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'ligandID' is set
    if (ligandID == null) {
      throw new ApiException(400, "Missing the required parameter 'ligandID' when calling ligandsListStructuresGet");
    }
    
    // create path and map variables
    String localVarPath = "/ligands_list_structures".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "ligand_ID", ligandID));
    

    

    

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
