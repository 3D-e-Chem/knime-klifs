package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.IFPList;
import io.swagger.client.model.Error;
import io.swagger.client.model.InteractionList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-11T07:30:28.396Z")
public class InteractionsApi {
  private ApiClient apiClient;

  public InteractionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public InteractionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get structure IFP
   * The Get structure IFP endpoint returns the full IFP a specific kinase structure. This IFP consists of 7 interactions for each of the 85 pocket residues. The presence or absence of an interaction is annotation with a 1 and 0 respectively. This method returns a string of 85 residues x 7 interaction types=595 bits.\n
   * @param structureID ID(s) of the structure(s) that is/are requested. (required)
   * @return List<IFPList>
   * @throws ApiException if fails to make API call
   */
  public List<IFPList> interactionsGetIFPGet(List<Integer> structureID) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'structureID' is set
    if (structureID == null) {
      throw new ApiException(400, "Missing the required parameter 'structureID' when calling interactionsGetIFPGet");
    }
    
    // create path and map variables
    String localVarPath = "/interactions_get_IFP".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "structure_ID", structureID));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<IFPList>> localVarReturnType = new GenericType<List<IFPList>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Get interaction types
   * The Get interaction types endpoint returns a list of the interactions (1-7) and the type of interaction. IFP encodes 7 types of interactions between the ligand and each pocket residue. E.g. 1000010 represents a hydrophobic interaction (position 1) and an ionic interaction: protein cation - ligand anion (position 6).
   * @return List<InteractionList>
   * @throws ApiException if fails to make API call
   */
  public List<InteractionList> interactionsGetTypesGet() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/interactions_get_types".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<InteractionList>> localVarReturnType = new GenericType<List<InteractionList>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
}
