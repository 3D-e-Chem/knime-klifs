package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-18T09:34:14.459Z")
public class IFPList   {
  
  private Integer structureID = null;
  private String IFP = null;

  
  /**
   **/
  public IFPList structureID(Integer structureID) {
    this.structureID = structureID;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("structure_ID")
  public Integer getStructureID() {
    return structureID;
  }
  public void setStructureID(Integer structureID) {
    this.structureID = structureID;
  }

  
  /**
   **/
  public IFPList IFP(String IFP) {
    this.IFP = IFP;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("IFP")
  public String getIFP() {
    return IFP;
  }
  public void setIFP(String IFP) {
    this.IFP = IFP;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IFPList iFPList = (IFPList) o;
    return Objects.equals(this.structureID, iFPList.structureID) &&
        Objects.equals(this.IFP, iFPList.IFP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(structureID, IFP);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IFPList {\n");
    
    sb.append("    structureID: ").append(toIndentedString(structureID)).append("\n");
    sb.append("    IFP: ").append(toIndentedString(IFP)).append("\n");
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

