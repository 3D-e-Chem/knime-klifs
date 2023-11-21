# LigandsApi

All URIs are relative to *https://klifs.net/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ligandsListGet**](LigandsApi.md#ligandsListGet) | **GET** /ligands_list | Get all co-crystallized ligands optionally restricted to a set of kinase IDs
[**ligandsListStructuresGet**](LigandsApi.md#ligandsListStructuresGet) | **GET** /ligands_list_structures | Get all structures in complex with one of the provided ligand IDs


<a name="ligandsListGet"></a>
# **ligandsListGet**
> List&lt;LigandDetails&gt; ligandsListGet(kinaseID)

Get all co-crystallized ligands optionally restricted to a set of kinase IDs

The Ligands List endpoint returns a list of co-crystallized ligands in KLIFS optiontally restricted to a set of specific kinase IDs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LigandsApi;


LigandsApi apiInstance = new LigandsApi();
List<Integer> kinaseID = Arrays.asList(56); // List<Integer> | ID(s) of the kinase(s) for which all structures are requested.
try {
    List<LigandDetails> result = apiInstance.ligandsListGet(kinaseID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LigandsApi#ligandsListGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the kinase(s) for which all structures are requested. | [optional]

### Return type

[**List&lt;LigandDetails&gt;**](LigandDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="ligandsListStructuresGet"></a>
# **ligandsListStructuresGet**
> List&lt;StructureDetails&gt; ligandsListStructuresGet(ligandID)

Get all structures in complex with one of the provided ligand IDs

The Ligands Get Structures endpoint returns a list of monomers of crystal structures in KLIFS in complex with provided ligand IDs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LigandsApi;


LigandsApi apiInstance = new LigandsApi();
List<Integer> ligandID = Arrays.asList(56); // List<Integer> | ID(s) of the ligand(s) for which all structures are requested.
try {
    List<StructureDetails> result = apiInstance.ligandsListStructuresGet(ligandID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LigandsApi#ligandsListStructuresGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ligandID** | [**List&lt;Integer&gt;**](Integer.md)| ID(s) of the ligand(s) for which all structures are requested. |

### Return type

[**List&lt;StructureDetails&gt;**](StructureDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

