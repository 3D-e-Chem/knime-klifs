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


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * BioactivityDetails
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-21T14:12:18.837505154+01:00[Europe/Amsterdam]")
public class BioactivityDetails {
  public static final String SERIALIZED_NAME_PREF_NAME = "pref_name";
  @SerializedName(SERIALIZED_NAME_PREF_NAME)
  private String prefName;

  public static final String SERIALIZED_NAME_ACCESSION = "accession";
  @SerializedName(SERIALIZED_NAME_ACCESSION)
  private String accession;

  public static final String SERIALIZED_NAME_ORGANISM = "organism";
  @SerializedName(SERIALIZED_NAME_ORGANISM)
  private String organism;

  public static final String SERIALIZED_NAME_STANDARD_TYPE = "standard_type";
  @SerializedName(SERIALIZED_NAME_STANDARD_TYPE)
  private String standardType;

  public static final String SERIALIZED_NAME_STANDARD_RELATION = "standard_relation";
  @SerializedName(SERIALIZED_NAME_STANDARD_RELATION)
  private String standardRelation;

  public static final String SERIALIZED_NAME_STANDARD_VALUE = "standard_value";
  @SerializedName(SERIALIZED_NAME_STANDARD_VALUE)
  private Float standardValue;

  public static final String SERIALIZED_NAME_STANDARD_UNITS = "standard_units";
  @SerializedName(SERIALIZED_NAME_STANDARD_UNITS)
  private String standardUnits;

  public static final String SERIALIZED_NAME_PCHEMBL_VALUE = "pchembl_value";
  @SerializedName(SERIALIZED_NAME_PCHEMBL_VALUE)
  private Float pchemblValue;

  public BioactivityDetails() {
  }

  public BioactivityDetails prefName(String prefName) {
    
    this.prefName = prefName;
    return this;
  }

   /**
   * The full kinase name from ChEMBL
   * @return prefName
  **/
  @javax.annotation.Nullable
  public String getPrefName() {
    return prefName;
  }


  public void setPrefName(String prefName) {
    this.prefName = prefName;
  }


  public BioactivityDetails accession(String accession) {
    
    this.accession = accession;
    return this;
  }

   /**
   * The UniProt accession code
   * @return accession
  **/
  @javax.annotation.Nullable
  public String getAccession() {
    return accession;
  }


  public void setAccession(String accession) {
    this.accession = accession;
  }


  public BioactivityDetails organism(String organism) {
    
    this.organism = organism;
    return this;
  }

   /**
   * Organism
   * @return organism
  **/
  @javax.annotation.Nullable
  public String getOrganism() {
    return organism;
  }


  public void setOrganism(String organism) {
    this.organism = organism;
  }


  public BioactivityDetails standardType(String standardType) {
    
    this.standardType = standardType;
    return this;
  }

   /**
   * The type of bioactivity
   * @return standardType
  **/
  @javax.annotation.Nullable
  public String getStandardType() {
    return standardType;
  }


  public void setStandardType(String standardType) {
    this.standardType = standardType;
  }


  public BioactivityDetails standardRelation(String standardRelation) {
    
    this.standardRelation = standardRelation;
    return this;
  }

   /**
   * Exact measurement, or lower than/higher than? Note, this relates to the standard_value
   * @return standardRelation
  **/
  @javax.annotation.Nullable
  public String getStandardRelation() {
    return standardRelation;
  }


  public void setStandardRelation(String standardRelation) {
    this.standardRelation = standardRelation;
  }


  public BioactivityDetails standardValue(Float standardValue) {
    
    this.standardValue = standardValue;
    return this;
  }

   /**
   * The standard activity value as annotated by ChEMBL
   * @return standardValue
  **/
  @javax.annotation.Nullable
  public Float getStandardValue() {
    return standardValue;
  }


  public void setStandardValue(Float standardValue) {
    this.standardValue = standardValue;
  }


  public BioactivityDetails standardUnits(String standardUnits) {
    
    this.standardUnits = standardUnits;
    return this;
  }

   /**
   * The unit of the standard activity value as annotated by ChEMBL
   * @return standardUnits
  **/
  @javax.annotation.Nullable
  public String getStandardUnits() {
    return standardUnits;
  }


