# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InformationApi;

import java.io.File;
import java.util.*;

public class InformationApiExample {

    public static void main(String[] args) {
        
        InformationApi apiInstance = new InformationApi();
        String kinaseGroup = "kinaseGroup_example"; // String | Optional: Name (or multiple names separated by a comma) of the kinase group for which the kinase families are requested (e.g. TKL,STE).
        try {
            List<String> result = apiInstance.kinaseFamiliesGet(kinaseGroup);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InformationApi#kinaseFamiliesGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://klifs.net/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*InformationApi* | [**kinaseFamiliesGet**](docs/InformationApi.md#kinaseFamiliesGet) | **GET** /kinase_families | Kinase families
*InformationApi* | [**kinaseGroupsGet**](docs/InformationApi.md#kinaseGroupsGet) | **GET** /kinase_groups | Kinase groups
*InformationApi* | [**kinaseIDGet**](docs/InformationApi.md#kinaseIDGet) | **GET** /kinase_ID | Kinase ID
*InformationApi* | [**kinaseInformationGet**](docs/InformationApi.md#kinaseInformationGet) | **GET** /kinase_information | Kinase information
*InformationApi* | [**kinaseNamesGet**](docs/InformationApi.md#kinaseNamesGet) | **GET** /kinase_names | Kinase names
*InteractionsApi* | [**interactionsGetIFPGet**](docs/InteractionsApi.md#interactionsGetIFPGet) | **GET** /interactions_get_IFP | Get structure IFP
*InteractionsApi* | [**interactionsGetTypesGet**](docs/InteractionsApi.md#interactionsGetTypesGet) | **GET** /interactions_get_types | Get interaction types
*InteractionsApi* | [**interactionsMatchResiduesGet**](docs/InteractionsApi.md#interactionsMatchResiduesGet) | **GET** /interactions_match_residues | Match IFP residues
*LigandsApi* | [**ligandsListGet**](docs/LigandsApi.md#ligandsListGet) | **GET** /ligands_list | Get all co-crystallized ligands optionally restricted to a set of kinase IDs
*LigandsApi* | [**ligandsListStructuresGet**](docs/LigandsApi.md#ligandsListStructuresGet) | **GET** /ligands_list_structures | Get all structures in complex with one of the provided ligand IDs
*StructuresApi* | [**structureGetComplexGet**](docs/StructuresApi.md#structureGetComplexGet) | **GET** /structure_get_complex | Get full complex
*StructuresApi* | [**structureGetLigandGet**](docs/StructuresApi.md#structureGetLigandGet) | **GET** /structure_get_ligand | Get ligand from structure
*StructuresApi* | [**structureGetPocketGet**](docs/StructuresApi.md#structureGetPocketGet) | **GET** /structure_get_pocket | Get pocket from structure
*StructuresApi* | [**structureGetProteinGet**](docs/StructuresApi.md#structureGetProteinGet) | **GET** /structure_get_protein | Get protein from structure
*StructuresApi* | [**structuresListGet**](docs/StructuresApi.md#structuresListGet) | **GET** /structures_list | Get all structures based on a kinase ID
*StructuresApi* | [**structuresPdbListGet**](docs/StructuresApi.md#structuresPdbListGet) | **GET** /structures_pdb_list | Get all structures based on a set of PDB-codes


## Documentation for Models

 - [Error](docs/Error.md)
 - [IDlist](docs/IDlist.md)
 - [IFPList](docs/IFPList.md)
 - [InteractionList](docs/InteractionList.md)
 - [KinaseInformation](docs/KinaseInformation.md)
 - [LigandDetails](docs/LigandDetails.md)
 - [MatchList](docs/MatchList.md)
 - [StructureDetails](docs/StructureDetails.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



