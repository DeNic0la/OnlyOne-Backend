package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.Card;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GameStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-27T14:22:53.857087904+02:00[Europe/Zurich]")
public class GameStatus {

  @JsonProperty("card")
  private Card card;

  @JsonProperty("is_your_turn")
  private Boolean isYourTurn;

  public GameStatus card(Card card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   * @return card
  */
  @Valid 
  @Schema(name = "card", required = false)
  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public GameStatus isYourTurn(Boolean isYourTurn) {
    this.isYourTurn = isYourTurn;
    return this;
  }

  /**
   * Get isYourTurn
   * @return isYourTurn
  */
  
  @Schema(name = "is_your_turn", example = "true", required = false)
  public Boolean getIsYourTurn() {
    return isYourTurn;
  }

  public void setIsYourTurn(Boolean isYourTurn) {
    this.isYourTurn = isYourTurn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameStatus gameStatus = (GameStatus) o;
    return Objects.equals(this.card, gameStatus.card) &&
        Objects.equals(this.isYourTurn, gameStatus.isYourTurn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(card, isYourTurn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameStatus {\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    isYourTurn: ").append(toIndentedString(isYourTurn)).append("\n");
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

