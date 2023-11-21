# InteractionsApi

All URIs are relative to *https://klifs.net/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**interactionsGetIFPGet**](InteractionsApi.md#interactionsGetIFPGet) | **GET** /interactions_get_IFP | Get structure IFP |
| [**interactionsGetTypesGet**](InteractionsApi.md#interactionsGetTypesGet) | **GET** /interactions_get_types | Get interaction types |
| [**interactionsMatchResiduesGet**](InteractionsApi.md#interactionsMatchResiduesGet) | **GET** /interactions_match_residues | Match IFP residues |


<a id="interactionsGetIFPGet"></a>
# **interactionsGetIFPGet**
> List&lt;IFPList&gt; interactionsGetIFPGet(structureID)

Get structure IFP

The Get structure IFP endpoint returns the full IFP a specific kinase structure. This IFP consists of 7 interactions for each of the 85 pocket residues. The presence or absence of an interaction is annotation with a 1 and 0 respectively. This method returns a string of 85 residues x 7 interaction types&#x3D;595 bits. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InteractionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    InteractionsApi apiInstance = new InteractionsApi(defaultClient);
    List<Integer> structureID = Arrays.asList(); // List<Integer> | ID(s) of the structure(s) that is/are requested.
    try {
      List<IFPList> result = apiInstance.interactionsGetIFPGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InteractionsApi#interactionsGetIFPGet");
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
| **structureID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**List&lt;IFPList&gt;**](IFPList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The numeric ID for the requested kinase |  -  |
| **0** | Unexpected error |  -  |

<a id="interactionsGetTypesGet"></a>
# **interactionsGetTypesGet**
> List&lt;InteractionList&gt; interactionsGetTypesGet()

Get interaction types

The Get interaction types endpoint returns a list of the interactions (1-7) and the type of interaction. IFP encodes 7 types of interactions between the ligand and each pocket residue. E.g. 1000010 represents a hydrophobic interaction (position 1) and an ionic interaction: protein cation - ligand anion (position 6).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InteractionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    InteractionsApi apiInstance = new InteractionsApi(defaultClient);
    try {
      List<InteractionList> result = apiInstance.interactionsGetTypesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InteractionsApi#interactionsGetTypesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InteractionList&gt;**](InteractionList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An list specifying the different interactions encoded by the IFP |  -  |
| **0** | Unexpected error |  -  |

<a id="interactionsMatchResiduesGet"></a>
# **interactionsMatchResiduesGet**
> List&lt;MatchList&gt; interactionsMatchResiduesGet(structureID)

Match IFP residues

The Match IFP residues endpoint returns a list of the pocket definition of IFP including the X-ray numbering for a specific structure. This list can be used to decompose an IFP into specific residue interactions and to match Xray numbering to KLIFS numbering and vice versa.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InteractionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    InteractionsApi apiInstance = new InteractionsApi(defaultClient);
    Integer structureID = 56; // Integer | ID of the structure(s) that is requested.
    try {
      List<MatchList> result = apiInstance.interactionsMatchResiduesGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InteractionsApi#interactionsMatchResiduesGet");
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
| **structureID** | **Integer**| ID of the structure(s) that is requested. | |

### Return type

[**List&lt;MatchList&gt;**](MatchList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An list specifying the different interactions encoded by the IFP |  -  |
| **0** | Unexpected error |  -  |

