package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-18T09:34:14.459Z")
public class KinaseInformation   {
  
  private Integer kinaseID = null;
  private String name = null;
  private String HGNC = null;
  private String family = null;
  private String group = null;
  private String kinaseClass = null;
  private String species = null;
  private String fullName = null;
  private String uniprot = null;
  private String iuphar = null;
  private String pocket = null;

  
  /**
   **/
  public KinaseInformation kinaseID(Integer kinaseID) {
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
  public KinaseInformation name(String name) {
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
  public KinaseInformation HGNC(String HGNC) {
    this.HGNC = HGNC;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("HGNC")
  public String getHGNC() {
    return HGNC;
  }
  public void setHGNC(String HGNC) {
    this.HGNC = HGNC;
  }

  
  /**
   **/
  public KinaseInformation family(String family) {
    this.family = family;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("family")
  public String getFamily() {
    return family;
  }
  public void setFamily(String family) {
    this.family = family;
  }

  
  /**
   **/
  public KinaseInformation group(String group) {
    this.group = group;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("group")
  public String getGroup() {
    return group;
  }
  public void setGroup(String group) {
    this.group = group;
  }

  
  /**
   **/
  public KinaseInformation kinaseClass(String kinaseClass) {
    this.kinaseClass = kinaseClass;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("kinase_class")
  public String getKinaseClass() {
    return kinaseClass;
  }
  public void setKinaseClass(String kinaseClass) {
    this.kinaseClass = kinaseClass;
  }

  
  /**
   **/
  public KinaseInformation species(String species) {
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

  
  /**
   **/
  public KinaseInformation fullName(String fullName) {
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
  public KinaseInformation uniprot(String uniprot) {
    this.uniprot = uniprot;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("uniprot")
  public String getUniprot() {
    return uniprot;
  }
  public void setUniprot(String uniprot) {
    this.uniprot = uniprot;
  }

  
  /**
   **/
  public KinaseInformation iuphar(String iuphar) {
    this.iuphar = iuphar;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("iuphar")
  public String getIuphar() {
    return iuphar;
  }
  public void setIuphar(String iuphar) {
    this.iuphar = iuphar;
  }

  
  /**
   **/
  public KinaseInformation pocket(String pocket) {
    this.pocket = pocket;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("pocket")
  public String getPocket() {
    return pocket;
  }
  public void setPocket(String pocket) {
    this.pocket = pocket;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KinaseInformation kinaseInformation = (KinaseInformation) o;
    return Objects.equals(this.kinaseID, kinaseInformation.kinaseID) &&
        Objects.equals(this.name, kinaseInformation.name) &&
        Objects.equals(this.HGNC, kinaseInformation.HGNC) &&
        Objects.equals(this.family, kinaseInformation.family) &&
        Objects.equals(this.group, kinaseInformation.group) &&
        Objects.equals(this.kinaseClass, kinaseInformation.kinaseClass) &&
        Objects.equals(this.species, kinaseInformation.species) &&
        Objects.equals(this.fullName, kinaseInformation.fullName) &&
        Objects.equals(this.uniprot, kinaseInformation.uniprot) &&
        Objects.equals(this.iuphar, kinaseInformation.iuphar) &&
        Objects.equals(this.pocket, kinaseInformation.pocket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kinaseID, name, HGNC, family, group, kinaseClass, species, fullName, uniprot, iuphar, pocket);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KinaseInformation {\n");
    
    sb.append("    kinaseID: ").append(toIndentedString(kinaseID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    HGNC: ").append(toIndentedString(HGNC)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    kinaseClass: ").append(toIndentedString(kinaseClass)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    uniprot: ").append(toIndentedString(uniprot)).append("\n");
    sb.append("    iuphar: ").append(toIndentedString(iuphar)).append("\n");
    sb.append("    pocket: ").append(toIndentedString(pocket)).append("\n");
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

