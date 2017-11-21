package io.swagger.v3.jaxrs2.resources.petstore.link;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.links.LinkParameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Class with Links
 * Created by rafaellopez on 11/19/17.
 */
public class LinksResource {
    @Path("/users")
    @Operation(operationId = "getUser",
            responses = {
                    @ApiResponse(description = "test description",
                            content = @Content(mediaType = "*/*", schema = @Schema(ref = "#/components/schemas/User")),
                            links = {
                                    @Link(
                                            name = "address",
                                            operationId = "getAddress",
                                            parameters = @LinkParameter(
                                                    name = "userId",
                                                    expression = "$request.query.userId"))
                            })}
    )
    @GET
    public String getUser(@QueryParam("userId") String userId) {
        return null;
    }

    @Path("/users")
    @Operation(operationId = "getUser",
            responses = {
                    @ApiResponse(description = "test description",
                            links = {
                                    @Link(
                                            name = "user",
                                            operationId = "getUser",
                                            operationRef = "#/components/links/MyLink",
                                            parameters = @LinkParameter(
                                                    name = "userId",
                                                    expression = "$request.query.userId"))
                            })}
    )
    @GET
    public String getUsers(@QueryParam("userId") String userId) {
        return null;
    }

}