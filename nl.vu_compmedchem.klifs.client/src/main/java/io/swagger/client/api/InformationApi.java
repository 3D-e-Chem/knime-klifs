package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.Error;
import io.swagger.client.model.KinaseInformation;
import io.swagger.client.model.IDlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-19T07:51:24.422Z")
public class InformationApi {
  private ApiClient apiClient;

  public InformationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public InformationApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Kinase families
   * The Kinase families endpoint returns a list of all available kinase families in KLIFS. When a kinase group is specified only those kinase families that are within that kinase group are returned.\n
   * @param kinaseGroup Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE). (optional)
   * @return List<String>
   * @throws ApiException if fails to make API call
   */
  public List<String> kinaseFamiliesGet(String kinaseGroup) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/kinase_families".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "kinase_group", kinaseGroup));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Kinase groups
   * The Kinase groups endpoint returns a list of all available kinase groups in KLIFS.\n
   * @return List<String>
   * @throws ApiException if fails to make API call
   */
  public List<String> kinaseGroupsGet() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/kinase_groups".replaceAll("\\{format\\}","json");

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

    
    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Kinase ID
   * The Kinase ID endpoint returns the KLIFS ID of a specific kinase based on the abbreviated kinase name (e.g. ABL1) or UniProt ID (e.g. P00519). The kinase names from Manning et al., the HUGO Gene Nomenclature Committee, and the MGI are recognized.\n
   * @param kinaseName The name (or multiple names separated by a comma) of (a) specfic kinase(s) (e.g. ABL1). (required)
   * @param species Optional: Species for which the kinase ID are requested (e.g. HUMAN OR MOUSE). (optional)
   * @return List<KinaseInformation>
   * @throws ApiException if fails to make API call
   */
  public List<KinaseInformation> kinaseIDGet(String kinaseName, String species) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'kinaseName' is set
    if (kinaseName == null) {
      throw new ApiException(400, "Missing the required parameter 'kinaseName' when calling kinaseIDGet");
    }
    
    // create path and map variables
    String localVarPath = "/kinase_ID".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "kinase_name", kinaseName));
    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "species", species));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<KinaseInformation>> localVarReturnType = new GenericType<List<KinaseInformation>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Kinase information
   * The Kinase information endpoint returns a list of information related to the requested kinase (Uniprot, pocket sequence, etc.).\n
   * @param kinaseID ID (or IDs separated by a comma) of the kinase for which the kinase information is requested. (optional)
   * @param species Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE). (optional)
   * @return List<KinaseInformation>
   * @throws ApiException if fails to make API call
   */
  public List<KinaseInformation> kinaseInformationGet(List<Integer> kinaseID, String species) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/kinase_information".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "kinase_ID", kinaseID));
    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "species", species));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<KinaseInformation>> localVarReturnType = new GenericType<List<KinaseInformation>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
  /**
   * Kinase names
   * The Kinase names endpoint returns a list of all available kinases in KLIFS according using the HGNC gene symbols. When a kinase group or kinase family is specified only those kinase names that are within that kinase group or kinase family are returned. When both a group and a family are specified, only the family is used to process the request.\n
   * @param kinaseGroup Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE). (optional)
   * @param kinaseFamily Optional: Name (or multiple names separated by a comma) of the kinase family for which the kinase names are requested (e.g. AUR,WEE). (optional)
   * @param species Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE). (optional)
   * @return List<IDlist>
   * @throws ApiException if fails to make API call
   */
  public List<IDlist> kinaseNamesGet(String kinaseGroup, String kinaseFamily, String species) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/kinase_names".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "kinase_group", kinaseGroup));
    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "kinase_family", kinaseFamily));
    
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "species", species));
    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    GenericType<List<IDlist>> localVarReturnType = new GenericType<List<IDlist>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    
  }
  
}
