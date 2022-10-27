package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import java.util.Objects;

/**
 * Room
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-27T14:22:53.857087904+02:00[Europe/Zurich]")
public class Room {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("player_count")
  private Long playerCount;

  @JsonProperty("max_player_count")
  private Long maxPlayerCount = 10l;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    LOBBY("lobby"),
    
    RUN("run"),
    
    FINISHED("finished");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  public Room id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "3", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Room name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "Toms cool people club", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room playerCount(Long playerCount) {
    this.playerCount = playerCount;
    return this;
  }

  /**
   * Get playerCount
   * @return playerCount
  */
  
  @Schema(name = "player_count", example = "4", required = false)
  public Long getPlayerCount() {
    return playerCount;
  }

  public void setPlayerCount(Long playerCount) {
    this.playerCount = playerCount;
  }

  public Room maxPlayerCount(Long maxPlayerCount) {
    this.maxPlayerCount = maxPlayerCount;
    return this;
  }

  /**
   * Get maxPlayerCount
   * @return maxPlayerCount
  */
  
  @Schema(name = "max_player_count", example = "10", required = false)
  public Long getMaxPlayerCount() {
    return maxPlayerCount;
  }

  public void setMaxPlayerCount(Long maxPlayerCount) {
    this.maxPlayerCount = maxPlayerCount;
  }

  public Room status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", example = "run", required = false)
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.id, room.id) &&
        Objects.equals(this.name, room.name) &&
        Objects.equals(this.playerCount, room.playerCount) &&
        Objects.equals(this.maxPlayerCount, room.maxPlayerCount) &&
        Objects.equals(this.status, room.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, playerCount, maxPlayerCount, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    playerCount: ").append(toIndentedString(playerCount)).append("\n");
    sb.append("    maxPlayerCount: ").append(toIndentedString(maxPlayerCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

