/*
 * KLIFS API
 * Dynamically interact with the rich content of KLIFS: the structural kinase database
 *
 * OpenAPI spec version: 0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


/**
 * IDlist
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-05T09:28:37.207+02:00")
public class IDlist   {
  @SerializedName("kinase_ID")
  private Integer kinaseID = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("full_name")
  private String fullName = null;

  @SerializedName("species")
  private String species = null;

  public IDlist kinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
    return this;
  }

   /**
   * Get kinaseID
   * @return kinaseID
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getKinaseID() {
    return kinaseID;
  }

  public void setKinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
  }

  public IDlist name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IDlist fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

   /**
   * Get fullName
   * @return fullName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public IDlist species(String species) {
    this.species = species;
    return this;
  }

   /**
   * Get species
   * @return species
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IDlist iDlist = (IDlist) o;
    return Objects.equals(this.kinaseID, iDlist.kinaseID) &&
        Objects.equals(this.name, iDlist.name) &&
        Objects.equals(this.fullName, iDlist.fullName) &&
        Objects.equals(this.species, iDlist.species);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kinaseID, name, fullName, species);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IDlist {\n");
    
    sb.append("    kinaseID: ").append(toIndentedString(kinaseID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

