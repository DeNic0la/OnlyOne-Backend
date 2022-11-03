package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

/**
 * Card
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-03T14:54:09.481151016+01:00[Europe/Zurich]")
public class Card {

  @JsonProperty("number")
  private Long number;

  /**
   * Gets or Sets color
   */
  public enum ColorEnum {
    BLUE("blue"),
    
    GREEN("green"),
    
    RED("red"),
    
    YELLOW("yellow");

    private String value;

    ColorEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ColorEnum fromValue(String value) {
      for (ColorEnum b : ColorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("color")
  private ColorEnum color;

  public Card number(Long number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * minimum: 1
   * maximum: 9
   * @return number
  */
  @Min(1L) @Max(9L) 
  @Schema(name = "number", example = "4", required = false)
  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Card color(ColorEnum color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  */
  
  @Schema(name = "color", example = "blue", required = false)
  public ColorEnum getColor() {
    return color;
  }

  public void setColor(ColorEnum color) {
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.number, card.number) &&
        Objects.equals(this.color, card.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, color);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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
}

