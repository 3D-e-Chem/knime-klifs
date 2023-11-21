# LigandsApi

All URIs are relative to *https://klifs.net/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bioactivityListIdGet**](LigandsApi.md#bioactivityListIdGet) | **GET** /bioactivity_list_id | Get all ChEMBL kinase bioactivities for a specific ligand |
| [**bioactivityListPdbGet**](LigandsApi.md#bioactivityListPdbGet) | **GET** /bioactivity_list_pdb | Get all ChEMBL kinase bioactivities for a specific ligand |
| [**ligandsListGet**](LigandsApi.md#ligandsListGet) | **GET** /ligands_list | Get all co-crystallized ligands optionally restricted to a set of kinase IDs |
| [**ligandsListStructuresGet**](LigandsApi.md#ligandsListStructuresGet) | **GET** /ligands_list_structures | Get all structures in complex with one of the provided ligand IDs |


<a id="bioactivityListIdGet"></a>
# **bioactivityListIdGet**
> List&lt;BioactivityDetails&gt; bioactivityListIdGet(ligandID)

Get all ChEMBL kinase bioactivities for a specific ligand

The Bioactivity list endpoint returns a list of all known ChEMBL kinase bioactivities for a given ligand as specified by the ligand ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LigandsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    LigandsApi apiInstance = new LigandsApi(defaultClient);
    Integer ligandID = 56; // Integer | KLIFS ID of the ligand for which the bioactivities are requested (e.g. 28 for staurosporine).
    try {
      List<BioactivityDetails> result = apiInstance.bioactivityListIdGet(ligandID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LigandsApi#bioactivityListIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ligandID** | **Integer**| KLIFS ID of the ligand for which the bioactivities are requested (e.g. 28 for staurosporine). | |

### Return type

[**List&lt;BioactivityDetails&gt;**](BioactivityDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of bioactivities |  -  |
| **0** | Unexpected error |  -  |

<a id="bioactivityListPdbGet"></a>
# **bioactivityListPdbGet**
> List&lt;BioactivityDetails&gt; bioactivityListPdbGet(ligandPDB)

Get all ChEMBL kinase bioactivities for a specific ligand

The Bioactivity list endpoint returns a list of all known ChEMBL kinase bioactivities for a given ligand as specified by the ligand PDB HET-code.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LigandsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    LigandsApi apiInstance = new LigandsApi(defaultClient);
    String ligandPDB = "ligandPDB_example"; // String | The PDB HET-code of the ligand for which the bioactivities are requested. (e.g. STU for staurosporine)
    try {
      List<BioactivityDetails> result = apiInstance.bioactivityListPdbGet(ligandPDB);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LigandsApi#bioactivityListPdbGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ligandPDB** | **String**| The PDB HET-code of the ligand for which the bioactivities are requested. (e.g. STU for staurosporine) | |

### Return type

[**List&lt;BioactivityDetails&gt;**](BioactivityDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of bioactivities |  -  |
| **0** | Unexpected error |  -  |

<a id="ligandsListGet"></a>
# **ligandsListGet**
> List&lt;LigandDetails&gt; ligandsListGet(kinaseID)

Get all co-crystallized ligands optionally restricted to a set of kinase IDs

The Ligands List endpoint returns a list of co-crystallized ligands in KLIFS optiontally restricted to a set of specific kinase IDs. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LigandsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    LigandsApi apiInstance = new LigandsApi(defaultClient);
    List<Integer> kinaseID = Arrays.asList(); // List<Integer> | ID(s) of the kinase(s) for which all structures are requested.
    try {
      List<LigandDetails> result = apiInstance.ligandsListGet(kinaseID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LigandsApi#ligandsListGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **kinaseID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the kinase(s) for which all structures are requested. | [optional] |

### Return type

[**List&lt;LigandDetails&gt;**](LigandDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of ligand details |  -  |
| **0** | Unexpected error |  -  |

<a id="ligandsListStructuresGet"></a>
# **ligandsListStructuresGet**
> List&lt;StructureDetails&gt; ligandsListStructuresGet(ligandID)

Get all structures in complex with one of the provided ligand IDs

The Ligands Get Structures endpoint returns a list of monomers of crystal structures in KLIFS in complex with provided ligand IDs. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LigandsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    LigandsApi apiInstance = new LigandsApi(defaultClient);
    List<Integer> ligandID = Arrays.asList(); // List<Integer> | ID(s) of the ligand(s) for which all structures are requested.
    try {
      List<StructureDetails> result = apiInstance.ligandsListStructuresGet(ligandID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LigandsApi#ligandsListStructuresGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ligandID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the ligand(s) for which all structures are requested. | |

### Return type

[**List&lt;StructureDetails&gt;**](StructureDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of structure details |  -  |
| **0** | Unexpected error |  -  |

