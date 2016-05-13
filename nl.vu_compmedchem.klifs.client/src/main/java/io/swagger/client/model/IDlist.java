package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-13T12:15:53.243Z")
public class IDlist   {
  
  private Integer kinaseID = null;
  private String name = null;
  private String fullName = null;
  private String species = null;

  
  /**
   **/
  public IDlist kinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("kinase_ID")
  public Integer getKinaseID() {
    return kinaseID;
  }
  public void setKinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
  }

  
  /**
   **/
  public IDlist name(String name) {
    this.name = name;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  public IDlist fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("full_name")
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  
  /**
   **/
  public IDlist species(String species) {
    this.species = species;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("species")
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

