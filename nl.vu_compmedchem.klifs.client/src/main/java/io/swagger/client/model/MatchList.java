package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-19T07:51:24.422Z")
public class MatchList   {
  
  private Integer index = null;
  private String xrayPosition = null;
  private String kLIFSPosition = null;

  
  /**
   **/
  public MatchList index(Integer index) {
    this.index = index;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("index")
  public Integer getIndex() {
    return index;
  }
  public void setIndex(Integer index) {
    this.index = index;
  }

  
  /**
   **/
  public MatchList xrayPosition(String xrayPosition) {
    this.xrayPosition = xrayPosition;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("Xray_position")
  public String getXrayPosition() {
    return xrayPosition;
  }
  public void setXrayPosition(String xrayPosition) {
    this.xrayPosition = xrayPosition;
  }

  
  /**
   **/
  public MatchList kLIFSPosition(String kLIFSPosition) {
    this.kLIFSPosition = kLIFSPosition;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("KLIFS_position")
  public String getKLIFSPosition() {
    return kLIFSPosition;
  }
  public void setKLIFSPosition(String kLIFSPosition) {
    this.kLIFSPosition = kLIFSPosition;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchList matchList = (MatchList) o;
    return Objects.equals(this.index, matchList.index) &&
        Objects.equals(this.xrayPosition, matchList.xrayPosition) &&
        Objects.equals(this.kLIFSPosition, matchList.kLIFSPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, xrayPosition, kLIFSPosition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchList {\n");
    
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    xrayPosition: ").append(toIndentedString(xrayPosition)).append("\n");
    sb.append("    kLIFSPosition: ").append(toIndentedString(kLIFSPosition)).append("\n");
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

