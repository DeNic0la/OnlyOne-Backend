/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Room;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-27T14:22:53.857087904+02:00[Europe/Zurich]")
@Validated
@Tag(name = "room", description = "Interacting with Rooms")
@RequestMapping("${openapi.onlyOne.base-path:}")
public interface RoomApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /room : Get all available rooms
     *
     * @return showing rooms (status code 200)
     */
    @Operation(
        operationId = "roomGet",
        summary = "Get all available rooms",
        tags = { "room" },
        responses = {
            @ApiResponse(responseCode = "200", description = "showing rooms", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/room",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Room>> roomGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"player_count\" : 4, \"name\" : \"Toms cool people club\", \"max_player_count\" : 10, \"id\" : 3, \"status\" : \"run\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /room/{id} : get Information about the Room/Game
     *
     * @param id  (required)
     * @param xUser  (optional)
     * @return Displaying room Information (status code 200)
     */
    @Operation(
        operationId = "roomIdGet",
        summary = "get Information about the Room/Game",
        tags = { "room", "game" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Displaying room Information", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/room/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Room> roomIdGet(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @Parameter(name = "x-user", description = "") @RequestHeader(value = "x-user", required = false) String xUser
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"player_count\" : 4, \"name\" : \"Toms cool people club\", \"max_player_count\" : 10, \"id\" : 3, \"status\" : \"run\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /room/{id} : Join a room
     *
     * @param id  (required)
     * @param xUser  (optional)
     * @return Joined room successfully (status code 200)
     */
    @Operation(
        operationId = "roomIdPost",
        summary = "Join a room",
        tags = { "room" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Joined room successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/room/{id}"
    )
    default ResponseEntity<Void> roomIdPost(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @Parameter(name = "x-user", description = "") @RequestHeader(value = "x-user", required = false) String xUser
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /room/{id} : leave a Room
     *
     * @param id  (required)
     * @param xUser  (optional)
     * @return left room sucessfully (status code 200)
     */
    @Operation(
        operationId = "roomIdPut",
        summary = "leave a Room",
        tags = { "room" },
        responses = {
            @ApiResponse(responseCode = "200", description = "left room sucessfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/room/{id}"
    )
    default ResponseEntity<Void> roomIdPut(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @Parameter(name = "x-user", description = "") @RequestHeader(value = "x-user", required = false) String xUser
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /room : Create a new Room
     *
     * @param body  (required)
     * @return Room Created (status code 201)
     *         or Room already exists (status code 405)
     */
    @Operation(
        operationId = "roomPost",
        summary = "Create a new Room",
        tags = { "room" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Room Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
            }),
            @ApiResponse(responseCode = "405", description = "Room already exists")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/room",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Room> roomPost(
        @Parameter(name = "body", description = "", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"player_count\" : 4, \"name\" : \"Toms cool people club\", \"max_player_count\" : 10, \"id\" : 3, \"status\" : \"run\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}