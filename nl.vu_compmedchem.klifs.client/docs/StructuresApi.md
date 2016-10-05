# StructuresApi

All URIs are relative to *http://klifs.vu-compmedchem.nl/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**structureGetComplexGet**](StructuresApi.md#structureGetComplexGet) | **GET** /structure_get_complex | Get full complex
[**structureGetLigandGet**](StructuresApi.md#structureGetLigandGet) | **GET** /structure_get_ligand | Get ligand from structure
[**structureGetPocketGet**](StructuresApi.md#structureGetPocketGet) | **GET** /structure_get_pocket | Get pocket from structure
[**structureGetProteinGet**](StructuresApi.md#structureGetProteinGet) | **GET** /structure_get_protein | Get protein from structure
[**structuresListGet**](StructuresApi.md#structuresListGet) | **GET** /structures_list | Get all structures based on a kinase ID
[**structuresPdbListGet**](StructuresApi.md#structuresPdbListGet) | **GET** /structures_pdb_list | Get all structures based on a set of PDB-codes


<a name="structureGetComplexGet"></a>
# **structureGetComplexGet**
> File structureGetComplexGet(structureID)

Get full complex

The Get Kinase Complex endpoint returns the full structure (including solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
try {
    File result = apiInstance.structureGetComplexGet(structureID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structureGetComplexGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

<a name="structureGetLigandGet"></a>
# **structureGetLigandGet**
> File structureGetLigandGet(structureID)

Get ligand from structure

The Get kinase ligand endpoint returns the orthosteric ligand of a specific structure in MOL2 format 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
try {
    File result = apiInstance.structureGetLigandGet(structureID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structureGetLigandGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

<a name="structureGetPocketGet"></a>
# **structureGetPocketGet**
> File structureGetPocketGet(structureID)

Get pocket from structure

The Get kinase pocket endpoint returns only the KLIFS pocket of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
try {
    File result = apiInstance.structureGetPocketGet(structureID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structureGetPocketGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

<a name="structureGetProteinGet"></a>
# **structureGetProteinGet**
> File structureGetProteinGet(structureID)

Get protein from structure

The Get kinase protein endpoint returns the full protein of a specific structure (excluding solvent, cofactors, ligands, etc.) in MOL2 format 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
Integer structureID = 56; // Integer | ID(s) of the structure(s) that is/are requested.
try {
    File result = apiInstance.structureGetProteinGet(structureID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structureGetProteinGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **structureID** | **Integer**| ID(s) of the structure(s) that is/are requested. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: chemical/x-mol2

<a name="structuresListGet"></a>
# **structuresListGet**
> List&lt;StructureDetails&gt; structuresListGet(kinaseID)

Get all structures based on a kinase ID

The Structures list endpoint returns a list of available kinase structures in KLIFS based on a specific kinase ID (e.g. kinase ID 392, which is the ID for ABL1). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
List<Integer> kinaseID = Arrays.asList(56); // List<Integer> | ID(s) of the kinase(s) for which all structures are requested.
try {
    List<StructureDetails> result = apiInstance.structuresListGet(kinaseID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structuresListGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the kinase(s) for which all structures are requested. |

### Return type

[**List&lt;StructureDetails&gt;**](StructureDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="structuresPdbListGet"></a>
# **structuresPdbListGet**
> List&lt;StructureDetails&gt; structuresPdbListGet(pdbCodes)

Get all structures based on a set of PDB-codes

The Structures PDB list endpoint returns a list of available kinase structures in KLIFS based on a set of 4-letter PDB-codes. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StructuresApi;


StructuresApi apiInstance = new StructuresApi();
List<String> pdbCodes = Arrays.asList("pdbCodes_example"); // List<String> | PDB-codes for which all structures are requested.
try {
    List<StructureDetails> result = apiInstance.structuresPdbListGet(pdbCodes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StructuresApi#structuresPdbListGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pdbCodes** | [**List&lt;String&gt;**](String.md)| PDB-codes for which all structures are requested. |

### Return type

[**List&lt;StructureDetails&gt;**](StructureDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

