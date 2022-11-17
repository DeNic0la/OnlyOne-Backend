package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Objects;

/**
 * GameStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-03T14:54:09.481151016+01:00[Europe/Zurich]")
@Builder
public class GameStatus {

  @JsonProperty("card")
  private Card topCard;

  @JsonProperty("is_your_turn")
  private Boolean isYourTurn;

  public GameStatus card(Card card) {
    this.topCard = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  @Valid
  @Schema(name = "card", required = false)
  public Card getTopCard() {
    return topCard;
  }

  public void setTopCard(Card topCard) {
    this.topCard = topCard;
  }

  public GameStatus isYourTurn(Boolean isYourTurn) {
    this.isYourTurn = isYourTurn;
    return this;
  }

  /**
   * Get isYourTurn
   *
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
    return Objects.equals(this.topCard, gameStatus.topCard) &&
            Objects.equals(this.isYourTurn, gameStatus.isYourTurn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topCard, isYourTurn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameStatus {\n");
    sb.append("    card: ").append(toIndentedString(topCard)).append("\n");
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

