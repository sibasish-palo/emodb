package com.bazaarvoice.emodb.uac.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

/**
 * Exception thrown when attempting to modify a role which does not exist.
 */
@JsonIgnoreProperties({"cause", "localizedMessage", "stackTrace"})
public class EmoRoleNotFoundException extends RuntimeException {
    private final String _group;
    private final String _id;

    public EmoRoleNotFoundException() {
        this("unknown", "unknown");
    }

    @JsonCreator
    public EmoRoleNotFoundException(@JsonProperty("group") String group, @JsonProperty("id") String id) {
        super("Role not found");
        _group = Optional.ofNullable(group).orElse(EmoRoleKey.NO_GROUP);
        _id = id;
    }

    public String getGroup() {
        return _group;
    }

    public String getId() {
        return _id;
    }
}