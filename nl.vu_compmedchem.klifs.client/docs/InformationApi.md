# InformationApi

All URIs are relative to *http://klifs.vu-compmedchem.nl/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**kinaseFamiliesGet**](InformationApi.md#kinaseFamiliesGet) | **GET** /kinase_families | Kinase families
[**kinaseGroupsGet**](InformationApi.md#kinaseGroupsGet) | **GET** /kinase_groups | Kinase groups
[**kinaseIDGet**](InformationApi.md#kinaseIDGet) | **GET** /kinase_ID | Kinase ID
[**kinaseInformationGet**](InformationApi.md#kinaseInformationGet) | **GET** /kinase_information | Kinase information
[**kinaseNamesGet**](InformationApi.md#kinaseNamesGet) | **GET** /kinase_names | Kinase names


<a name="kinaseFamiliesGet"></a>
# **kinaseFamiliesGet**
> List&lt;String&gt; kinaseFamiliesGet(kinaseGroup)

Kinase families

The Kinase families endpoint returns a list of all available kinase families in KLIFS. When a kinase group is specified only those kinase families that are within that kinase group are returned. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InformationApi;


InformationApi apiInstance = new InformationApi();
String kinaseGroup = "kinaseGroup_example"; // String | Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE).
try {
    List<String> result = apiInstance.kinaseFamiliesGet(kinaseGroup);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationApi#kinaseFamiliesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseGroup** | **String**| Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE). | [optional]

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="kinaseGroupsGet"></a>
# **kinaseGroupsGet**
> List&lt;String&gt; kinaseGroupsGet()

Kinase groups

The Kinase groups endpoint returns a list of all available kinase groups in KLIFS. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InformationApi;


InformationApi apiInstance = new InformationApi();
try {
    List<String> result = apiInstance.kinaseGroupsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationApi#kinaseGroupsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="kinaseIDGet"></a>
# **kinaseIDGet**
> List&lt;KinaseInformation&gt; kinaseIDGet(kinaseName, species)

Kinase ID

The Kinase ID endpoint returns the KLIFS ID of a specific kinase based on the abbreviated kinase name (e.g. ABL1) or UniProt ID (e.g. P00519). The kinase names from Manning et al., the HUGO Gene Nomenclature Committee, and the MGI are recognized. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InformationApi;


InformationApi apiInstance = new InformationApi();
String kinaseName = "kinaseName_example"; // String | The name (or multiple names separated by a comma) of (a) specfic kinase(s) (e.g. ABL1).
String species = "species_example"; // String | Optional: Species for which the kinase ID are requested (e.g. HUMAN OR MOUSE).
try {
    List<KinaseInformation> result = apiInstance.kinaseIDGet(kinaseName, species);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationApi#kinaseIDGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseName** | **String**| The name (or multiple names separated by a comma) of (a) specfic kinase(s) (e.g. ABL1). |
 **species** | **String**| Optional: Species for which the kinase ID are requested (e.g. HUMAN OR MOUSE). | [optional]

### Return type

[**List&lt;KinaseInformation&gt;**](KinaseInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="kinaseInformationGet"></a>
# **kinaseInformationGet**
> List&lt;KinaseInformation&gt; kinaseInformationGet(kinaseID, species)

Kinase information

The Kinase information endpoint returns a list of information related to the requested kinase (Uniprot, pocket sequence, etc.). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InformationApi;


InformationApi apiInstance = new InformationApi();
List<Integer> kinaseID = Arrays.asList(56); // List<Integer> | ID (or IDs separated by a comma) of the kinase for which the kinase information is requested.
String species = "species_example"; // String | Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE).
try {
    List<KinaseInformation> result = apiInstance.kinaseInformationGet(kinaseID, species);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationApi#kinaseInformationGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseID** | [**List&lt;Integer&gt;**](Integer.md)| ID (or IDs separated by a comma) of the kinase for which the kinase information is requested. | [optional]
 **species** | **String**| Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE). | [optional]

### Return type

[**List&lt;KinaseInformation&gt;**](KinaseInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="kinaseNamesGet"></a>
# **kinaseNamesGet**
> List&lt;IDlist&gt; kinaseNamesGet(kinaseGroup, kinaseFamily, species)

Kinase names

The Kinase names endpoint returns a list of all available kinases in KLIFS according using the HGNC gene symbols. When a kinase group or kinase family is specified only those kinase names that are within that kinase group or kinase family are returned. When both a group and a family are specified, only the family is used to process the request. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InformationApi;


InformationApi apiInstance = new InformationApi();
String kinaseGroup = "kinaseGroup_example"; // String | Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE).
String kinaseFamily = "kinaseFamily_example"; // String | Optional: Name (or multiple names separated by a comma) of the kinase family for which the kinase names are requested (e.g. AUR,WEE).
String species = "species_example"; // String | Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE).
try {
    List<IDlist> result = apiInstance.kinaseNamesGet(kinaseGroup, kinaseFamily, species);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationApi#kinaseNamesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **kinaseGroup** | **String**| Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE). | [optional]
 **kinaseFamily** | **String**| Optional: Name (or multiple names separated by a comma) of the kinase family for which the kinase names are requested (e.g. AUR,WEE). | [optional]
 **species** | **String**| Optional: Species for which the kinase names are requested (e.g. HUMAN OR MOUSE). | [optional]

### Return type

[**List&lt;IDlist&gt;**](IDlist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

