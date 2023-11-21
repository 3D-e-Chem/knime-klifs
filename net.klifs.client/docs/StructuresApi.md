# StructuresApi

All URIs are relative to *https://klifs.net/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**structureGetComplexGet**](StructuresApi.md#structureGetComplexGet) | **GET** /structure_get_complex | Get full complex |
| [**structureGetLigandGet**](StructuresApi.md#structureGetLigandGet) | **GET** /structure_get_ligand | Get ligand from structure |
| [**structureGetPdbComplexGet**](StructuresApi.md#structureGetPdbComplexGet) | **GET** /structure_get_pdb_complex | Get full complex in PDB format |
| [**structureGetPocketGet**](StructuresApi.md#structureGetPocketGet) | **GET** /structure_get_pocket | Get pocket from structure |
| [**structureGetProteinGet**](StructuresApi.md#structureGetProteinGet) | **GET** /structure_get_protein | Get protein from structure |
| [**structureListGet**](StructuresApi.md#structureListGet) | **GET** /structure_list | Get all structural information based on a structure ID |
| [**structuresListGet**](StructuresApi.md#structuresListGet) | **GET** /structures_list | Get all structures based on a kinase ID |
| [**structuresPdbListGet**](StructuresApi.md#structuresPdbListGet) | **GET** /structures_pdb_list | Get all structures based on a set of PDB-codes |


<a id="structureGetComplexGet"></a>
# **structureGetComplexGet**
> File structureGetComplexGet(structureID)

Get full complex

The Get Kinase Complex endpoint returns the full structure (including solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
    try {
      File result = apiInstance.structureGetComplexGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureGetComplexGet");
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
| **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The processed complex in MOL2 format |  -  |
| **0** | Unexpected error |  -  |

<a id="structureGetLigandGet"></a>
# **structureGetLigandGet**
> File structureGetLigandGet(structureID)

Get ligand from structure

The Get kinase ligand endpoint returns the orthosteric ligand of a specific structure in MOL2 format 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
    try {
      File result = apiInstance.structureGetLigandGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureGetLigandGet");
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
| **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The processed complex in MOL2 format |  -  |
| **0** | Unexpected error |  -  |

<a id="structureGetPdbComplexGet"></a>
# **structureGetPdbComplexGet**
> File structureGetPdbComplexGet(structureID)

Get full complex in PDB format

The Get Kinase PDB Complex endpoint returns the full structure (including solvent, cofactors, ligands, etc.) in PDB format 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
    try {
      File result = apiInstance.structureGetPdbComplexGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureGetPdbComplexGet");
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
| **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-pdb

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The processed complex in PDB format |  -  |
| **0** | Unexpected error |  -  |

<a id="structureGetPocketGet"></a>
# **structureGetPocketGet**
> File structureGetPocketGet(structureID)

Get pocket from structure

The Get kinase pocket endpoint returns only the KLIFS pocket of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
    try {
      File result = apiInstance.structureGetPocketGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureGetPocketGet");
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
| **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The processed complex in MOL2 format |  -  |
| **0** | Unexpected error |  -  |

<a id="structureGetProteinGet"></a>
# **structureGetProteinGet**
> File structureGetProteinGet(structureID)

Get protein from structure

The Get kinase protein endpoint returns the full protein of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
    try {
      File result = apiInstance.structureGetProteinGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureGetProteinGet");
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
| **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The processed complex in MOL2 format |  -  |
| **0** | Unexpected error |  -  |

<a id="structureListGet"></a>
# **structureListGet**
> List&lt;StructureDetails&gt; structureListGet(structureID)

Get all structural information based on a structure ID

The Structure list endpoint returns a information of the indicated kinase structures in KLIFS based on a specific structure ID. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    List<Integer> structureID = Arrays.asList(); // List<Integer> | ID(s) of the structure(s) for which all information is/are requested.
    try {
      List<StructureDetails> result = apiInstance.structureListGet(structureID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structureListGet");
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
| **structureID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the structure(s) for which all information is/are requested. | |

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

<a id="structuresListGet"></a>
# **structuresListGet**
> List&lt;StructureDetails&gt; structuresListGet(kinaseID)

Get all structures based on a kinase ID

The Structures list endpoint returns a list of available kinase structures in KLIFS based on a specific kinase ID (e.g. kinase ID 392, which is the ID for ABL1). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    List<Integer> kinaseID = Arrays.asList(); // List<Integer> | ID(s) of the kinase(s) for which all structures are requested.
    try {
      List<StructureDetails> result = apiInstance.structuresListGet(kinaseID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structuresListGet");
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
| **kinaseID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the kinase(s) for which all structures are requested. | |

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

<a id="structuresPdbListGet"></a>
# **structuresPdbListGet**
> List&lt;StructureDetails&gt; structuresPdbListGet(pdbCodes)

Get all structures based on a set of PDB-codes

The Structures PDB list endpoint returns a list of available kinase structures in KLIFS based on a set of 4-letter PDB-codes. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StructuresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://klifs.net/api");

    StructuresApi apiInstance = new StructuresApi(defaultClient);
    List<String> pdbCodes = Arrays.asList(); // List<String> | PDB-codes for which all structures are requested.
    try {
      List<StructureDetails> result = apiInstance.structuresPdbListGet(pdbCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuresApi#structuresPdbListGet");
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
| **pdbCodes** | [**List&lt;String&gt;**](String.md)| PDB-codes for which all structures are requested. | |

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