  public void setStandardUnits(String standardUnits) {
    this.standardUnits = standardUnits;
  }


  public BioactivityDetails pchemblValue(Float pchemblValue) {
    
    this.pchemblValue = pchemblValue;
    return this;
  }

   /**
   * The standardized -Log10 value by ChEMBL
   * @return pchemblValue
  **/
  @javax.annotation.Nullable
  public Float getPchemblValue() {
    return pchemblValue;
  }


  public void setPchemblValue(Float pchemblValue) {
    this.pchemblValue = pchemblValue;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BioactivityDetails bioactivityDetails = (BioactivityDetails) o;
    return Objects.equals(this.prefName, bioactivityDetails.prefName) &&
        Objects.equals(this.accession, bioactivityDetails.accession) &&
        Objects.equals(this.organism, bioactivityDetails.organism) &&
        Objects.equals(this.standardType, bioactivityDetails.standardType) &&
        Objects.equals(this.standardRelation, bioactivityDetails.standardRelation) &&
        Objects.equals(this.standardValue, bioactivityDetails.standardValue) &&
        Objects.equals(this.standardUnits, bioactivityDetails.standardUnits) &&
        Objects.equals(this.pchemblValue, bioactivityDetails.pchemblValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prefName, accession, organism, standardType, standardRelation, standardValue, standardUnits, pchemblValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BioactivityDetails {\n");
    sb.append("    prefName: ").append(toIndentedString(prefName)).append("\n");
    sb.append("    accession: ").append(toIndentedString(accession)).append("\n");
    sb.append("    organism: ").append(toIndentedString(organism)).append("\n");
    sb.append("    standardType: ").append(toIndentedString(standardType)).append("\n");
    sb.append("    standardRelation: ").append(toIndentedString(standardRelation)).append("\n");
    sb.append("    standardValue: ").append(toIndentedString(standardValue)).append("\n");
    sb.append("    standardUnits: ").append(toIndentedString(standardUnits)).append("\n");
    sb.append("    pchemblValue: ").append(toIndentedString(pchemblValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("pref_name");
    openapiFields.add("accession");
    openapiFields.add("organism");
    openapiFields.add("standard_type");
    openapiFields.add("standard_relation");
    openapiFields.add("standard_value");
    openapiFields.add("standard_units");
    openapiFields.add("pchembl_value");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to BioactivityDetails
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BioactivityDetails.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BioactivityDetails is not found in the empty JSON string", BioactivityDetails.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BioactivityDetails.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `BioactivityDetails` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("pref_name") != null && !jsonObj.get("pref_name").isJsonNull()) && !jsonObj.get("pref_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pref_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pref_name").toString()));
      }
      if ((jsonObj.get("accession") != null && !jsonObj.get("accession").isJsonNull()) && !jsonObj.get("accession").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accession` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accession").toString()));
      }
      if ((jsonObj.get("organism") != null && !jsonObj.get("organism").isJsonNull()) && !jsonObj.get("organism").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organism` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organism").toString()));
      }
      if ((jsonObj.get("standard_type") != null && !jsonObj.get("standard_type").isJsonNull()) && !jsonObj.get("standard_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `standard_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("standard_type").toString()));
      }
      if ((jsonObj.get("standard_relation") != null && !jsonObj.get("standard_relation").isJsonNull()) && !jsonObj.get("standard_relation").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `standard_relation` to be a primitive type in the JSON string but got `%s`", jsonObj.get("standard_relation").toString()));
      }
      if ((jsonObj.get("standard_units") != null && !jsonObj.get("standard_units").isJsonNull()) && !jsonObj.get("standard_units").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `standard_units` to be a primitive type in the JSON string but got `%s`", jsonObj.get("standard_units").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BioactivityDetails.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BioactivityDetails' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BioactivityDetails> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BioactivityDetails.class));

       return (TypeAdapter<T>) new TypeAdapter<BioactivityDetails>() {
           @Override
           public void write(JsonWriter out, BioactivityDetails value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BioactivityDetails read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of BioactivityDetails given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of BioactivityDetails
  * @throws IOException if the JSON string is invalid with respect to BioactivityDetails
  */
  public static BioactivityDetails fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BioactivityDetails.class);
  }

 /**
  * Convert an instance of BioactivityDetails to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

