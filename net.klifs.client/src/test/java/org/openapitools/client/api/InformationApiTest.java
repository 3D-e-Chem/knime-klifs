/*
 * KLIFS API
 * Dynamically interact with the rich content of KLIFS: the structural kinase database
 *
 * The version of the OpenAPI document: 0.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.IDlist;
import org.openapitools.client.model.KinaseInformation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for InformationApi
 */
@Disabled
public class InformationApiTest {

    private final InformationApi api = new InformationApi();

    /**
     * Kinase families
     *
     * The Kinase families endpoint returns a list of all available kinase families in KLIFS. When a kinase group is specified only those kinase families that are within that kinase group are returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void kinaseFamiliesGetTest() throws ApiException {
        String kinaseGroup = null;
        List<String> response = api.kinaseFamiliesGet(kinaseGroup);
        // TODO: test validations
    }

    /**
     * Kinase groups
     *
     * The Kinase groups endpoint returns a list of all available kinase groups in KLIFS. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void kinaseGroupsGetTest() throws ApiException {
        List<String> response = api.kinaseGroupsGet();
        // TODO: test validations
    }

    /**
     * Kinase ID
     *
     * The Kinase ID endpoint returns the KLIFS ID of a specific kinase based on the abbreviated kinase name (e.g. ABL1) or UniProt ID (e.g. P00519). The kinase names from Manning et al., the HUGO Gene Nomenclature Committee, and the MGI are recognized. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void kinaseIDGetTest() throws ApiException {
        String kinaseName = null;
        String species = null;
        List<KinaseInformation> response = api.kinaseIDGet(kinaseName, species);
        // TODO: test validations
    }

    /**
     * Kinase information
     *
     * The Kinase information endpoint returns a list of information related to the requested kinase (Uniprot, pocket sequence, etc.). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void kinaseInformationGetTest() throws ApiException {
        List<Integer> kinaseID = null;
        String species = null;
        List<KinaseInformation> response = api.kinaseInformationGet(kinaseID, species);
        // TODO: test validations
    }

    /**
     * Kinase names
     *
     * The Kinase names endpoint returns a list of all available kinases in KLIFS according using the HGNC gene symbols. When a kinase group or kinase family is specified only those kinase names that are within that kinase group or kinase family are returned. When both a group and a family are specified, only the family is used to process the request. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void kinaseNamesGetTest() throws ApiException {
        String kinaseGroup = null;
        String kinaseFamily = null;
        String species = null;
        List<IDlist> response = api.kinaseNamesGet(kinaseGroup, kinaseFamily, species);
        // TODO: test validations
    }

}
